import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class KenButtonToMenuListener implements ActionListener {

	private JButton myButton;
	JPopupMenu  menu;
	
	public KenButtonToMenuListener(JButton clicker, Game game,  int i, int j) {
		myButton = clicker;
		
		// create a popup menu
		menu = new JPopupMenu("Menu");
		NumberChangeListener scl = new NumberChangeListener(myButton, game, i, j);
		
        // create a menu item
        
		JMenuItem one = new JMenuItem("1");
		menu.add(one);
		one.addActionListener(scl);

		JMenuItem two = new JMenuItem("2");
		menu.add(two);
		two.addActionListener(scl);

		JMenuItem three = new JMenuItem("3");
		menu.add(three);
		three.addActionListener(scl);

		JMenuItem four = new JMenuItem("4");
		menu.add(four);
		four.addActionListener(scl);
	}

	public void actionPerformed(ActionEvent e) {
		
		menu.show(myButton,myButton.getWidth()/2,myButton.getHeight()/2);
	}


}
