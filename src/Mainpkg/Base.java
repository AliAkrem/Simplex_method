package Mainpkg;

import java.util.ArrayList;

public class Base {
	private int nbrVar;
	
	public static String displaylength = " " ; 
	private ArrayList<Integer> IndexVect;
	
	private ArrayList<Double> ScalareVect;
	
	public Base(ArrayList<Contrant> contrants,FunctionObj fn) {
		boolean isBase;
		int nbrBase = 0;
		int nbrCont = contrants.size();
		
		IndexVect = new ArrayList<Integer>();
		ScalareVect  = new ArrayList<Double>();
		for (int j = 0; j < nbrCont; j++) {
			for (int i = 0; nbrBase <= nbrCont ; i++) {
				if (contrants.get(j).getEq().get(i) == 1.0) {
					isBase = true;
					for (int k = 0; k < nbrCont; k++) {

						if (contrants.get(k).getEq().get(i) != 0 && k != j) {
							isBase = false;
							break;
						}
					}
					if (isBase) {
						this.IndexVect.add(i);
						
						this.ScalareVect.add(fn.getFunc().get(i));	
						nbrBase++;
						break;
					}

				}

			}

		}

		
		
		

	
		

	}

	public int getNbrVar() {
		return nbrVar;
	}

	public void setNbrVar(int nbrVar) {
		this.nbrVar = nbrVar;
	}

	public ArrayList<Double> getSclareVect() {
		return ScalareVect;
	}

	public void setSclareVect(ArrayList<Double> baseScaler) {
		ScalareVect = baseScaler;
	}

	public ArrayList<Integer> getIndexVect() {
		return IndexVect;
	}

	public void setIndexVect(ArrayList<Integer> indexVect) {
		IndexVect = indexVect;
	}

	public void ReplaceBaseVar(int indexOfColumnPivot, int indexOfLinePivot, FunctionObj fn) {

		this.getIndexVect().set(indexOfLinePivot, indexOfColumnPivot);

		ArrayList<Double> BaseScaler = new ArrayList<Double>();

		for (int i = 0; i < this.getIndexVect().size(); i++) {
			BaseScaler.add(fn.getFunc().get(this.getIndexVect().get(i)));
		}
		this.setSclareVect(BaseScaler);

	}
	
	
	public String displayHederBase() {
	
		for (int i = 0; i < this.ScalareVect.size(); i++) {
			if (this.ScalareVect.get(i) / 10 > 0 || this.ScalareVect.get(i) < 0 ) {
				displaylength+=" ";
			}
		}
		
		
		return " CB  | base | b    |";
	}
	
	
	public String displayOneBase(int index) {
	
		
		
		
		if (this.ScalareVect.get(index) / 10 >= 0 || this.ScalareVect.get(index) < 0  ) {
			String ln = displaylength.substring(0, 1);
			return  " "+this.ScalareVect.get(index)+ln+"| "+"a"+(this.IndexVect.get(index)+1)+"   ";	
		}
		else
			return  " "+this.ScalareVect.get(index)+displaylength+"| "+"a"+(this.IndexVect.get(index)+1)+"   ";
		
		
	}
	
	
	public boolean isInBase(int i) {
		
		return IndexVect.contains(i); 
		
	}
	
	
	

}
