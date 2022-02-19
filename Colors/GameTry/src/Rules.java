import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rules extends Draw{

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 740;


    public Rules(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        add(new GamePanel());
        }
    }

    class GamePanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            showText("RULES: You need to get to the last column (the pink).", g2d, 100);
            showText("Green is safe.", g2d, 155);
            showText("Red sends you one square to the left of it.", g2d, 210);
            showText("and you are safe wherever you land.", g2d, 265);
            showText("Blue is safe, unless there is a yellow square above,", g2d, 320);
            showText("below, to the left, or to the right of it.", g2d, 375);
            showText("Yellow has a 50% chance of randomizing the board.", g2d, 430);
            showText("Orange is deadly.", g2d, 485);
            showText("Purple changes once you step on it - be careful.", g2d, 540);
            showText("Good luck!", g2d, 595);

        }

        private void showText(String s, Graphics2D g2d, int y){
            Font font = new Font("SansSerif", Font.BOLD, 35);
            g2d.setFont(font);

            Rectangle2D stringBounds = font.getStringBounds(s, g2d.getFontRenderContext());
            g2d.setColor(Color.BLACK);
            g2d.drawString(s, (float) ((Rules.WIDTH / 2) - stringBounds.getWidth()/2), y);
        }


    }

