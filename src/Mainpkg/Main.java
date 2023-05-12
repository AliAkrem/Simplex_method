package Mainpkg;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//		double[] func = { 4, -2, 2, 0, 0, 0 };
		double[] func = { 0, 0, 0, 0, 0, -1, -1 };
//		double[] func = { 1, 2, 0, 0, 0 };
//		double[] func = { 0, 0, 0, -1, -1 };

		FunctionObj f1 = new FunctionObj(func); // cree la fonction objective

//		double a[][] = { { 1, -1, 1, 1, 0, 0 }, { 1, 1, 1, 0, 1, 0 }, { 2, 2, 1, 0, 0, 1 } };
//		double a[][] = { { 1, -2, 1, 1, 0 }, { 4, 1, -1, 0, 1 }, };
//		double a[][] = { { -3, 2, 1, 0, 0 }, { -1, 2, 0, 1, 0 }, { 1, 1, 0, 0, 1 } };
		double a[][] = { { -2, -1, 1, -1, 0, 1, 0 }, { -1, 2, -1, 0, -1, 0, 1 }, { -1, 2, -1, 0, -1, 0, 1 } };
		
		System.out.println(a.length);
		
//		double a[][] = { { 1, -2, 1, 1, 0 }, { 4, 1, -1, 0, 1 }, };
//		double EqTo[] = { 2, 4, 5 };
//		double EqTo[] = {6,2,4};
		double EqTo[] = { 1, 2 };

		GetSolutionOptimal sol = new GetSolutionOptimal(a, EqTo, f1); // class qui a la functionobj et les contraint

		Base base = new Base(sol.getContrants(), sol.getFunObj());

		// set the base

		sol.setBase(base);

//		sol.calculDeltaJ();
//		sol.calculTetaJ();
//
//		sol.afficherStep();// afficher le tableau de simplex

//		do {
//			sol.calculDeltaJ();
//			sol.calculTetaJ();
//
//			sol.afficherStep();// afficher le tableau de simplex
//			sol.MaxTheFunction();
//			if (sol.isColumnPivotPositif())
//				sol.addColumnPivotToBase();
//			else
//				break;
//
//		} while (!sol.isSolOptimal() && sol.isColumnPivotPositif());
//
//		if (!sol.isColumnPivotPositif())
//			System.out.println("Z => infinity ");
//
//		if (sol.isSolOptimal()) {
//			System.out.println("la solution optimal est z(0) = " + sol.getMaxFunction() + "/   x = {"
//					+ sol.PrintSolutionBase() + "}");
//		}

//		

//		sol.calculDeltaJ();
//		sol.calculTetaJ();
//		
//		
//		
//		sol.afficherStep();
//		
//		System.out.println("pivot col"+sol.getIndexOfColumnPivot());
//		System.out.println("pivot line"+sol.getIndexOfLinePivot());
////		sol.afficherStep();
//		
//		
//		
//		
//		System.out.println(sol.isSolOptimal());
//		
//		sol.afficherStep();

//		old diroulment 
//		while (!sol.isSolOptimal() && sol.isColumnPivotPositif()) {
//
//			System.out.println("x = { " + sol.PrintSolutionBase() + "} n'est pas solution optimal  ");
//
//			sol.MaxTheFunction(); // maximiser la solution
//			if (sol.isColumnPivotPositif())
//				sol.addColumnPivotToBase();
//			else
//				break;
//			sol.calculDeltaJ();
//			sol.calculTetaJ();
//			sol.afficherStep();
//
//		}
//		if (!sol.isColumnPivotPositif()) {
//			System.out.println("Z => infinity ");
//		}
//		if (sol.isSolOptimal()) {
//			System.out.println("la solution optimal est z(0) = " + sol.getMaxFunction() + "/   x = { "
//					+ sol.PrintSolutionBase() + "}");
//		}
//		

	}
}
