import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.*;
import javax.swing.*;
import java.io.*;


public class CheckListener implements ActionListener {

	private Game game;
	private SudokuFrame frame;

	public CheckListener(Game game, SudokuFrame frame) {
		  this.game = game;
		  this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		if (game.constraints()==true && game.finished()==true) {
			frame.setMessage("You Win");
		}
		else if (!game.finished()){
			frame.setMessage("Finish the game first");
		}
		else {
			frame.setMessage("You Lose");
		}
	}


}
