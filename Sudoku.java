import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku extends Game{
    private Spot[][] SpotGrid=new Spot[9][9];
    private int[] Possibles={1,2,3,4,5,6,7,8,9};
    private Spot[] Empties=new Spot[81];

    public int[] getPossibles(){
	return Possibles;
    }

    public Spot[][] getSpots(){
	return SpotGrid;
    }
    
    public Spot[] getEmpties(){
	int k=0;
	for (int i=0;i<9;i++){
	    for (int j=0;j<9;j++){
		if (SpotGrid[i][j].getSet()==false){
		    Empties[k++]=SpotGrid[i][j];
		}
	    }
	}
	return Empties;
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
	for (int i=0;i<9;i++){
	    for (int j=0;j<9;j++){
		if (sc.hasNextInt()){
		    int inte=sc.nextInt();
		    SpotGrid[i][j]=new Spot(inte);
		}	     
		else{
		    String throwAway=sc.next();
		    SpotGrid[i][j]=new Spot();
		}
	    }
	}
	for (int k=0;k<9;k++){
	    for (int l=0;l<9;l++){
		System.out.print(SpotGrid[k][l].getNum()+" ");
	    }
	    System.out.println();	    
	}
    }

    public void add(int i, int j, int k){
    		SpotGrid[i][j].setNum(k);
    }

    public boolean constraints(){
	for (int x=0;x<9;x++){
	    int[] checker1=new int[10];
	    int[] checker2=new int[10];	    
	    for (int y=0;y<9;y++){
		//	if (SpotGrid[x][y].getNum()!=0){
		    checker1[SpotGrid[x][y].getNum()]++;
		    checker2[SpotGrid[y][x].getNum()]++;
		    //		}
	    }
	    for (int z=1;z<10;z++){
		if (checker1[z]>1||checker2[z]>1){
		    return false;
		}
	    }
	}
	for (int h=0;h<=2;h++){
	    for (int i=0;i<=2;i++){
		int[] checker3=new int[10];
		for (int j=0;j<3;j++){
		    for (int k=0;k<3;k++){
			//	if (SpotGrid[j+(3*h)][k+(3*i)].getNum()!=0){
			    checker3[SpotGrid[j+(3*h)][k+(3*i)].getNum()]++;
			    //	}
		    }
		}
		for (int l=1;l<10;l++){
		    if (checker3[l]>1){
			return false;
		    }
		}
		
	    }
	}
	return true;	
    }
		
    /*    public static void main(String[] args){
	Sudoku s1=new Sudoku();

	s1.go(args[0]);
	}
    public void go(String filename){	
	addFile(filename);
	}*/

}
