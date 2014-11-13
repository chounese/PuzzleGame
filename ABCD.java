import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ABCD extends Game{
    private Spot[][] SpotGrid=new Spot[6][6];
    private int[] Possibles={1,2,3,4,5};
    private Spot[] Empties=new Spot[37];
    private Spot[] ConstraintArray=new Spot[24];
    private Spot[][] ConsMatrix=new Spot[12][2];

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
	for (int i=0;i<6;i++){
	    for (int j=0;j<6;j++){
		if (SpotGrid[i][j].getNum()==0){
		    Empties[k++]=SpotGrid[i][j];
		}
	    }
	}
	return Empties;
    }

    public boolean constraints(){
	for (int x=0;x<6;x++){
	    int[] checker1=new int[6];
	    int[] checker2=new int[6];	    
	    for (int y=0;y<6;y++){
	      	if (SpotGrid[x][y].getNum()!=0){
		    checker1[SpotGrid[x][y].getNum()]++;
		    checker2[SpotGrid[y][x].getNum()]++;
		}
	    }
	    for (int z=1;z<5;z++){
		if (checker1[z]>1||checker2[z]>1){
		    return false;
		}
	    }
	    //force 2 zeros
	    if (checker1[5]>2||checker2[5]>2){
		return false;
	    }
	}
	for (int i=0;i<6;i++){
	    int count1=0;
	    int count2=0;
	    for (int j=0;j<6;j++){
		if (SpotGrid[i][j].getNum()!=0&&SpotGrid[i][j].getNum()!=5){
		    count1++;
		    for (int k=0;k<2;k++){
			if (ConsMatrix[5-i][k].getNum()!=0){
			    if (ConsMatrix[5-i][k].getConnection()==count1){ 
				if (ConsMatrix[5-i][k].getNum()!=SpotGrid[i][j].getNum()){
				    return false;
				}
			    }
			}
		    }
		}
		if (SpotGrid[j][i].getNum()!=0&&SpotGrid[j][i].getNum()!=5){
		    count2++;
		    for (int l=0;l<2;l++){
			if (ConsMatrix[6+i][l].getNum()!=0){
			    if (ConsMatrix[6+i][l].getConnection()==count2){
				if (ConsMatrix[6+i][l].getNum()!=SpotGrid[j][i].getNum()){
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
	    }
	    
	}
	for (int d=0;d<6;d++){
	    for (int e=0; e<6;e++){
		SpotGrid[d][e]=new Spot();
	    }
	}
	for (int k=0;k<24;k++){
	    if (ConstraintArray[k].getConnection()!=0){
		System.out.print(ConstraintArray[k].getNum()+" "+ConstraintArray[k].getConnection()+"   ");
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
    public void add(int i, int j, int k){
    	SpotGrid[i][j].setNum(k);
    }

		
    /*    public static void main(String[] args){
	ABCD g1=new ABCD();	
	g1.go(args[0]);
    }
    public void go(String filename){	
	for (int i=0;i<6;i++){
	    for (int j=0; j<6;j++){
		SpotGrid[i][j]=new Spot();
	    }
	}
	addFile(filename);	    	
	matrixConverter(ConstraintArray);
	}*/
}