package Mainpkg;

import java.util.ArrayList;
import java.util.Iterator;


public class GetSolutionOptimal {

	private int indexOfColumnPivot;
	private int indexOfLinePivot;
	private boolean isOptimal;
	private Double pivot ; 
	private FunctionObj funObj;
	private ArrayList<Double> deltaJ;
	public ArrayList<Double> getDeltaJ() {
		return deltaJ;
	}

	public void setDeltaJ(ArrayList<Double> deltaJ) {
		this.deltaJ = deltaJ;
	}

	private ArrayList<Double> tetaJ;
	private ArrayList<Contrant> contrants;
	private Base base;

	
	
	public ArrayList<Contrant> getContrants() {
		return contrants;
	}

	public void setContrants(ArrayList<Contrant> contrants) {
		this.contrants = contrants;
	}

	public void AddContrant(Contrant contrant) {
		this.contrants.add(contrant);
	}

	public GetSolutionOptimal(double[][] a,double[] eqTo,FunctionObj funObj ) {
		super();
		this.contrants = new ArrayList<Contrant>();
		this.funObj = funObj ; 
		
		int length =  a.length ;
		
		int nbrVar = funObj.getFunc().size() ;
		
		
		for (int i = 0; i < length ; i++) {
			Contrant c = new Contrant();
			for (int j = 0; j < nbrVar ; j++) {
				c.addToEq(a[i][j]);
				c.setEqTo(eqTo[i]);
			}
			this.contrants.add(c);
			
			
		}

		
		
		
		

	}

	public FunctionObj getFunObj() {
		return funObj;
	}

	public void setFunObj(FunctionObj funObj) {
		this.funObj = funObj;
	}

	public boolean isOptimal() {
		return isOptimal;
	}

	public void setOptimal(boolean isOptimal) {
		this.isOptimal = isOptimal;
	}

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	calcul the delta j  

	public int getIndexOfLinePivot() {
		return indexOfLinePivot;
	}

	public void setIndexOfLinePivot(int indexOfLinePivot) {
		this.indexOfLinePivot = indexOfLinePivot;
	}

	
	public void calculDeltaJ() {

		this.deltaJ = new ArrayList<Double>();

		for (int i = 0; i < funObj.getFunc().size(); i++) {

			Double dj = 0.0;
			for (int j = 0; j < base.getSclareVect().size(); j++) {
				dj = dj + base.getSclareVect().get(j) * this.contrants.get(j).getEq().get(i);
			}
			dj -= funObj.getFunc().get(i);

			this.deltaJ.add(dj);
		}
		
		this.indexOfColumnPivot = 0;
		
		for (int i = 0; i < this.deltaJ.size(); i++) {
			
			if (this.deltaJ.get(indexOfColumnPivot) > this.deltaJ.get(i)) {
				this.indexOfColumnPivot = i ;
			}
			
		}
		
		
		
		
	}

	public void afficherDeltaJ() {

		for (int i = 0; i < this.deltaJ.size(); i++)
			System.out.println("A" + (i + 1) + " : " + this.deltaJ.get(i));

	}

	public int getIndexOfColumnPivot() {

		int indexOfColumnPivot = 0;
		for (int i = 1; i < this.deltaJ.size(); i++) {
			if (this.deltaJ.get(i) < this.deltaJ.get(indexOfColumnPivot))
				indexOfColumnPivot = i;
		}

		return indexOfColumnPivot;

	}

// calcul tetaJ 

	public void calculTetaJ() {

		this.tetaJ = new ArrayList<Double>();

		for (int i = 0; i < this.base.getIndexVect().size(); i++) {
			this.tetaJ.add(contrants.get(i).getEqTo() / contrants.get(i).getEq().get(indexOfColumnPivot));
		}

		for (int i = 0; i < tetaJ.size(); i++) {
			if (this.tetaJ.get(i) > 0) {
				this.indexOfLinePivot = i;
				break;
			}
		}

		for (int i = 0; i < this.tetaJ.size(); i++) {
			if (this.tetaJ.get(indexOfLinePivot) > this.tetaJ.get(i) && this.tetaJ.get(i) > 0) {
				this.indexOfLinePivot = i;
			}

		}

	}

	public void afficherTetaJ() {

		for (int i = 0; i < this.tetaJ.size(); i++) {
			System.out.println(this.tetaJ.get(i));
		}

	}

	public void afficherDelta() {

		for (int i = 0; i < this.tetaJ.size(); i++)
			System.out.println("A" + (i + 1) + " : " + this.tetaJ.get(i));

	}

	public Double getMaxFunction() {

		Double maxFunc = 0.0;
		
		for (int i = 0; i < this.base.getIndexVect().size() ; i++) {
			maxFunc += this.base.getSclareVect().get(i) * this.contrants.get(i).getEqTo();
		}

		return maxFunc;
	}

	public void afficherStep() {

//		this.calculDeltaJ();
//		this.calculTetaJ();

		// first line
		System.out.print(" C   |       Z(x) = ");
		for (int i = 0; i < this.funObj.getFunc().size(); i++) {
			System.out.print("  (" + this.funObj.getFunc().get(i) + ")" + "");
		}

		// second line
		System.out.println();
		

		System.out.print(this.base.displayHederBase());
		
		
		for (int i = 0; i < this.funObj.getFunc().size(); i++) {
			System.out.print(" a" + (i + 1) + "    |");
		}
		System.out.println(" TetaJ");

		// table

		for (int i = 0; i < this.base.getSclareVect().size(); i++) {

			System.out.print(this.base.displayOneBase(i));

			System.out.print(this.contrants.get(i).toString());

			System.out.print("" + this.tetaJ.get(i));
			System.out.print("  |");
			System.out.println();

		}

		System.out.print("Z= " + this.getMaxFunction() + "      |DeltaJ");

		for (int i = 0; i < deltaJ.size(); i++) {
			System.out.print("| " + deltaJ.get(i) + "   ");
		}
		System.out.println("\n");
		System.out.println("line de pivot : " + this.indexOfLinePivot);
		System.out.println("colone de pivot : " + this.indexOfColumnPivot);
		for (int i = 0; i < 3; i++) {
			System.out.println();
		}

	}

	public boolean isSolOptimal() {

		this.isOptimal = true ;

		for (int i = 0; i < this.deltaJ.size(); i++) {
			if (this.deltaJ.get(i) < 0) {
				this.isOptimal = false ;
				break;
			}
		}

		return this.isOptimal;

	}
	
	

	public void MaxTheFunction() {

		
//		test if column povot est positif 
		
//		if (this.isColumnPivotPositif()) {
//			this.addColumnPivotToBase();
//			System.out.println("column pivot add to the base");
//		}
//		
		
		
		
		
		this.pivot = this.contrants.get(indexOfLinePivot).getEq().get(indexOfColumnPivot);

		ArrayList<Double> scalarsColumn = new ArrayList<Double>();

		ArrayList<Double> linePivotBypivot = new ArrayList<Double>();

		// diviser la line de pivot sur indexOfColumnPivotle pivot Lpivot(2) = Lpivot(1)
		// / pivot

		for (int i = 0; i < this.contrants.get(indexOfLinePivot).getEq().size(); i++) {

			linePivotBypivot.add(this.contrants.get(indexOfLinePivot).getEq().get(i) / pivot);

		}

		contrants.get(indexOfLinePivot).getEq().clear();

		contrants.get(indexOfLinePivot).getEq().addAll(linePivotBypivot);// set Pivot new line
		
		//set b of pivot 
			
		this.contrants.get(indexOfLinePivot).setEqTo(this.contrants.get(indexOfLinePivot).getEqTo()/pivot);
		
		  
		// get column pivot scalars

		for (int i = 0; i < contrants.size(); i++) {

			scalarsColumn.add(this.contrants.get(i).getEq().get(this.indexOfColumnPivot));

		}

		System.out.println(this.pivot);
		System.out.println(scalarsColumn);

		// Li(2) = Li(1) - ( scalar coloun pivot ) X LinePivotByPivot

		for (int i = 0; i < contrants.size(); i++) {
			if (i == indexOfLinePivot) {
			} else {
				ArrayList<Double> newLine = new ArrayList<Double>();
				for (int j = 0; j < this.contrants.get(i).getEq().size(); j++) {
					newLine.add(
							this.contrants.get(i).getEq().get(j) - (scalarsColumn.get(i)) * linePivotBypivot.get(j));

				}
				// set Line to Line
				this.contrants.get(i).getEq().clear();
				this.contrants.get(i).getEq().addAll(newLine);

				// set new b to line  b(2) = b(1) - (scalar column pivot) X b(pivot)/pivot
				
				this.contrants.get(i).setEqTo(this.contrants.get(i).getEqTo() - (scalarsColumn.get(i))  * this.contrants.get(indexOfLinePivot).getEqTo()  );
				
				
				
				
				
			}
			
			
			
			
		}
	

	}

	public boolean isColumnPivotPositif() {
		boolean isPositif = false;

		for (int i = 0; i < this.contrants.size(); i++) {
			if (this.contrants.get(i).getEq().get(indexOfColumnPivot) > 0 ) {
				isPositif= true;
				break;
			}
		}
		
		return isPositif;
	}
	
	public void addColumnPivotToBase() {
		
		
		this.base.getIndexVect().set(indexOfLinePivot,indexOfColumnPivot);
		
		ArrayList<Double> BaseScaler = new ArrayList<Double>();

		for (int i = 0; i < this.base.getIndexVect().size(); i++) {
			BaseScaler.add(this.getFunObj().getFunc().get(this.base.getIndexVect().get(i)));
		}
		
		
		this.base.setSclareVect(BaseScaler);
		
		
		
		
		
	}

	public Double getPivot() {
		return pivot;
	}

	public void setPivot(Double pivot) {
		this.pivot = pivot;
	}
	
	
	
	public String  PrintSolutionBase() {
		
		String str = "{";
		
		for (int i = 0,j = 0 ;j<this.base.getSclareVect().size() || i < funObj.getFunc().size() ; i++) {
			
			if ( this.base.isInBase(i) ) {
				str+="a"+(this.base.getIndexVect().get(j)+1)+
						"="+this.contrants.get(j).getEqTo()+", ";
				j++;
			}else {
				str+="a"+(i+1)+"= 0 ";
			}
			
			
			
		}
		
		
		str += "}";
		
		return str ; 
		
	}
	
	
	
	
	
	

}