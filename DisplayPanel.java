import java.awt.*;

import javax.swing.JPanel;

//
// JPanels are useful as components to draw on
//

public class DisplayPanel extends JPanel {
	
    private Color col;
    private Color col2 = makeRandomColor();
    private Color col3 = makeRandomColor();
    private Color col4 = makeRandomColor();
    private Color col5 = makeRandomColor();

	public DisplayPanel() {
		// set size, otherwise Java will assume 0 x 0 and component may disappear
		setPreferredSize(new Dimension(0,200));
	}


	public void randomSet() {
	    
	    col = makeRandomColor();
	    
	}
    private boolean c = false;

    public void change(){
	c = true;
    }

/*
 * Called when java wants to draw the panel
 * 
 */
	public void paintComponent(Graphics g) {


		g.setColor(col);
		
		g.drawString("Your First GUI",0,50);
		
		g.setColor(col2);
		g.fillOval(10,10,60,20);

		if (c==true){
		    g.setColor(makeRandomColor());
		    g.drawString("You pressed a button!",0,100);
		}

	}

// Math.random() returns a number between 0 and 1
	
	private Color makeRandomColor() {
		int red = (int) (Math.random()*255);
		int green = (int) (Math.random()*255);
		int blue = (int) (Math.random()*255);

		Color col = new Color(red,green,blue);
		return col;
	}


    }

