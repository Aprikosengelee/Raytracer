import javax.swing.*;
import java.awt.*; //Needed for the Frame
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class Rendering extends JPanel {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    private BufferedImage canvas;
    private static Rendering instance = null;

    public Rendering(int width, int height) {
        canvas = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < canvas.getWidth(); i++) {
            for (int j = 0; j < canvas.getHeight(); j++){
                canvas.setRGB(i, j, Color.BLACK.getRGB());
            }
        }
        //set canvas width and height same as the buffered image
        this.setPreferredSize(new Dimension(width, height));
    }

    //Draws the image
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }

    public static Rendering getRendering(){
        if (Rendering.instance == null){
            Rendering.instance = new Rendering(WIDTH, HEIGHT);
        }
        return Rendering.instance;
    }

    /**
     * The actual drawing method, to get the picture pixel pixel
     * @param x - position x of the pixel in our frame
     * @param y - position y of the pixel in our frame
     * @param rgb - which color it will be
     */
    public static void setPixel(int x, int y, int rgb){
        Rendering inst = getRendering();
        if ((x < WIDTH -1) || (y < HEIGHT - 1) || (x < 0) || (y < 0)){
            return;
        }
        inst.canvas.setRGB(x, y, rgb);
        inst.repaint();
    }

    /**
     * this will start the rendering process
     * @param args
     */
    public static void main(String args[]){
        Rendering panel = getRendering();
        JFrame frame = new JFrame("Raytracer");
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
