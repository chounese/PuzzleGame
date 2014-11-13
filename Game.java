public class Game{

    private Spot[][] GameSpots;
    private int [] PossibleValues;
    private Spot[] EmptySpots;
    
    public Spot[][] getGSs(){
	return GameSpots;
    }
    public int[] getPVs(){
	return PossibleValues;
    }
    public Spot[] getESs(){
	return EmptySpots;
    }
    public void setGSs(Spot[][] s){
	GameSpots=s;
    }
    public void setPVs(int[] p){
	PossibleValues=p;
    }
    public void setESs(Spot[] e){
	EmptySpots=e;
    }
    public void printCheck(){
	for (int a=0;a<GameSpots.length;a++){
	    for (int d=0;d<GameSpots[0].length;d++){
		System.out.print(GameSpots[a][d].getNum()+" ");
	    }
	    System.out.println();
	}
	for (int b=0;b<PossibleValues.length;b++){
	    System.out.print(b+"+"+PossibleValues[b]+" ");
	}
	System.out.println();
	for (int c=0;c<EmptySpots.length;c++){
	    System.out.print(c+"+"+EmptySpots[c].getNum()+" ");
	    if (EmptySpots[c+1]==null){
		System.out.println();
		return;
	    }	    
	}
	System.out.println();
    }

    public boolean Checker(){
    	return constraints();
    }

    public boolean finished(){
    	for (int i=0;i<GameSpots.length;i++){
    		for (int j=0;j<GameSpots[0].length;j++){
    				if (GameSpots[i][j].getNum()==0){
    						System.out.print("False");
    						return false;
    				}
    		}
    	}
    	System.out.println("True");
    	return true;
    }

    public boolean Solver(int i, Spot[] theSpots, Game g, int[] possibleValues){
	int realLength=0;
	for (int q=0;q<theSpots.length;q++){
	    if (theSpots[q]!=null){
		realLength++;
	    }
	}
	if (i==realLength){
	    return g.constraints();
	}
	for (int v=0;v<possibleValues.length;v++){
	    theSpots[i].setNum(possibleValues[v]);
	    //set i to v
	    boolean check=g.constraints();
	    if (check){
		if (Solver(i+1,theSpots,g,possibleValues)){
		    return true;
		}
	    }
	}
        theSpots[i].reSet();
	return false;
    }

    public boolean constraints(){
	return false;
    }

    public void addFile(String stuff){}

    public int[] getPossibles(){
	return PossibleValues;
    }
    public Spot[][] getSpots(){
	return GameSpots;
    }
    public Spot[] getEmpties(){
	return EmptySpots;
    }
    public Spot[] getConstraintArray(){
	return EmptySpots;
    }
    public void matrixConverter(Spot[] ConstraintArray){
    }
    public void add(int i,int j,int k){
    }
    public Spot[][] getConsMatrix(){
    	return GameSpots;
    }

    
    public static void main(String[] args){
	Game g3=new ABCD();
	g3.go3(args[0]);
	//	Game g2=new Kenken();	
	//	g2.go2(args[0]);
	//	Game g1=new Sudoku();
	//	g1.go1(args[0]);
    }
    public void go1(String filename){	
	addFile(filename);
	setGSs(getSpots());
	setPVs(getPossibles());
	setESs(getEmpties());
	printCheck();
	Solver(0, EmptySpots, this, PossibleValues);
	for (int k=0;k<9;k++){
	    for (int l=0;l<9;l++){
		System.out.print(GameSpots[k][l].getNum()+" ");
	    }
	    System.out.println();	    
	}
    }
    public void go2(String filename){	
	addFile(filename);	    	
	setGSs(getSpots());
	matrixConverter(getConstraintArray());
	setPVs(getPossibles());
	setESs(getEmpties());
	printCheck();
	Solver(0, EmptySpots, this, PossibleValues);
	for (int k=0;k<4;k++){
	    for (int l=0;l<4;l++){
		System.out.print(GameSpots[k][l].getNum()+" ");
	    }
	    System.out.println();	    
	}
    }    
    public void go3(String filename){	
	addFile(filename);	    	
	setGSs(getSpots());
	matrixConverter(getConstraintArray());
	setPVs(getPossibles());
	setESs(getEmpties());
	printCheck();
	Solver(0, EmptySpots, this, PossibleValues);
	for (int k=0;k<6;k++){
	    for (int l=0;l<6;l++){
		System.out.print(GameSpots[k][l].getNum()+" ");
	    }
	    System.out.println();	    
	}
    }

}