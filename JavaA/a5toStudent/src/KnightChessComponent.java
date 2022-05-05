import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(){}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = super.getX();
        int y = super.getY();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for(int i = x - 2;i <= x + 2;i++)
            for(int j = y - 2;j <= y + 2;j++)
                if((Math.abs(i - x) * Math.abs(j - y) == 2) && isValid(i) && isValid(j))
                    chessboardPoints.add(new ChessboardPoint(i,j));
        return chessboardPoints;
    }
    public KnightChessComponent(int x,int y){
        super(x,y);
    }
    public boolean isValid(int a){
        return a <= 7 & a >= 0;
    }
}
