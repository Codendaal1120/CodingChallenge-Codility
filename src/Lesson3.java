import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

/**
 * @author codendaal
 * https://app.codility.com/programmers/lessons/3-time_complexity/
 * TapeEquilibrium 1 attempt (83%)
 * FrogJmp - 1 attempt
 * PermMissingElem - 3 attempts
 */
public class Lesson3 {

	public Lesson3() {
		/*TapeEquilibrium*/
		/*
		int[] a = { 3, 1, 2, 4, 3 };
		int[] b = {-5, -6, -1, -22, -25, -10, -3};
		
		int[] c = {-1000, 1000};
		
		m.TapeEquilibrium(c);
		m.TapeEquilibrium_fix(c);
		*/
		
		/*PermMissingElem*/
		/*
		int[] a = { 2, 3, 1, 5 };
		int[] b = {7,4,6,9,5,3,8,2};
		int[] c = {1, 2, 3};
		int[] d = {1};
		System.out.println("PermMissingElem = " + m.PermMissingElem(c));
		//System.out.println("PermMissingElem = " + m.PermMissingElem_Sol(b));
		//m.PermMissingElem();
		*/		
		
	
	}
	
	public void TapeEquilibrium(int[] A) {
		//Got 83% for Correctness [-1000, 1000] fails;
		
		int len = A.length;
        int minDiff = 0;
        int sum = 0;
        int[] prefix_sums = new int[len];
        
        for (int i = 0; i < len; i++){
            //get prefix sums for each element
            sum += A[i];
            prefix_sums[i] = sum;
        }
        
        System.out.println("prefix_sums = " + Arrays.toString(A));
        
        /* This is causing my failure when we deal with negatives 
         * Instead of using max sum value (which may be 0 if values are negative), use max int*/
        //minDiff = Math.abs(prefix_sums[len -1]);
        minDiff = 2147483647;
        
        //looping same array so does not add to compleixty
        for (int i = 0; i < len; i++){
            
        	int left = prefix_sums[i];
            int right = prefix_sums[A.length -1] - prefix_sums[i];
            int diff = Math.abs(left - right);
            minDiff = Math.min(minDiff, diff);
        
            minDiff = Math.min(minDiff, Math.abs( prefix_sums[i] - (prefix_sums[A.length -1] - prefix_sums[i] )));    
        }
        
        System.out.println("min diff = " + minDiff);
	}
	
	public void TapeEquilibrium_fix(int[] A) {
		//Got 83% for Correctness [-1000, 1000] fails;
		
		int len = A.length;
        int minDiff = 0;
        int sum = 0;
        int[] prefix_sums = new int[len];
        
        for (int i = 0; i < len; i++){
            //get prefix sums for each element
            sum += A[i];
            prefix_sums[i] = sum;
        }
        
        System.out.println("prefix_sums = " + Arrays.toString(A));
        
        /* This is causing my failure when we deal with negatives 
         * Instead of using max sum value (which may be 0 if values are negative), use max int*/
        //minDiff = Math.abs(prefix_sums[len -1]);
        minDiff = 2147483647;
        
        //looping same array so does not add to compleixty
        if (len == 2) {
        	minDiff = Math.abs( A[0] - A[1] );
        }
        else {
        	for (int i = 0; i < len; i++){
	            
        		/*
	        	int left = prefix_sums[i];
	            int right = prefix_sums[len -1] - prefix_sums[i];
	            int diff = Math.abs(left - right);
	            minDiff = Math.min(minDiff, diff);
	            */
	        
	            minDiff = Math.min(minDiff, Math.abs( prefix_sums[i] - (prefix_sums[A.length -1] - prefix_sums[i] )));    
	        }
        }
	        
        
        System.out.println("min diff fixed = " + minDiff);
	}
	
	public void FrogJmp(int X, int Y, int D) {
		int jumps = 0;
		
		 if ((Y - X) % D == 0){
			 jumps = (Y - X) / D;
		 }
		 else{
        	jumps = ((Y - X) / D) + 1;   
		 }		
	}
	
	public int PermMissingElem(int[] A) {
		
		if (A.length > 0) {
			Arrays.sort(A);
			int expect = 1;
			
		    for (int i = 0; i < A.length; i++){
               
                if (expect != A[i]){
                    return expect;
                }
                
                expect++;
            }
			
			return expect;
		}
		else {
			return 1;
		}
	}
	
}
