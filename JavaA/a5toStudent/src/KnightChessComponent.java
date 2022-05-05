import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public KnightChessComponent(int x,int y){
        super(x,y);
    }
}
