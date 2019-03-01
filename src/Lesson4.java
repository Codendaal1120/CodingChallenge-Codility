import java.util.Arrays;
import java.util.Hashtable;
/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/
 * @author codendaal
 * PermCheck - 2 attempts
 * FrogRiverOne - 1 attempt (90%)
 * MissingInteger - 1 attempt
 * MaxCounters - 1 attempt (77%)
 */
public class Lesson4 {
	
	public Lesson4() {
		//PermCheck
		/*
		int[] a = { 2, 3, 1, 5 };
		int[] b = { 2, 3, 1, 5, 4 };
		int[] f = { 1 };
		System.out.println("PermCheck = " + m.PermCheck2(f));
		*/
		
		//FrogRiverOne
		/*
		int[] a = { 1, 3, 1, 4, 2, 3, 5, 4};
		System.out.println("FrogRiverOne = " + m.FrogRiverOne(5, a));
		*/
		
		//MissingInteger
		//int[] a = { 1, 3, 1, 4, 2, 3, 5, 4};
		//System.out.println("MissingInteger = " + MissingInteger(a));		
	}
	
	//Medium
	public int[] MaxCounters(int N, int[] A) {
		
		/*https://github.com/jlhuang/codility-lessons/blob/master/lesson%202%20:%20Counting%20Elements/MaxCounters/Solution.java
		 * performance could have been improved by storing the last reset value and instead of filling each time, 
		 * just replace value when you set it, as it has to be greater or equal to this value...
		 */
		
		/*
		Notes:

		(0, 0, 1, 0, 0) - l0 = 3 - 1 x 3
		(0, 0, 1, 1, 0) - l1 = 4 - 1 x 4
		(0, 0, 1, 2, 0) - l2 = 4 - 2 x 4
		(2, 2, 2, 2, 2) - l3 = 6 - increases all counters to max, which is 2 (4 x 2)
		(3, 2, 2, 2, 2) - l4 = 1 - 3 x 1
		(3, 2, 2, 3, 2) - l5 = 4 - 3 x 4
		(3, 2, 2, 4, 2) - l6 = 4 - 4 x 4


		*/
		
		int[] counter = new int[N];
        int currMax = 0;

        for (int i = 0; i < A.length; i++){
         
        	if (A[i] > N){
              //reset all values
              Arrays.fill(counter, currMax);
        	}
        	else{
              counter[A[i] - 1]++;
              currMax = Math.max(currMax, counter[A[i] - 1]);
        	}
            
        }
        
        return counter;
	}
	
	public int MissingInteger(int[] A) {
		System.out.println("MissingInteger");
		
		Arrays.sort(A);
        int min = 1; //smallest positive int possible
        
        for (int i = 0; i < A.length; i++){
            
            if (A[i] > 0){
                if (A[i] == min){
                    min++;
                }   
            }   
        }
        
        return min;
	}
	
	public int PermCheck(int[] A) {
		
		//this solution will not work as [1, 4, 1] sums to 6, but so does [1, 2, 3]
		
		long total = A.length * (A.length + 1) / 2;
		long sum = 0;
		
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		
		if (sum == total) {
			return 1;
		}
		else {
			return 0;
		}
		
		//System.out.println("total = " + total);
	}
	
	public int PermCheck2(int[] A) {
		
		Arrays.sort(A);
		int expect = 1;
		
		 for (int i = 0; i < A.length; i++){
             
             if (expect != A[i]){
                 return 0;
             }
             
             expect++;
         }
		 
		 return 1;
		
		//System.out.println("total = " + total);
	}
	
	public int FrogRiverOne(int X, int[] A) {
		
		long total = X * (X + 1) / 2; //once I have this total, all leaves are in place
        long countTotal = 0;
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>(); 
        
        for (int i = 0; i < A.length; i++){
            
            if (A[i] <= X){
                if (ht.containsKey(A[i])){
                	ht.put(A[i], Math.min((int)ht.get(A[i]), i));
                }
                else{
                    ht.put(A[i], i);
                    countTotal += A[i];
                }    
            }   
            
            if (countTotal == total){
                break;
            }
        }
        
        if (countTotal == total){
            //return 99;
        	int maxTime = 0;
        	for (int key: ht.keySet()) {
        		maxTime = Math.max(maxTime, ht.get(key));
        	}
        	
        	return maxTime;
        	
        }
        else{
            return -1;
        }
		
	}


}
