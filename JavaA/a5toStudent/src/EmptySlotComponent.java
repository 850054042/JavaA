import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public EmptySlotComponent(int x,int y){
        super(x, y);
    }
}