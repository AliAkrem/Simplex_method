package Mainpkg;

import java.util.ArrayList;

public class Contrant {
	
	private ArrayList<Double> eq;// Array of scalars
	
	private double eqTo; // value of contrant  

	
	
	
	public Contrant() {
		super();
		this.eq = new ArrayList<Double>();
	}

	public double getEqTo() {
		return eqTo;
	}

	public void setEqTo(double eqTo2) {
		this.eqTo = eqTo2;
	}

	public ArrayList<Double> getEq() {
		return eq;
	}

	public void setEq(ArrayList<Double> eq) {
		this.eq = eq;
	}

	public void addToEq(double a) {
		this.eq.add(a);
	}
	
	
	@Override
	public String toString() {
		String s = "";
		if (this.getEqTo() >= 0 )	
			s+="| "+getEqTo();
		else
			s+="|"+getEqTo();
		
		s+="  |";
		
		for (int i = 0; i < this.getEq().size(); i++) {
			
			if (this.getEq().get(i) >= 0) {
				s+=" "+this.getEq().get(i);
			} else {
				s+=""+this.getEq().get(i);
			}
			s+="   |";
			
		}
		
		
				return s;
	} 
	
	
	

}
