/*
 * https://app.codility.com/programmers/lessons/1-iterations/
 * BinaryGap - 1 attempt
 */
public class Lesson1 {

	public void BinaryGap(){
		
		int N = 50;
		
		String bin = Integer.toBinaryString(N);
        //char[] cArr = bin.toCharArray();
        int Count = 0;
        int maxCount = 0;
        
        System.out.println(N + " bin = " + bin);
        
        for (int i = 0; i < bin.length(); i++){
        	
        	
        	String sub = bin.substring(i, i + 1);
        	System.out.println(" binSub = " + sub);
        	
            if (sub.equals("1"))    {
            	
                maxCount = Math.max(maxCount, Count);
                Count = 0;
            }
            else{
                Count++;   
            }
            
        }
        
        System.out.println("max count = " + maxCount);
        
		
	}
	
	
}
