import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;


public class NumberChangeListener implements ActionListener {
	
	private JButton myButton;
	private Game game;
	private int i;
	private int j;

	public NumberChangeListener(JButton clicker, Game game,  int i, int j) {
		myButton = clicker;
		this.game = game;
		this.i = i;
		this.j = j;

	}
	
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("1")){
			game.add(i,j,1);
			myButton.setLabel("1");
		}
		if (action.equals("2")){
			game.add(i,j,2);
			myButton.setLabel("2");
		}
		if (action.equals("3")){
			game.add(i,j,3);
			myButton.setLabel("3");
		}
		if (action.equals("4")){
			game.add(i,j,4);
			myButton.setLabel("4");
		}
		if (action.equals("5")){
			game.add(i,j,5);
			myButton.setLabel("5");
		}
		if (action.equals("6")){
			game.add(i,j,6);
			myButton.setLabel("6");
		}								
		if (action.equals("7")){
			game.add(i,j,7);
			myButton.setLabel("7");
		}
		if (action.equals("8")){
			game.add(i,j,8);
			myButton.setLabel("8");
		}
		if (action.equals("9")){
			game.add(i,j,9);
			myButton.setLabel("9");
		}				
		if (action.equals("Blank")){
			game.add(i,j,5);
			myButton.setLabel("-");
		}
	}

		
}
