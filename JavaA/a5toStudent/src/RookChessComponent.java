import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public RookChessComponent(int x,int y){
        super(x,y);
    }
}
