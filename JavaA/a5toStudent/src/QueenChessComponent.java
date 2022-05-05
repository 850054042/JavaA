import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public QueenChessComponent(int x,int y){
        super(x, y);
    }
}
