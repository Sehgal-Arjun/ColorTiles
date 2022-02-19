import java.util.concurrent.TimeUnit;
import javax.swing.*;


public class ColorTiles extends JFrame
{
    public static void main(String[] args) throws InterruptedException{
	// write your code here
        StdDraw.enableDoubleBuffering();
        Rules window = new Rules();
        window.setVisible(true);
        StdDraw.setScale(-0.5, 7.5);
        int[] pos = {0, 0, 0, 0};
        Colors[][] board = new Colors[8][8];
        Draw.initBoard(board);
        Draw.drawBoard(board);
        while (!win(board)){
            TimeUnit.MILLISECONDS.sleep(200); // wait for 200 milliseconds
            if (gameOver(board)) {
                System.out.println(deathMessage(board));
                return;
            }
            else {
                handleClicks(board, pos, 0);
                Draw.update(board, pos);
            }
            Draw.drawBoard(board);
        }
        System.out.println("Good job! You won!");
    }

    public static String deathMessage(Colors[][] board){
        Colors death;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j].isBlack()) {
                    death = new Colors(board[i][j].getColor());
                    String col = death.getColor();
                    if (col.equals("blue")) return "You died to electrocution!";
                    else if (col.equals("orange")) return "You died to lava!";
                    else return "you died";
                }
            }
        }
        return "error";
    }

    public static int[] handleClicks(Colors[][] board, int[] pos, int number){
        while (true){
            while (true) {
                // Wait for up, left, right, or down press
                if (StdDraw.isKeyPressed(68)){ // keycode for d (right)
                    number = 1;
                    break;
                }
                if (StdDraw.isKeyPressed(65)){ // keycode for a (right)
                    number = 2;
                    break;
                }
                if (StdDraw.isKeyPressed(83)){ // keycode for s (down)
                    number = 3;
                    break;
                }
                if (StdDraw.isKeyPressed(87)){ // keycode for w (up)
                    number = 4;
                    break;
                }
            }
            pos[0] = pos[2];
            pos[1] = pos[3];
            if (number == 1 && pos[0] != board.length - 1) {
                pos[2] = pos[0] + 1;

                return pos;
            }
            else if (number == 2 && pos[0] != 0) {
                pos[2] = pos[0] - 1;
                return pos;
            }
            else if (number == 4 && pos[1] != board[0].length - 1) {
                pos[3] = pos[1] + 1;
                return pos;
            }
            else if (number == 3 && pos[1] != 0) {
                pos[3] = pos[1] - 1; // down
                return pos;
            }
            pos[0] += pos[2];
            pos[1] += pos[3];
        }

    }
    public static boolean win(Colors[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (i == board.length - 1 && board[i][j].isBlack()) return true;
            }
        }
        return false;
    }

    public static boolean gameOver(Colors[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].isBlack()) {
                    if (board[i][j].getColor().equals("blue")) {
                        if (i + 1 <  board.length - 1 && board[i + 1][j].getColor().equals("yellow"))
                        {
                            return true; // yellow above
                        }
                        else if (i - 1 > 0 && board[i - 1][j].getColor().equals("yellow"))
                        {
                            return true; // yellow below
                        }
                        else if (j + 1 < board[i].length && board[i][j + 1].getColor().equals("yellow"))
                        {
                            return true; // yellow right
                        }
                        else if (j - 1 > 0 && board[i][j - 1].getColor().equals("yellow"))
                        {
                            return true;
                        }
                    }
                    else if (board[i][j].getColor().equals("orange")) return true;
                }
            }
        }
        return false;
    }
}