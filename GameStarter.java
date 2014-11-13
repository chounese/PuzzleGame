import java.awt.*;
import javax.swing.*;
import java.io.*;

public class GameStarter extends JFrame {

	private JLabel message;
	
	public void init(){

		// Exit when window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());

		JPanel jpan2=new JPanel(new FlowLayout());
		jpan2.setPreferredSize(new Dimension(300,300));

		message = new JLabel("Pick a Game");
		jpan2.add(message);

		JButton jb3 = new JButton("Games");
		jpan2.add(jb3);
		SwitchMenuListener b1=new SwitchMenuListener(jb3, this);
		jb3.addActionListener(b1);

		ct.add(jpan2);
	}

	public void setMessage(String mess) {
		message.setText(mess);
	}
}
