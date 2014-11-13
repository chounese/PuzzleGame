import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

public class SwitchListener implements ActionListener {
	
	private JButton myButton;
	private JFrame frame;


	public SwitchListener(JButton clicker, JFrame fr) {
		myButton = clicker;
		frame=fr;
	}
	
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Sudoku")){
			SudokuFrame fra=new SudokuFrame();
			fra.init();
			fra.pack();
			fra.setVisible(true);
			fra.setSize(new Dimension(900,900));
			fra.repaint();
			frame.dispose();
		}
		if (action.equals("Kenken")){
			KenkenFrame fra = new KenkenFrame();
			fra.init();
			fra.pack();
			fra.setVisible(true);
			fra.setSize(new Dimension(900,900));
			fra.repaint();
			frame.dispose();
		}
		if (action.equals("Easy as ABC")){
			ABCDFrame fra = new ABCDFrame();
			fra.init();
			fra.pack();
			fra.setVisible(true);
			fra.setSize(new Dimension(900,900));
			fra.repaint();
			frame.dispose();
		}
	}

		
}
