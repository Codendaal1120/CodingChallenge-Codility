import java.util.Arrays;

/***
 * 
 * @author codendaal
 * MaxDoubleSliceSum - peeked
 * MaxProfit - 1 att
 * MaxSliceSum
 */
public class Lesson9 {

	///This is not challenge, but excerise
	public int MaxSlice(int[] A) {
		
		int maxEnding = 0;
		int maxSlice = 0;
		int[] prefix = new int[A.length];
		
		for (int i = 0; i < A.length; i++) {
			
			maxEnding = Math.max(0, maxEnding + A[i]);
			maxSlice = Math.max(maxSlice, maxEnding);
            prefix[i] = maxEnding;
			
		}
		
		return maxSlice;
		
	}
	
	public int MaxSliceSum(int[] A) {
		
		int N = A.length;
        int maxSum  = Integer.MIN_VALUE;
        int R = N;
        //int currentMax = Integer.MIN_VALUE;
        
        int[] prefix1 = new int[N];
        int[] prefix2 = new int[N];
        
        for (int i = 0; i < N; i++){
       	
        	R--;
        	
        	if (i == 0){
                prefix1[i] = A[i]; 
                prefix2[R] = A[R];
            }
            else{
                prefix1[i] = A[i] + prefix1[i -1];
                prefix2[R] = A[R] + prefix2[R +1];
            }
            //currentMax += prefix[i];            
            
            //maxSum = Math.max(A[i], maxSum);
            //maxSum = Math.max(prefix2[i], maxSum);            
            
        }
        
        for (int i = 0; i < N; i++){
        	maxSum = Math.max(A[i], maxSum);
            maxSum = Math.max(prefix1[i] - prefix2[i], maxSum);   
        }
        
        System.out.println("A = " + Arrays.toString(A));
        System.out.println("prefix1 = " + Arrays.toString(prefix1));
        System.out.println("prefix2 = " + Arrays.toString(prefix2));
        
        return maxSum;
		
	}
	
	public int MaxSliceSum1(int[] A) {
		 int size = A.length;
	     int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

	     for (int i = 0; i < size; i++)
	     {
	         max_ending_here = max_ending_here + A[i];
	         if (max_so_far < max_ending_here)
	             max_so_far = max_ending_here;
	         
	         if (max_ending_here < 0)
	             max_ending_here = 0;
	     }
	     return max_so_far;
	}
	
	public int MaxSliceSum2(int[] A) {
		 int N = A.length;
	     int maxSum = Integer.MIN_VALUE; 
	     int currentMax = 0;

	     for (int i = 0; i < N; i++)
	     {
	    	 currentMax = currentMax + A[i];
	    	 maxSum = Math.max(maxSum, currentMax);
	    	 currentMax = Math.max(0, currentMax);   
	  
	        	 
	     }
	     
	     return maxSum;
	}
	
	
	public int MaxProfit(int[] A) {
		int N = A.length;
        int[] profits = new int[N];
        int[] prefix = new int[N];
        int currentMax = 0;
        int maxProfit = 0;
        
        for (int i = 0; i < N; i++){
            
            if (i == 0){
                profits[i] = 0;    
                prefix[i] = 0;
            }
            else{
                profits[i] = A[i] - A[i -1];
                //prefix contains the profit ofr each day, summed from begining.
                prefix[i] = Math.max(0, prefix[ i -1 ] +  ( A[i] - A[i -1] ));   
            	//prefix[i] = prefix[ i -1 ] +  ( A[i] - A[i -1] );
                //maxProfit += prefix[i];
            }
        }
        
        for (int i = 0; i < N; i++){
        	
        	if (prefix[i] > 0) {
        		currentMax += profits[i];
        	}
        	else {        		
        		currentMax = 0;
        	}
        	
        	maxProfit = Math.max(maxProfit, currentMax);
        	
        }
        
        System.out.println("profits = " + Arrays.toString(profits));
        System.out.println("prefix = " + Arrays.toString(prefix));
        System.out.println("maxProfit = " + maxProfit);
        
        return maxProfit;
	}
	
	public int MaxDoubleSliceSum(int[] A) {
		
		int[] maxStartingHere = new int[A.length];
		int[] maxEndingHere = new int[A.length];
		int maxSum = 0, len = A.length;
		
		for(int i = len - 2; i > 0; --i ) {            
		    maxSum = Math.max(0, A[i] + maxSum);
		    maxStartingHere[i] = maxSum;
		}
		maxSum = 0;
		for(int i = 1; i < len - 1; ++i ) {            
		    maxSum = Math.max(0, A[i] + maxSum);
		    maxEndingHere[i] = maxSum;
		}
		int maxDoubleSlice = 0;
		
		for(int i = 0; i < len - 2; ++i) {
		    maxDoubleSlice = Math.max(maxDoubleSlice, maxEndingHere[i] + maxStartingHere[i+2]);
		}
		
		System.out.println("1 = " + Arrays.toString(maxStartingHere));
		System.out.println("2 = " + Arrays.toString(maxEndingHere));
		
		return maxDoubleSlice;
	}
	
}
