public class Spot{
    private boolean Set=false;
    private int num;
    private String op=null;
    private int Connection=0;

    public Spot(){
	num=0;
    }

    public Spot(int n){
	Set=true;
	num=n;
    }
    
    public int getConnection(){
	return Connection;
    }
    
    public void setConnection(int bud){
	Connection=bud;
    }

    public String getOp(){
	return op;
    }
    public void setOp(String Operator){
	op=Operator;
    }

    public void reSet(){
	num=0;
	Set=false;
    }
    public boolean getSet(){
	return this.Set;
    }
    public void setSet(boolean tf){
	this.Set=tf;
    }
    public int getNum(){
	return this.num;
    }
    public void setNum(int n){
	num=n;
	Set=true;
    }

}