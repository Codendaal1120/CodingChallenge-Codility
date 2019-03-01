import java.util.*;
/**
 * 
 * @author codendaal
 * EquiLeader - 
 * Dominator - 1 att (58%)
 * 
 */
public class Lesson8 {
 
	public int EquiLeader(int[] A) {
		
		int N = A.length;
        if (N == 1)
            return 0;
        // stores the index of the leader element
        int[] leaderIndex = new int[N];
        int value = 0;
        int size = 0;
        // using the algorithm in the reading material to find the leader in
        // O(N) time complexity
        for (int ele : A) {
            if (size == 0) {
                value = ele;
                size++;
            } else if (value == ele) {
                size++;
            } else
                size--;
        }
        if (size == 0)
            return 0;
        int countLeader = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == value) {
                countLeader++;
                leaderIndex[i] = 1;
            }
        }
        if (countLeader <= N / 2)
            return 0;
        // using prefix sum to calculate the number of leaders before index i in
        // O(1) time complexity
        for (int i = 1; i < N; i++) {
            leaderIndex[i] += leaderIndex[i-1];
        }
        
        
        int countEquiLeader = 0;
        // the number of leaders in A[0] A[1] ... A[S] is leaderIndex[i]
        // the number of leaders in A[S+1] A[S+2] ... A[N-1] is countleader - leaderIndex[i]
        for (int i = 0; i < N - 1; i++) {
            if (leaderIndex[i] > (i + 1) / 2 && (countLeader - leaderIndex[i]) > (N - i - 1) / 2)
                countEquiLeader++;
        }
        return countEquiLeader;
	}
	
	public int Dominator1(int[] A) {
		int N = A.length;
        int idx = -1;
        int count = 0;
        
        for(int i = 0; i< ( N / 2 ) +1; i++){
        	
            for(int j = N / 2; j < N; j++){
                if(A[i] == A[j]){
                    count++;
                }
            }
            if(count > ( N / 2)){
                idx = i;
            }
        }
        return idx;
	}
	
	public int Dominator2(int[] A) {
		//this algo works (75%), but I don't agree
		//we assume that the first elemenet is the dominator, and if not, the next element with most concurrent elements will be, why?
		
		//ok, so basic math = to be the domnitor (more than half) the number will either have to start and end the array or reoccur more than once, so then this works
		
		int N = A.length;
		int value = 0;
        int size = 0;
        
        if (N == 1) {
        	return -1;
        }
            
        // using the algorithm in the reading material to find the leader in
        // O(N) time complexity
        for (int ele : A) {
            if (size == 0) {
                value = ele;
                size++;
            } else if (value == ele) {
                size++;
            } else
                size--;
        }
        
        if (size == 0) {
        	return -1;
        }
        
        for (int i = 0; i < N; i++) {
        	if (A[i] == value) {
        		return i;
        	}
        }
        
        return value;
	}
}
