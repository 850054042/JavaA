import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public KingChessComponent(int x,int y){
        super(x, y);
    }
}