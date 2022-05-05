import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public PawnChessComponent(int x,int y){
        super(x, y);
    }
}
