import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class SwitchMenuListener implements ActionListener {

	private JButton myButton;
	private JFrame frame;
	JPopupMenu  menu;
	
	public SwitchMenuListener(JButton clicker,JFrame fr) {
		myButton = clicker;
		frame=fr;
		
		menu = new JPopupMenu("Menu");
		SwitchListener scl = new SwitchListener(myButton,frame);
		
        // create a menu item

		JMenuItem one = new JMenuItem("Sudoku");
		menu.add(one);
		one.addActionListener(scl);

		JMenuItem two = new JMenuItem("Kenken");
		menu.add(two);
		two.addActionListener(scl);

		JMenuItem three = new JMenuItem("Easy as ABC");
		menu.add(three);
		three.addActionListener(scl);
	}

	public void actionPerformed(ActionEvent e) {
		
		menu.show(myButton,myButton.getWidth()/2,myButton.getHeight()/2);
	}


}
