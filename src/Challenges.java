import java.util.Hashtable;

public class Challenges {

	public int LongestNonnegativeSumSlice1(int[] A) {
		
		 
		int maxSubLen = 0;
		int subLen = 0;
		int sum = 0;
		
		for (int i = 0; i < A.length; i++) {
			
			sum = A[i];
			subLen = 1;
	
			for (int j = i + 1; j < A.length; j++) {
				
				sum += A[j];
				
				if (sum < 0) {
					break;
				}
				else {
					subLen++;
				}
				
			}
			
			if (subLen > maxSubLen) {
				maxSubLen = subLen;
			}			
		}		

		return maxSubLen;
	}
	
	public int LongestNonnegativeSumSlice2(int[] A) {
		
		//after a lot of debugging I finally understand this solution. 
		//Calculate the prefix sum and if a negative reoccurs it means that there were positive numbers between them to return to the same negative
		//for prefix to move from -1 to -1 there had to be posative (or 0) between them and thus the diffrence between the 2 positions is the maximum slice
		
		//Array A		-1	-1	1	-1	1	0	1	-1	-1
		//Prefix sum	-1	-2	-1	-2	-1	-1	0	-1	-2
		
		//http://www.mlopt.com/?p=6744
		int sum = 0;
        int maxslice = 0;
        Hashtable<Integer,Integer> sumindex = new Hashtable<Integer,Integer>();
         
        for(int i = 0; i<A.length; i++) { 
        	
            sum += A[i];
            
            if(sum >= 0)
            	
                maxslice = i + 1;
            
            else if(sumindex.containsKey(sum))
            	
                maxslice = Math.max(maxslice, i - (int)sumindex.get(sum));
            
            else
            	
                sumindex.put(sum,i);
        }
        return maxslice;
	}

}
