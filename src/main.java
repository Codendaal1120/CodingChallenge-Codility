import java.lang.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;


//2018-03-04
/**
 * 
 * OddOccurrencesInArray - ?
 * CyclicRotation - 5 attempts
 * 
 * TapeEquilibrium 1 attempt (83%)
 * FrogJmp - 1 attempt
 * PermMissingElem - 3 attempts
 * 
 * PermCheck - 2 attempts
 * FrogRiverOne - 1 attempt (90%)
 * MissingInteger - 1 attempt
 * MaxCounters - 1 attempt (77%)
 * 
 */

import javax.print.attribute.standard.DateTimeAtCompleted;

public class main {
	
	public static void main(String[] args) throws ParseException  {
	
		main m = new main();		

		System.out.println("Start");
		//m.Lesson1();
		//m.Lesson2();
		//m.Lesson3();
		//m.Lesson4();
		//m.Lesson5();
		//m.Lesson6();
		//m.Lesson7();
		//m.Lesson8();
		//m.Lesson9();
		//m.Lesson10();

		System.out.print("Done");
	}
	
	public void Lesson1(){
		//BinaryGap
		Lesson1 lesson = new Lesson1();
		lesson.BinaryGap();		
	}

	public void Lesson2(){
		//BinaryGap
		Lesson2 lesson = new Lesson2();
		lesson.cdArrays();		
		//lesson.OddOccurrencesInArray();		
		//lesson.CyclicRotation();		
	}

	public void Lesson3(){
		//BinaryGap
		Lesson3 lesson = new Lesson3();
		//lesson.FrogJmp();		
		//lesson.PermMissingElem();		
	}

	public void Lesson4(){
		//Lesson 4
		int[] a = {3, 4, 4, 6, 1, 4, 4};
		int[] b = {1};
		
		Lesson4 lesson = new Lesson4();
		System.out.println("MaxCounters = " + Arrays.toString(lesson.MaxCounters(5, a)));

		genArray(1, 10, 0, 2);
		System.out.println("MissingInteger1 = " + lesson.MissingInteger(genArray(1, 100, 1, 10)));
		System.out.println("MissingInteger2 = " + lesson.MissingInteger(genArray(1, 100000, -1000000, 1000000)));	
	}

	public void Lesson5(){
		//Lesson 5
		Lesson5 lesson = new Lesson5();
		
		//CountDiv
		int[] a = {4, 2, 2, 5, 1, 5, 8};
		System.out.println("CountDiv = " + lesson.CountDiv(6, 11, 2));
			
		//MinAvgTwoSlice
		System.out.println("MinAvgTwoSlice = " + lesson.MinAvgTwoSlice(a));
			
		//GenomicRangeQuery
		
		int[] c = {2, 5, 0};
		int[] b = {4, 5, 6};
		System.out.println("GenomicRangeQuery = " + Arrays.toString(lesson.GenomicRangeQuery("CAGCCTA", c, b)));
		System.out.println("GenomicRangeQuery = " + Arrays.toString(lesson.GenomicRangeQuery_Solution("CAGCCTA", c, b)));
		
	}

	public void Lesson6(){
		//Lesson6
		Lesson6 lesson = new Lesson6();
		
		//Distinct
		//System.out.println("Distinct = " + Arrays.toString(lesson.Distinct("CAGCCTA", a, b)));
			
		//Triangle
		int[] a = {10, 2, 5, 1, 8, 20}; //1 P = 0, R = 2, Q = 4
		int[] b = {1, 2, 3}; //0
		int[] c = {0, 1, 2};
		System.out.println("Triangle = " + lesson.Triangle(a));
		System.out.println("Triangle = " + lesson.Triangle(b));
		System.out.println("Triangle = " + lesson.Triangle(c));
			
		//NumberOfDiscIntersections
		
		int[] aa = {1, 5, 2, 1, 4, 0};
		int[] bb = {1, 1};
		int[] cc = {1,1,0,0,1};
		System.out.println("NumberOfDiscIntersections = " + lesson.NumberOfDiscIntersections(aa));
		System.out.println("NumberOfDiscIntersections = " + lesson.NumberOfDiscIntersections(cc));
		
	}

	public void Lesson7(){
		//Lesson7
		Lesson7 lesson = new Lesson7();
		
		//Brackets
		System.out.println("NumberOfDiscIntersections = " + lesson.Brackets("[()()]{()()}()[]"));

		//StoneWall
		
		int[] a = {8, 8, 5, 7, 9, 8, 7, 4, 8};//7
		int[] b = {8, 8, 5, 7, 9, 8, 7, 5, 4, 8, 4};//7
		int[] c = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};//6
		int[] d = {2, 5, 1, 4, 6, 7, 9, 10, 1};
		System.out.println("StoneWall = " + lesson.StoneWall(d));

		//Fish
		int[] aa = {1, 1000000000,2,3,4,5};
		int[] bb = {0,1,1,1,1,1};
		
		int[] cc = {4, 3, 2, 1, 5};//6
		int[] dd = {0, 1, 0, 1, 0};
		
		int[] e = {1, 1000000000,2,3,4,5};
		int[] f = {0,1,0,1,0,1}; 
		
		int[] g = {1, 2, 3};
		int[] h = {1, 1, 0}; 
		
		System.out.println("Fish = " + lesson.Fish(aa, bb));
		System.out.println("Fish_solution = " + lesson.Fish_solution(aa, bb));
		System.out.println("Fish = " + lesson.Fish(g, h));
		System.out.println("Fish_solution = " + lesson.Fish_solution(e, f));
		lesson.FishTest(aa, bb);
		lesson.FishTest(cc, dd);
		lesson.FishTest(e, f);
		lesson.FishTest(g, h);
	
		//Nesting
		System.out.println("Fish_solution = " + lesson.Nesting("(()(())())"));
		System.out.println("Fish_solution = " + lesson.Nesting("())"));
		System.out.println("Fish_solution = " + lesson.Nesting("()()"));
		System.out.println("Fish_solution = " + lesson.Nesting("((())"));
		
	}

	public void Lesson8(){
		//Lesson8	
		Lesson8 lesson = new Lesson8();
		
		//EquiLeader
		int a[] = { 4, 3, 4, 4, 4, 2 };
		int b[] = {4, 3, 2, 4, 5, 4, 6, 4, 2};
		System.out.println("EquiLeader = " + lesson.EquiLeader(a));
		System.out.println("EquiLeader = " + lesson.EquiLeader(b));
		
		//Dominator		
		int aa[] = { 4, 3, 4, 4, 4, 2 };
		int bb[] = { 3, 4, 3, 2, 3, -1, 3, 3 };
		int c[] = { 1, 3, 2, 3, 4, 5, 3, 6 };
		System.out.println("Dominator = " + lesson.Dominator2(c));
	}

	public void Lesson9(){
		//Lesson9
		Lesson9 lesson = new Lesson9();
		
		int[] a = {5,-7, 3, 5, -2, 4, 1};		
		System.out.println("MaxSlice = " + lesson.MaxSlice(a));
		
		int[] aa = {3, 2, 6, -1, 4, 5, -1, 2};//17

		//MaxDoubleSliceSum
		System.out.println("MaxDoubleSliceSum = " + lesson.MaxDoubleSliceSum(aa));
		
		//MaxProfit
		
		int[] aaa = {23171, 21011, 21123, 21366, 21013, 21367};//356
		int[] b = {0, 3, 0, 1};//356
		lesson.MaxProfit(aaa);
		lesson.MaxProfit(b);	
		
		//MaxSliceSum
		
		int[] aaaa = {3, 2, -6, 4, 0};//356
		int[] bb = {0, 3, 0, 1};//356
		int[] c = {-11, -200, -3, -4, -12};//356
		int[] d = {1, -200, 76, 8, 345, 233, -23, 304, 47, 1, -200};
		System.out.println("MaxSliceSum = " + lesson.MaxSliceSum(aaaa));
		System.out.println("MaxSliceSum1 = " + lesson.MaxSliceSum1(aaaa));
		System.out.println("MaxSliceSum2 = " + lesson.MaxSliceSum2(aaaa));
		
		System.out.println("MaxSliceSum = " + lesson.MaxSliceSum(c));
		System.out.println("MaxSliceSum1 = " + lesson.MaxSliceSum1(c));
		
		System.out.println("MaxSliceSum = " + lesson.MaxSliceSum(d));
		System.out.println("MaxSliceSum2 = " + lesson.MaxSliceSum2(d));
		
	}
		
	public void Lesson10(){
		//Lesson10
		Lesson10 lesson = new Lesson10();
				
		//Flags
		
		int[] a = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
		int[] b = {1, 1000000000, 5};
		System.out.println("Flags = " + lesson.Flags(b));

		
	}

	/**
	 * Generates random array given params
	 * A is array length range
	 * N is array elements range	 * 
	 */	
	public int[] genArray(int A_max, int A_min, int N_min, int N_max) {
		
		N_max++;
		int A = (int) Math.floor((Math.random() * A_max) + A_min);
		int[] ret = new int[A];
		
		for (int i = 0; i < A; i++) {
			ret[i] = (int) Math.floor((Math.random() * N_max) + N_min);
		}
		
		System.out.println("Generated array = " + Arrays.toString(ret));
		
		return ret;
		
	
	}

	
	
	
	
	
	
	
	
	
	
}
