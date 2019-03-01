import java.lang.*;
import java.util.Arrays;

/**
 * @author codendaal
 * https://app.codility.com/programmers/lessons/2-arrays/
 * BinaryGap - 1 attempt
 * OddOccurrencesInArray - 1 attempt
 * CyclicRotation - 5 attempts
 */
public class Lesson2 {

	public void cdArrays() {
		
		/*OddOccurrencesInArray
		int[] a = { 9, 3, 9, 3, 9, 7, 9 };
		int[] b = { 9, 3, 9, 3, 9, 7, 9, 7, 1 };
		System.out.println("OddOccurrencesInArray = " + m.OddOccurrencesInArray(a));
		System.out.println("OddOccurrencesInArray = " + m.OddOccurrencesInArray(b));
		*/
		
		/*CyclicRotation*/		
		
		int[] a = { 3, 8, 9, 7, 6 }; //3 - [9, 7, 6, 3, 8]
		int[] b = { 2, 3, 4, 5, 6, 7, 1 }; //3 - [7, 6, 3, 8, 9]
		int[] c = {5, -1000};
		
		CyclicRotation(a, 3);
		CyclicRotation(b, 6);
		CyclicRotation(b, 10);
		//m.CyclicRotation(a, 9);
		//m.CyclicRotation(c, 2);		
		 
	}
	
	public int OddOccurrencesInArray(int[] A) {
		
		Arrays.sort(A);
	        
        for (int i = 0; i < A.length; i++){
            
            if (i < A.length -1){
            	
            	//compare this element with the next one
                if (A[i] == A[i + 1]){
                    i++;
                }
                else{
                    return A[i];       
                }
            }
            else{
            	//return this element if it is the last element in the array
                return A[i];
            }            
        }
        
        return 0;
	}

	public void CyclicRotation(int[] A, int K) {
		
		if (A.length > 0) {
			int[] B = new int[A.length];
	        int idx = 0;
	        
	        //determine starting index in original array
	        if (K == 0){
	            //no rotations will be straight copy
	            idx = 0;
	        }
	        else if (K == A.length){
	            //rotations same as length also means straight copy
	            idx = 0;
	        }
	        else if (K <= A.length){
	            idx = A.length - K;   
	        }
	        else if (A.length == 1) {
	        	//multiple loops
	        	idx = 0;
	        }
	        else {
	        	//multiple loops
	        	idx = A.length - (K % (A.length));
	        }
	        
	        for (int i = 0; i < A.length; i++){
	            
	        	B[i] = A[idx];
	        	
	        	idx++;
	        	
	            if (idx > A.length - 1) {
	                //loop around
	                idx = 0;
	            }
	        }
	        
	        System.out.println(Arrays.toString(A) + " --> " + K + " --> " + Arrays.toString(B));
	        //return B;
		}
		else {
			//return A;
		}
			
	}
	
	
}
