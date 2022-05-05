import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(){}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = super.getX();
        int y = super.getY();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for(int i = x - 1;i <= x + 1;i++)
            for(int j = y - 1;j <= y + 1;j++)
                if((i != x || j != y) && isValid(i) && isValid(j))
                    chessboardPoints.add(new ChessboardPoint(i,j));
        return chessboardPoints;
    }
    public KingChessComponent(int x,int y){
        super(x, y);
    }
    public boolean isValid(int a){
        return a <= 7 & a >= 0;
    }
}
