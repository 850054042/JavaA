public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * should design
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * should design
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.format("(%d,%d)",x,y);
    }

    public boolean isValidX(int dx){
        return (x + dx >= 0) & (x + dx <= 7);
    }

    public boolean isValidY(int dy){
        return (y + dy >= 0) & (y + dy <= 7);
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if(isValidX(dx) && isValidY(dy)){
            return new ChessboardPoint(x + dx,y + dy);
        }
        return null;
    }
}
