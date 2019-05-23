import java.awt.*; //Needed for the Frame
import java.awt.event.*;

public class Rendering extends Frame{

    public void drawWindow() {
        //iniate new window with 500x500 pixel
        setSize(500, 500);
        addWindowListener(new WindowAdapter() {
            @Override
            //Closing window on topping process
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    //what is going to be rendered
    public void paint(Graphics g) {
        g.drawString("Render-Fenster", 120, 60);
    }

    /**
     * this will start the rendering process
     * @param args
     */
    public static void main(String args[]){
        new Rendering().setVisible(true);

    }
}
