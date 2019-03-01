
public class Lesson10 {

	
	public int CountFactors(int N) {
		//find the number if factors for N
		
		int i = 1;
        int factors = 0;
        
        while (i * i < N){
            
            if (N % i == 0){
                factors += 2;
            }
            
            i++;
        }
        
        if (i * i == N){
            factors++;
        }
        
        return  factors;
		
	}
	
	public int Flags(int[] A){
		//brute force solution
		
		int N = A.length;
        int peakCount = 0;
        int [] Peaks = new int[N];
        int optimalFlags = 0;
        
        for (int i = 1; i < N -1; i++){
            
            if (A[i] > A[i -1] && A[i] > A[i +1]){
            
                //this is a peak
                Peaks[i] = 1;
                peakCount++;
            }
            
        }
        
        int Flags = 0;
        int lastFlag = 0;
        
        if (peakCount == 1) {
        	return 1;
        }
        else {
        	for (int j = 1; j < peakCount; j++){
	            
	        	Flags = 0;
	            lastFlag = 0;
	            
	            for (int i = 1; i < N -1; i++){
	            
	            	 if (Peaks[i] == 1) {
	                     if (Math.abs(i - lastFlag) > j || lastFlag == 0){
	                         lastFlag = i;
	                         Flags++;
	                     }
	                 }
	                
	                if (Flags == j){
	                    break;   
	                }
	                
	            }
	            
	            optimalFlags = Math.max(optimalFlags, Flags);
	                    
	        }
        }
	        
        
        
        
        return Flags;
	}
	
	public int MinPerimeterRectangle(int N) {
		
		int i = 1;
        int minPermieter = 0;
        
        while (i * i < N){
            
       	
            if (N % i == 0){            	
            	minPermieter = Math.min(minPermieter, 2 * (i + (N / i)));
            }
            
            i++;
        }
        
        if (i * i == N){
        	minPermieter = Math.min(minPermieter, 2 * (i + (N / i)));
        }
        
        return minPermieter;
        
	}
	
	
	
	
	
	
	
	
	
	
}
