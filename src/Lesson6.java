import java.util.Arrays;

/**
 * @author codendaal
 * https://app.codility.com/programmers/lessons/2-arrays/
 * Distinct - 1 attempt
 * Triangle - 2 attempt (68 %)
 * NumberOfDiscIntersections - 1 attampt (56%) - performance
 */
public class Lesson6 {

	public int Distinct(int[] A) {
		
		 Arrays.sort(A);
	        int last = 1000001;
	        int counter = 0;
	        
	        for (int i = 0; i < A.length; i++){
	            
	            if (A[i] != last){
	                last = A[i];
	                counter++;
	            }
	                
	        }
	        
	        return counter;
	}

	//533
	public int Triangle(int[] A) {
		int N = A.length;
        
        for (int i = 0; i < N; i++){
            
            int P = A[i];
            
            for (int j = i + 1; j < N; j++){
            
                int Q = A[j];
             
                for (int k = j + 1; k < N; k++){
                    
                    int R = A[k];
                    
                    if ((P + Q > R) && (Q + R > P) && (R + P > Q)){
	                    return 1;
	                } 
                }
            }
        }
        
        return 0;
        
        /* Tests
        [] - Empty --> 0
        [1,2,3] --> 0
        */
        
	}
	
	public int Triangle_Solution(int[] A) {
		int N = A.length;
        if (N < 3)
            return 0;
        // using the built-in sort method because it can perform O(N*log(N))
        // time complexity at the worst case.The ordinary quick sort method can
        // not pass the performance test.
        Arrays.sort(A);
        for (int i = 0; i < N-2; i++) {
            // this algorithm can only test if there is a triangle, it can not
            // get the whole number of the triangles.
            if (A[i] > 0 && A[i] > A[i+2] - A[i+1])
                return 1;
        }
        return 0;
	}
	
	//medium
	public int NumberOfDiscIntersections(int[] A) {
		
		int N = A.length;
        int count = 0;
        
        for (int i = 0; i < N; i++){
            //long test = (long)2147483647 + 1;
            long iMin = i - (long)A[i];
            long iMax = i + (long)A[i];
        
            for (int j = i + 1; j < N; j++){
                
            	long jMin = j - (long)A[j];
                long jMax = j + (long)A[j];
                
                if (jMin >= iMin && jMin <= iMax){
                    count++;
                }
                else if(iMax >= jMin && iMax <= jMax){
                    count++;
                }
                else if(iMin >= jMin && iMin <= jMax) {
                	count++;
                }
                else if(iMax >= jMin && iMax <= jMax) {
                	count++;
                }
            }
        }
        
        return count;
        
        /*
         * [1,1]
			[1, 2147483647]
			[1,200]
			[1,1,0,0,1]
         */
		
	}
}


