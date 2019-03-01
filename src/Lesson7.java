/**
 * @author codendaal
 * Brackets - 1 att 
 * StoneWall - 1 att (50%)
 * Fish - 1 att(37%), 2 att (36%), 3 att (62%)
 * Nesting - 1 att
 */
public class Lesson7 {

	public int Brackets(String S) {
	    // write your code in Java SE 8
        int N = S.length();
        // if the length of string s is odd, then it can't be nested.
        if (N % 2 == 1)
            return 0;
        char[] stack = new char[N];
        int num = 0;
        for (char ele : S.toCharArray()) {
            // push the left half in the stack, and because of the same length
            // of string s and stack array so there is no need to worry about if
            // the stack is full.
            if (ele == '(' || ele == '{' || ele == '[') {
                stack[num++] = ele;
            }
            // pop the left half out of the stack if the element can be matched
            // from the top of the stack
            else if (num != 0 &&
                    (ele == ')' && stack[num-1] == '(' ||
                     ele == '}' && stack[num-1] == '{' ||
                     ele == ']' && stack[num-1] == '['))
                num--;
            // if there is no match character we can sure that this is not a
            // properly nested string
            else
                return 0;
        }
        // if the stack is empty, then the string is properly nested.
        if (num == 0)
            return 1;
        else
            return 0;
	}
	
	public int StoneWall(int[] H) {
		/*
		 * 50%
		 * Correctness: 80%;
		 * Performance: 33% (failures)
		 */
		int N = H.length;
        int blockCount = 0;
        int stackCount = 0;
        int[] stack = new int[N];
        
        for (int i = 0; i < N; i++){
        	
        	int block = 0;
        	int lastBlock = 0;
        	if (stackCount > 0) {
        		block = H[i];
            	lastBlock = stack[stackCount -1];
        	}
        	
            System.out.println("Section " + i + ", block = " + block + ", lastBlock = " + lastBlock);
        	
        	if (stackCount == 0) {
        		stack[stackCount] = H[i];
                blockCount++;
                stackCount++;
        	}
        	else if (H[i] < stack[stackCount -1]){
                //replace last block
                //stackCount--;
        		if (stackCount > 1) {
        			if (stack[stackCount -2] != H[i]) {
            			stack[stackCount -1] = H[i];
                        blockCount++;
            		}
        			else {
        				stack[stackCount -1] = 0;
        				stackCount--;        				
        				//do nothing
        			}
        		}
        		else {
        			stack[stackCount -1] = H[i];
                    blockCount++;
        		}
        		
            }
            else if (H[i] > stack[stackCount -1]){
                //add new block 
                stack[stackCount] = H[i];
                blockCount++;
                stackCount++;
            }
        }
        
        return blockCount;
	}

	public void FishTest(int[] A, int[] B) {
		System.out.println("Fish = " + Fish(A, B));
		System.out.println("Fish_solution = " + Fish_solution(A, B));
	}
	
	public int Fish(int[] A, int[] B) {
		int N = A.length;
        int[] stack = new int[N];
        int stackCount = 0;
        int fish = -1;
        
        for (int i = 0; i < N; i++){
            
            if (fish == -1) {
            	stack[stackCount] = i; 
                stackCount++;
                fish = i;
            }
            else if (B[fish] == 1 && B[i] == 0){
                //if the last fish in stack is meeting this fish
                if (A[fish] < A[i]){
                	stack[stackCount -1] = 0;
                	stackCount--;
                	
                	boolean add = true;
                	
                	//eat all the fish you can
                	for (int j = stackCount -1; j >= 0; j--) {
                		
                		if (B[j] == 1) {
                			if (A[i] > A[j]) {
                    			stack[stackCount -1] = 0;
                            	stackCount--;                            	
                    		}
                    		else {
                    			//current fish got eaten
                    			add = false;
                                break;
                    		}
                		}
                		else {
                            break;
                		}                		
                	}
                	
                	//stack it
                	if (add) {
                		stack[stackCount] = i; 
                        stackCount++;
                        break;
                	}                    
                }
            }
            else{
                stack[stackCount] = i; 
                stackCount++;
                fish = i;
            }
        }
        
        return stackCount;
        
        /*
        ([4, 3, 2, 1, 5], [0, 1, 0, 0, 0]) 

        ([5], [1]) = 1
        ([4, 3, 2, 1, 5], [0, 1, 0, 1, 0]) = 3
        ([1, 1000000000,2,3,4,5][0,1,1,1,1,1]) = 6
        ([1, 1000000000,2,3,4,5][0,1,0,1,0,1]) = 4
        ([1, 1000000000,2,3,4,5][0,1,0,0,0,0]) = 2
        */
	}
	
	public int Fish_solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int N = A.length;
        // the stack of alive fish flowing downstream
        int[] downstreamStack = new int[N];
        int num = 0;
        // store the number of alive fish flowing upstream
        int aliveUpstreamNum = 0;
        for (int i = 0; i < N; i++) {
            // current fish is flowing upstream and there isn't fish flowing
            // downstream before
            if (B[i] == 0 && num == 0)
                aliveUpstreamNum++;
            else if (B[i] == 0 && num != 0) {
                // current fish flowing upstream eats the fish flowing
                // downstream before
                while (num != 0 && A[i] > downstreamStack[num-1])
                    num--;
                // all the fish flowing downstream is eaten by the current fish
                // flowing upstream
                if (num == 0)
                    aliveUpstreamNum++;
            } else {
                // there is a fish flowing downstream and push it into the stack
                downstreamStack[num++] = A[i];
            }
        }
        // the alive fish is consist of the fish flowing upstream and the fish
        // flowing downstream
        return aliveUpstreamNum + num;
    }
	
	/*
	''= 1;
	'()' = 1;
	'()()' = 1;
	'(()()(())(())(())()((()()))()()(())(()))' = 1;
	'((((()))))' = 1;
	'()()(())(())(())()((()()))()()(())(()))' = 0;
	'((()(())(())(())()((()()))()()(())(()))' = 0
	'(((()))))' = 0;
	'((((())))' = 0
	*/
	
	public int Nesting(String S) {
		int N = S.length();
        int stackCount = 0;
        
        char[] stack = new char[N];
        
        char[] input = S.toCharArray();
        
        String t1 = S.substring(0, 2);
        String t2 = S.substring(N -2);

        if (N == 0){
            return 1;
        }
        /*
        else if (!S.substring(0, 2).equals("((") || !S.substring(N -2).equals("))")){
            //not 100% sure about this, but I think the entire string has to be wrapperd in (....)
            //S has the form "(U)" where U is a properly nested string;
            return 0;
        }
        */
        else{
            
        	for (int i = 0; i < N; i++)    {
                
                if (stackCount == 0){
                    if (Character.toString( input[i] ).equals("(")){
                        //open set of brackets
                        stack[stackCount] = input[i];
                        stackCount++;    
                    }   
                    else{
                        return 0;
                    }
                }
                else if (Character.toString( input[i] ).equals("(")){
                    //open set of brackets
                    stack[stackCount] = input[i];
                    stackCount++;
                }
                else{
                    if (Character.toString( stack[ stackCount -1 ] ).equals("(")){
                        //close set
                        stack[stackCount] = Character.MIN_VALUE;
                        stackCount--;           
                    }
                    else{
                        return 0;
                    }
                }
                
            }
            
        	if (stackCount > 0) {
        		return 0;
        	}
        	else {
        		return 1;
        	}            
        }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


