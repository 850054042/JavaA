import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(){}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = super.getChessBoard();
        int x = super.getX();
        int y = super.getY();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for(int i = x - 2;i <= x + 2;i++)
            for(int j = y - 2;j <= y + 2;j++)
                if((Math.abs(i - x) * Math.abs(j - y) == 2) && isValid(i) && isValid(j))
                    chessboardPoints.add(new ChessboardPoint(i,j));
        List<ChessboardPoint> toDelete = new ArrayList<>();
        ChessComponent chess = chessComponents[x][y];
        for(ChessboardPoint chessboardPoint : chessboardPoints){
            int targetX = chessboardPoint.getX();
            int targetY = chessboardPoint.getY();
            if(chessComponents[targetX][targetY].name != '_'){
                if(!chess.isOpposite(chessComponents[targetX][targetY])){
                    toDelete.add(chessboardPoint);
                }
            }
        }
        for(ChessboardPoint chessboardPoint : toDelete){
            chessboardPoints.remove(chessboardPoint);
        }
        return chessboardPoints;
    }
    public KnightChessComponent(int x,int y){
        super(x,y);
    }
    public boolean isValid(int a){
        return a <= 7 & a >= 0;
    }
}
