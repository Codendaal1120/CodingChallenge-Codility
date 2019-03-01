import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/
 * @author codendaal
 * CountDiv - 1 attempt
 * MinAvgTwoSlice - 1 attempt 
 * GenomicRangeQuery - 2 attempts (62%, 62%) Purposefully submitted twice to see difference between 2 methods of performance
 */
public class Lesson5 {

	public Lesson5() {
		
	}
	
	public int CountDiv(int A, int B, int K) {
		
		
		int count = 0;
		
		for (int i = A; i < B; i++) {
			if (i % K == 0) {
				count++;
			}
		}
		
		long low = Math.floorDiv(A, K);
		long high = Math.floorDiv(B, K);
		
		System.out.println("Count = " + count);
		//System.out.println("div = " + div);
		
		
		/*int firstDiv = 0;
		int lastDiv = 0;
		
		if (A % K == 0) {
			firstDiv = A;
		}
		else {
			//int aDiv = A % K;			
			firstDiv = A + (K - A % K);
		}
		
		if (B % K == 0) {
			lastDiv = B;
		}
		else {
			//int aDiv = B % K;			
			lastDiv = B - B % K;
		}

        return (lastDiv - firstDiv) / K + 1;
		*/
		
		return 1;
		
		
	}
	
	//Medium
	public int MinAvgTwoSlice(int[] A) {
		
		int[] prefix = new int[A.length];
		
		for (int i = 0; i < A.length; i++){
			
			if (i == 0) {
				prefix[i] = A[i];
			}
			else {
				prefix[i] = A[i] + A[i - 1];
			}
		}
		
		return 1;
		
	}
	
	//Medium
	public int[] GenomicRangeQuery(String S, int[] P, int[] Q) {
		
		 int[] ret = new int[P.length];
	        int[] dna = new int[S.length()];
	        
	        for (int i = 0; i < S.length(); i++){
	            String sub = S.substring(i, i + 1);
	            switch (sub){
	                case "A" :
	                    dna[i] = 1;        
	                    break;
	                    
	                case "C" :
	                    dna[i] = 2;        
	                    break;
	                    
	                case "G" :
	                    dna[i] = 3;        
	                    break;
	                    
	                case "T" :
	                    dna[i] = 4;        
	                    break;
	            }
	        }
	        
	        for (int i = 0; i < P.length; i++){
	        	//Will submit test twice as I want to see performance diffrence between loop and splice.
	            int left = P[i];
	            int right = Q[i];
	            int min = 5;
	            /*
	            for (int j = P[i]; j <= Q[i]; j++){
	                min = Math.min(dna[j], min);
	            }
	            
	            ret[i] = min;
	            */
	            int[] splice = Arrays.copyOfRange(dna, P[i], Q[i] + 1);
	            Arrays.sort(splice);
	            ret[i] = splice[0];
	                
	        }
	        
	        return ret;
	}
	
	//Medium
	public int[] GenomicRangeQuery_Solution(String S, int[] P, int[] Q) {
		/* CO: basically create seperate arrays for each letter
		 * then calcualte prefix sum for each collection
		 * then compare the start pos to end pos foreach letter
		 * if a letter (A) has ocuureced bewteen those 2 positions, the prefix sum woul increase so in other words, 
		 * if the diffrence is not 0, then the letter has appeard. Do this foreach letter (Starting from smallest unit) until one is found. 
		 */
		
		
		
		 // write your code in Java SE 8
        int N = S.length();
        int M = P.length;
        int[] result = new int[M];
        // store the position of A in the String S
        int[] posOfA = new int[N+1];
        int[] posOfC = new int[N+1];
        int[] posOfG = new int[N+1];
        int[] posOfT = new int[N+1];
        for (int i = 0; i < N; i++) {
            // when A appears, assign 1 to the value of posOfA with the same index.
            if (S.charAt(i) == 'A')
                posOfA[i+1] = 1;
            if (S.charAt(i) == 'C')
                posOfC[i+1] = 1;
            if (S.charAt(i) == 'G')
                posOfG[i+1] = 1;
            if (S.charAt(i) == 'T')
                posOfT[i+1] = 1;
        }
        for (int i = 1; i <= N; i++) {
            // prefix sum of the array
            posOfA[i] += posOfA[i-1];
            posOfC[i] += posOfC[i-1];
            posOfG[i] += posOfG[i-1];
            posOfT[i] += posOfT[i-1];
        }
        for (int i = 0; i < M; i++) {
            // calculate the sum between P[i] and Q[i] in O(1) time complexity
            // if the value is not zero, then A has appeared in the slice.
        	int a1 = posOfA[Q[i]+1];
        	int a2 = posOfA[P[i]];
            if ((posOfA[Q[i]+1] - posOfA[P[i]]) != 0)
                result[i] = 1;
            else if ((posOfC[Q[i]+1] - posOfC[P[i]]) != 0)
                result[i] = 2;
            else if ((posOfG[Q[i]+1] - posOfG[P[i]]) != 0)
                result[i] = 3;
            else if ((posOfT[Q[i]+1] - posOfT[P[i]]) != 0)
                result[i] = 4;
        }
        return result;
	}
	
}
