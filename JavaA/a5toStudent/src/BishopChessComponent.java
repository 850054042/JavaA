import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public BishopChessComponent(int x,int y){
        super(x,y);
    }
}
