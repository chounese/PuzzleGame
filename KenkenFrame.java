import java.awt.*;
import javax.swing.*;
import java.io.*;

public class KenkenFrame extends JFrame {

	private JLabel message;
	private int buttonCount = 16;
	private JButton[] buttons;
	
	public void init(){

		// Exit when window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());

		DisplayPanel two = new DisplayPanel();
		
		Game game1 = new Kenken();

		DisplayPanel panel = new DisplayPanel();
		JPanel jpan2=new JPanel(new FlowLayout());
		JPanel jpan1=new JPanel(new GridLayout(4,4));
		jpan1.setPreferredSize(new Dimension(600,600));
		
		buttons = new JButton[buttonCount];
		int count = 0;
		game1.addFile("SampleKenken.txt");
		game1.setGSs(game1.getSpots());
		game1.matrixConverter(game1.getConstraintArray());

		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				if (game1.getSpots()[i][j].getNum()==0) {
					JButton jb = new JButton();
					if (game1.getConsMatrix()[i][j].getNum()!=0){
						JPanel panel2=new JPanel(new FlowLayout());
						panel2.setLayout(new GridLayout(4,4));
						JLabel lab=new JLabel(Integer.toString(game1.getConsMatrix()[i][j].getNum())+" "+game1.getConsMatrix()[i][j].getOp());
						panel2.add(lab);
						panel2.setOpaque(false);
						jb.add(panel2);
					}
					buttons[count++] = jb;
					KenButtonToMenuListener btml = new KenButtonToMenuListener(jb, game1, i, j);
					jb.addActionListener(btml);
					jpan1.add(jb);
				}
				else {
					JButton jb = new JButton(""+game1.getSpots()[i][j].getNum());
					buttons[count++] = jb;
					ct.add(jb);
					jb.setEnabled(false);
				}
			}
		}
		int counter=0;
		int counter2=0;
		int red=0;
		int green=0;
		int blue=0;
		for (int q=0;q<4;q++){
			for(int r=0;r<4;r++){
				if (game1.getConsMatrix()[q][r].getNum()!=0){
					red=randomColorCoord(counter2++);
					green=randomColorCoord(counter2++);
					blue=randomColorCoord(counter2++);
					buttons[game1.getConsMatrix()[q][r].getConnection()].setBackground(new Color(red,green,blue));
					buttons[counter].setBackground(new Color(red,green,blue));
				}	
				counter++;
			}
		}
		// int counter=0;
		// int red=0;
		// int green=0;
		// int blue=0;
		// for (int q=0;q<4;q++){
		// 	for(int r=0;r<4;r++){
		// 		if (game1.getConsMatrix()[q][r].getNum()!=0){
		// 			red=randomColorCoord(q+r);
		// 			green=randomColorCoord(q+r);
		// 			blue=randomColorCoord(q+r);
		// 			buttons[game1.getConsMatrix()[q][r].getConnection()].setBackground(new Color(red,green,blue));
		// 			buttons[counter].setBackground(new Color(red,green,blue));
		// 		}	
		// 		counter++;
		// 	}
		// }

		message = new JLabel("KenKen");
		jpan2.add(message);
	
		JButton jb = new JButton("Check");
		jpan2.add(jb);
		KenCheckListener cl = new KenCheckListener(game1, this);
		jb.addActionListener(cl);

		JButton jb2 = new JButton("Solve");
		jpan2.add(jb2);
		KenSolveListener sl = new KenSolveListener(game1, this);
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

	private int randomColorCoord(int chicken) {
		if (chicken==0)
			return 255;
		if (chicken==1)
			return 36;
		if (chicken==2)
			return 69;

		if (chicken==3)
			return 175;
		if (chicken==4)
			return 153;
		if (chicken==5)
			return 99;

		if (chicken==6)
			return 36;
		if (chicken==7)
			return 88;
		if (chicken==8)
			return 79;

		if (chicken==9)
			return 135;
		if (chicken==10)
			return 254;
		if (chicken==11)
			return 200;

		if (chicken==12)
			return 77;
		if (chicken==13)
			return 33;
		if (chicken==14)
			return 55;

		if (chicken==15)
			return 1;	 
		if (chicken==16)
			return 1;
		if (chicken==17)
			return 1;

		if (chicken==18)
			return 63;
		if (chicken==19)
			return 126;
		if (chicken==20)
			return 23;

		if (chicken==21)
			return 82;
		if (chicken==22)
			return 84;
		else{
			return 83;
		}
	}

	// private int randomColorCoord() {
	// 	return (int) (Math.random()*256);
	// }
	
	public void setDoneMessage(String message1) {
		message.setText(message1);
		for (JButton b : buttons) {
			b.setEnabled(false);
		}
	}

	public void rePaint(Game g){
		Spot[][] spots = g.getSpots();
		int count = 0;
		for (int i=0; i<spots.length; i++) {
			for (int j=0; j<spots.length; j++) {
				JButton click = buttons[count++];
				click.setLabel("" + spots[i][j].getNum());
			}
		}
	}
}
