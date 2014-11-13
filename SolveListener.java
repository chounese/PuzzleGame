import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.*;
import javax.swing.*;
import java.io.*;


public class SolveListener implements ActionListener {

	private Game game;
	private SudokuFrame frame;

	public SolveListener(Game game, SudokuFrame frame) {
		  this.game = game;
		  this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		game.go2("SampleSudoku.txt");
		frame.rePaint(game);
		frame.setMessage("Solution:");
	}

}
