package Mainpkg;

import java.util.ArrayList;

public class FunctionObj {
	
	private ArrayList<Double> func ; // array of scalers of functionObj
	
	
	public FunctionObj(double[] func2) {
		
		this.func = new ArrayList<Double>();
		for (int i = 0; i < func2.length; i++) {
			this.func.add(func2[i]);
			
		}
		
	}

	
	
	public ArrayList<Double> getFunc() {
		return func;
	}

	public void setFunc(ArrayList<Double> func) {
		this.func = func;
	}
	
	
	
	public String displayHeder(String DisplayLenth) {
		
		
		return "";
		
	}

	public String displayindex() {
		return "";
	}
	
	
	
	
}
