import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kenken extends Game{
    private Spot[][] SpotGrid=new Spot[4][4];
    private int[] Possibles={1,2,3,4};
    private Spot[] Empties=new Spot[17];
    private Spot[] ConstraintArray=new Spot[16];
    private Spot[][] ConsMatrix=new Spot[4][4];

    public Spot[][] getConsMatrix(){
    	return ConsMatrix;
    }

    public Spot[] getConstraintArray(){
	return ConstraintArray;
    }

    public int[] getPossibles(){
	return Possibles;
    }

    public Spot[][] getSpots(){
	return SpotGrid;
    }
    
    public Spot[] getEmpties(){
	int k=0;
	for (int i=0;i<4;i++){
	    for (int j=0;j<4;j++){
		if (SpotGrid[i][j].getSet()==false){
		    Empties[k++]=SpotGrid[i][j];
		}
	    }
	}
	return Empties;
    }
    public void add(int i, int j, int k){
    	SpotGrid[i][j].setNum(k);
    }

    public boolean constraints(){
	for (int x=0;x<4;x++){
	    int[] checker1=new int[5];
	    int[] checker2=new int[5];	    
	    for (int y=0;y<4;y++){
		//	if (SpotGrid[x][y].getNum()!=0){
		checker1[SpotGrid[x][y].getNum()]++;
		checker2[SpotGrid[y][x].getNum()]++;
		//		}
	    }
	    for (int z=1;z<5;z++){
		if (checker1[z]>1||checker2[z]>1){
		    return false;
		}
	    }
	}
	for (int i=0;i<4;i++){
	    for(int j=0;j<4;j++){
		if (SpotGrid[i][j].getNum()!=0){
		    if (ConsMatrix[i][j].getConnection()!=0){
			if (SpotGrid[ConsMatrix[i][j].getConnection()/4][ConsMatrix[i][j].getConnection()%4].getNum()!=0){			
			    if (ConsMatrix[i][j].getOp().equals("+")){
				if (SpotGrid[i][j].getNum()+SpotGrid[ConsMatrix[i][j].getConnection()/4][ConsMatrix[i][j].getConnection()%4].getNum()!=ConsMatrix[i][j].getNum()){
				    return false;
				}
			    }
			    else if (ConsMatrix[i][j].getOp().equals("-")){
				if (Math.abs(SpotGrid[i][j].getNum()-SpotGrid[ConsMatrix[i][j].getConnection()/4][ConsMatrix[i][j].getConnection()%4].getNum())!=ConsMatrix[i][j].getNum()){
				    return false;
				}
			    }
			    else if (ConsMatrix[i][j].getOp().equals("*")){
				if (SpotGrid[i][j].getNum()*SpotGrid[ConsMatrix[i][j].getConnection()/4][ConsMatrix[i][j].getConnection()%4].getNum()!=ConsMatrix[i][j].getNum()){
				    return false;
				}
			    }
			    else if (ConsMatrix[i][j].getOp().equals("/")){
				if ((SpotGrid[i][j].getNum()/SpotGrid[ConsMatrix[i][j].getConnection()/4][ConsMatrix[i][j].getConnection()%4].getNum()!=ConsMatrix[i][j].getNum())&&(SpotGrid[ConsMatrix[i][j].getConnection()/4][ConsMatrix[i][j].getConnection()%4].getNum()/SpotGrid[i][j].getNum()!=ConsMatrix[i][j].getNum())){
				    return false;
				}
			    }
			}
		    }
		}
	    }
	}
	return true;	
    }

    public void addFile(String fileName) {
	File f = new File(fileName);
	Scanner sc=null; 
	try {
	    sc=new Scanner(f);
	}
	catch (FileNotFoundException e){
	    e.printStackTrace();
	    System.out.println("File "+fileName+" doesn't exist");
	    System.exit(1);
	}
	int i=0;
	while (sc.hasNext()){
	    if (sc.hasNextInt()){
		int inte=sc.nextInt();
		if (inte==0){
		    ConstraintArray[i++]=new Spot();
		}
		else{
		    ConstraintArray[i]=new Spot(inte%10);
		    ConstraintArray[i++].setConnection(inte/10);
		}
	    }
	    else{
		String throwAway=sc.next();
		if (throwAway.equals("+")||throwAway.equals("-")||throwAway.equals("*")||throwAway.equals("/")){
		    ConstraintArray[i-1].setOp(throwAway);			    
		}
	    }
	}
	for (int d=0;d<4;d++){
	    for (int e=0; e<4;e++){
			SpotGrid[d][e]=new Spot();
	    }
	}
	for (int k=0;k<16;k++){
	    if (ConstraintArray[k].getOp()!=null){
		System.out.print(ConstraintArray[k].getNum()+ConstraintArray[k].getOp()+" "+ConstraintArray[k].getConnection()+"   ");
	    }
	    else{
		System.out.print(ConstraintArray[k].getNum()+" ");
	    }
	}
	System.out.println();	    
    }

    public void matrixConverter(Spot[] ConstraintArray){
	int row=0;
	int col=0;
	for (int i=0;i<ConstraintArray.length;i++){
	    ConsMatrix[row][col++]=ConstraintArray[i];
	    if (col>=ConsMatrix[row].length){
		col=0;
		row++;
	    }
	}
	for (int i=0; i<ConsMatrix.length;i++){
	    for(int j=0; j<ConsMatrix[i].length;j++){
		System.out.print(ConsMatrix[i][j].getNum()+" ");
	    }
	    System.out.println();
	}
    }

		
    /*    public static void main(String[] args){
	Kenken g1=new Kenken();	
	g1.go(args[0]);
    }
    public void go(String filename){	
	for (int i=0;i<4;i++){
	    for (int j=0; j<4;j++){
		SpotGrid[i][j]=new Spot();
	    }
	}
	addFile(filename);	    	
	matrixConverter(ConstraintArray);
	}*/
}