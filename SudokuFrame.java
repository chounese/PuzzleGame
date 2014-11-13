import java.awt.*;
import javax.swing.*;
import java.io.*;

public class SudokuFrame extends JFrame {

	private JLabel message;
	private int buttonCount = 81;
	private JButton[] buttons;
	
	public void init(){

		// Exit when window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());

		DisplayPanel two = new DisplayPanel();
		
		Game game1 = new Sudoku();

		DisplayPanel panel = new DisplayPanel();
		
		buttons = new JButton[buttonCount];
		int count = 0;
		game1.addFile("SampleSudoku.txt");
		game1.setGSs(game1.getSpots());
		JPanel jpan2=new JPanel(new FlowLayout());
		JPanel jpan1=new JPanel(new GridLayout(9,9));
		jpan1.setPreferredSize(new Dimension(600,600));

		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (game1.getSpots()[i][j].getNum()==0) {
					JButton jb = new JButton();
					buttons[count++] = jb;
					ButtonToMenuListener btml = new ButtonToMenuListener(jb, game1, i, j);
					jb.addActionListener(btml);
					jpan1.add(jb);
				}
				else {
					JButton jb = new JButton(""+game1.getSpots()[i][j].getNum());
					buttons[count++] = jb;
					jpan1.add(jb);
					jpan1.setEnabled(false);
				}
			}
		}
		message = new JLabel("Sudoku");
		jpan2.add(message);
	
		JButton jb = new JButton("Check");
		jpan2.add(jb);
		CheckListener cl = new CheckListener(game1, this);
		jb.addActionListener(cl);

		JButton jb2 = new JButton("Solve");
		jpan2.add(jb2);
		SolveListener sl = new SolveListener(game1, this);
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
