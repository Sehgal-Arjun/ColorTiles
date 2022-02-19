public class Colors{

    private String color;
    private boolean black;

    public Colors(String color) {
        this.color = color;
        black = false;
    }

    public String getColor() {
        return color;
    }

    public boolean isBlack() {
        return black;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }
}
