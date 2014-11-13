import java.awt.*;
import java.io.*;

public class Start {
	
	public static void main(String[] args) throws IOException {
		
		GameStarter frame = new GameStarter();
		frame.init();
		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(new Dimension(250,250));
		frame.repaint();
		
		// this method must finish and return before GUI handling begins
	}
	
}
