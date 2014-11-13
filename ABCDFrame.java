import java.awt.*;
import javax.swing.*;
import java.io.*;

public class ABCDFrame extends JFrame {

	private JLabel message;
	private int buttonCount = 36;
	private JButton[] buttons;
	
	public void init(){

		//this.setTitle("");
		//this.setSize(dimension);
		//this.setVisible(true);
		
		// Exit when window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container ct = getContentPane();

		ct.setLayout(new FlowLayout());

		DisplayPanel two = new DisplayPanel();
		
		Game game1 = new ABCD();

		DisplayPanel panel = new DisplayPanel();
		JPanel jpan2=new JPanel(new FlowLayout());
		JPanel jpan1=new JPanel(new GridLayout(6,6));
		jpan1.setPreferredSize(new Dimension(600,600));
		
		buttons = new JButton[buttonCount];
		int count = 0;
		game1.addFile("SampleABCD.txt");
		game1.setGSs(game1.getSpots());
		game1.matrixConverter(game1.getConstraintArray());

		for (int i=0; i<6; i++) {
			for (int j=0; j<6; j++) {
				if (game1.getSpots()[i][j].getNum()==0) {
					JButton jb = new JButton();
					if 	(i==0){
						JPanel panel2=new JPanel(new FlowLayout());
						panel2.setLayout(new GridLayout(1,1));
						if (game1.getConsMatrix()[6+j][0].getNum()!=0){
						JLabel lab=new JLabel(letterConverter(game1.getConsMatrix()[6+j][0].getNum())+" "+Integer.toString(game1.getConsMatrix()[6+j][0].getConnection()));
						lab.setVerticalAlignment(JLabel.TOP);
						lab.setHorizontalAlignment(JLabel.CENTER);
						panel2.add(lab);
						panel2.setOpaque(false);
						jb.add(panel2);
						}
					}
					if (j==0){
						JPanel panel2=new JPanel(new FlowLayout());
						panel2.setLayout(new GridLayout(1,1));
						if (game1.getConsMatrix()[5-i][0].getNum()!=0){
						JLabel lab=new JLabel(letterConverter(game1.getConsMatrix()[5-i][0].getNum())+" "+Integer.toString(game1.getConsMatrix()[5-i][0].getConnection()));
						lab.setVerticalAlignment(JLabel.CENTER);
						lab.setHorizontalAlignment(JLabel.LEFT);
						panel2.add(lab);
						panel2.setOpaque(false);
						jb.add(panel2);
					}
					}
					if (i==5){
						JPanel panel2=new JPanel(new FlowLayout());
						panel2.setLayout(new GridLayout(1,1));
						if (game1.getConsMatrix()[6+j][1].getNum()!=0){
						JLabel lab=new JLabel(letterConverter(game1.getConsMatrix()[6+j][1].getNum())+" "+Integer.toString(5-game1.getConsMatrix()[6+j][1].getConnection()));
						lab.setVerticalAlignment(JLabel.BOTTOM);
						lab.setHorizontalAlignment(JLabel.CENTER);
						panel2.add(lab);
						panel2.setOpaque(false);
						jb.add(panel2);
					}
					}
					if (j==5){
						JPanel panel2=new JPanel(new FlowLayout());
						panel2.setLayout(new GridLayout(1,1));
						if (game1.getConsMatrix()[5-i][1].getNum()!=0){
						JLabel lab=new JLabel(letterConverter(game1.getConsMatrix()[5-i][1].getNum())+" "+Integer.toString(5-game1.getConsMatrix()[5-i][1].getConnection()));
						lab.setVerticalAlignment(JLabel.CENTER);
						lab.setHorizontalAlignment(JLabel.RIGHT);
						panel2.add(lab);
						panel2.setOpaque(false);
						jb.add(panel2);
					}
					}
					buttons[count++] = jb;
					ABCDButtonToMenuListener btml = new ABCDButtonToMenuListener(jb, game1, i, j);
					jb.addActionListener(btml);
					jpan1.add(jb);
				}
				else {
					JButton jb = new JButton(""+game1.getSpots()[i][j].getNum());
					buttons[count++] = jb;
					jpan1.add(jb);
					jb.setEnabled(false);
				}
			}
		}
		message = new JLabel("Easy As ABC");
		jpan2.add(message);
	
		JButton jb = new JButton("Check");
		jpan2.add(jb);
		ABCDCheckListener cl = new ABCDCheckListener(game1, this);
		jb.addActionListener(cl);

		JButton jb2 = new JButton("Solve");
		jpan2.add(jb2);
		ABCDSolveListener sl = new ABCDSolveListener(game1, this);
		jb2.addActionListener(sl);

		JButton jb3 = new JButton("Switch");
		jpan2.add(jb3);
		SwitchMenuListener b1=new SwitchMenuListener(jb3, this);
		jb3.addActionListener(b1);

		ct.add(jpan2);
		ct.add(jpan1);
	}

	public void setMessage(String mess) {
		message.setText(mess);
	}

	private int randomColorCoord() {
		return (int) (Math.random()*256);
	}
	
	public void setDoneMessage(String message1) {
		message.setText(message1);
		for (JButton b : buttons) {
			b.setEnabled(false);
		}
	}

	public String letterConverter(int n){
		if (n==1){
			return "A";
		}
		else if (n==2){
			return "B";
		}
		else if (n==3){
			return "C";
		}
		else if (n==4){
			return "D";
		}
		else
			return "";
	}

	public void rePaint(Game g){
		Spot[][] spots = g.getSpots();
		int count = 0;
		for (int i=0; i<spots.length; i++) {
			for (int j=0; j<spots.length; j++) {
				JButton click = buttons[count++];
				if (spots[i][j].getNum()==5){
					click.setLabel("-");
				}
				else{
				click.setLabel("" + spots[i][j].getNum());
				}
			}
		}
	}
}
