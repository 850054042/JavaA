import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(){}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = super.getChessBoard();
        int x = super.getX();
        int y = super.getY();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for(int i = x - 1;i <= x + 1;i++)
            for(int j = y - 1;j <= y + 1;j++)
                if((i != x || j != y) && isValid(i) && isValid(j))
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
    public KingChessComponent(int x,int y){
        super(x, y);
    }
    public boolean isValid(int a){
        return a <= 7 & a >= 0;
    }
}
