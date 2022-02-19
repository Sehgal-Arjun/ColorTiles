public class Draw extends ColorTiles {

    public static void initBoard(Colors[][] board){
        StdDraw.clear();
        String[] colors = {"yellow", "blue", "pink", "purple", "orange", "green", "red"};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String col = colors[(int) (Math.random() * 7.0)];
                if (i == 0 || i == board.length - 1) col = "pink";
                else if (col.equals("yellow") && (j == 0 || j == board.length - 1)) col = "pink";
                if (col.equals("pink") && i > 0 && i < board.length - 1) col = "green";
                board[i][j] = new Colors(col);
            }
        }
        board[0][0].setBlack(true);
        for (int i = board.length - 1; i >= 0; i--){
            for (int j = board[i].length - 1; j >= 0; j--){
                changeColor(board[i][j]);
                if (i == 0 || i == board.length - 1) StdDraw.setPenColor(StdDraw.PINK);
                if (board[i][j].isBlack()) {
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledCircle(i, j, 0.5);
                }
                else {
                    StdDraw.filledSquare(i, j, 0.5);
                }
            }
        }
        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.filledSquare(0, 0, 0.5);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(0, 0, 0.5);
        StdDraw.show();
    }

    public static void drawBoard(Colors[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                changeColor(board[i][j]);
                StdDraw.filledSquare(i, j, 0.5);
                if (board[i][j].isBlack()){
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledCircle(i, j, 0.5);
                }

            }
        }
    }

    public static void update(Colors[][] board, int[] pos){
        int z = 0;
        int v = 0;
        boolean ran = false;
        StdDraw.clear();
        Draw.drawBoard(board);
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j].isBlack()){
                    changeColor(board[i][j]);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledCircle(i, j, 0.5);
                    board[i][j].setBlack(false);
                }
            }
        }
        board[pos[2]][pos[3]].setBlack(true);
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].isBlack()) {
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledCircle(i, j, 0.5);
                    if (board[i][j].getColor().equals("red")){
                        board[i][j].setBlack(false);
                        changeColor(board[i][j]);
                        StdDraw.filledSquare(i, j, 0.5);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.filledCircle(i - 1, j, 0.5);
                        int y = 1;
                        int x = i-y;
                        while (board[x][j].getColor().equals("red")){
                            y++;
                            x = i-y;
                        }
                        board[x][j].setBlack(true);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.filledCircle(x,j,0.5);
                        pos[0] = pos[0] - y;
                        pos[2] = pos[2] - y;

                        for (int a = 0; a < board.length; a++){
                            for (int b = 0; b < board[i].length; b++){
                                if (!board[a][b].isBlack()){
                                    changeColor(board[a][b]);
                                    StdDraw.filledSquare(a,b,0.5);
                                }
                            }
                        }
                    }
                    else if (board[i][j].getColor().equals("purple")){
                        String[] colors = {"yellow", "blue", "pink", "orange", "green", "red"};
                        for (int r = 0; r < board.length; r++){
                            for (int c = 0; c < board[i].length; c++){
                                String col = colors[(int) (Math.random() * 6.0)];
                                if (i == 0 || i == board.length - 1) col = "pink";
                                else if (col.equals("yellow") && (j == 0 || j == board.length - 1)) col = "pink";
                                if (col.equals("pink") && i > 0 && i < board.length - 1) col = "green";
                                if (r == i && c == j) col = "pink";
                                board[i][j] = new Colors(col);
                                changeColor(board[i][j]);
                                StdDraw.filledSquare(i, j, 0.5);
                                board[i][j].setBlack(true);
                            }
                        }
                    }
                    else if (board[i][j].getColor().equals("yellow")){
                        ran = true;
                        z = i;
                        v = j;
                        board[z][v].setBlack(true);
                        int num = (int) (Math.random() * 2.0);
                        String[] colors = {"yellow", "blue", "purple", "orange", "green", "red"};
                        if (num == 1){
                            for (int r = 1; r < board.length - 1; r++){
                                for (int c = 1; c < board[i].length - 1; c++){
                                    String col = colors[(int) (Math.random() * 6.0)];
                                    if (r == 0 || r == board.length - 1) col = "pink";
                                    else if (col.equals("yellow") && (c == 0 || c == board.length - 1)) col = "pink";
                                    if (r == i && c == j) col = "green";
                                    board[r][c] = new Colors(col);
                                }
                            }
                        }
                    }
                }
                else{
                    changeColor(board[i][j]);
                    StdDraw.filledCircle(i, j, 0.5);
                }
            }
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (!board[i][j].isBlack()){
                    changeColor(board[i][j]);
                    StdDraw.filledSquare(i,j,0.5);
                }
                else{
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledCircle(i,j,0.5);
                }
            }
        }
        if (ran){
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(z, v, 0.5);
        }
        StdDraw.show();
    }
    public static void changeColor(Colors object){
        if (object.getColor().equals("yellow")) StdDraw.setPenColor(StdDraw.YELLOW);
        else if (object.getColor().equals("blue")) StdDraw.setPenColor(StdDraw.BLUE);
        else if (object.getColor().equals("pink")) StdDraw.setPenColor(StdDraw.PINK);
        else if (object.getColor().equals("purple")) StdDraw.setPenColor(StdDraw.MAGENTA);
        else if (object.getColor().equals("orange")) StdDraw.setPenColor(StdDraw.ORANGE);
        else if (object.getColor().equals("green")) StdDraw.setPenColor(StdDraw.GREEN);
        else if (object.getColor().equals("red")) StdDraw.setPenColor(StdDraw.RED);
        else StdDraw.setPenColor(StdDraw.BLACK);
    }
}
