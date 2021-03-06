import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(){}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent chessComponents[][] = new ChessComponent[8][8];
        for(int i = 0;i < 8;i++)
            System.arraycopy(ConcreteChessGame.chessBoard[i], 0, chessComponents[i], 0, 8);
        int x = super.getX();
        int y = super.getY();
        ChessComponent chess = chessComponents[x][y];
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for(int i = x - 1;i <= x + 1;i++)
            for(int j = y - 1;j <= y + 1;j++)
                if((i != x || j != y) && isValid(i) && isValid(j))
                    if(chess.isOpposite(chessComponents[i][j]) || chessComponents[i][j].getChessColor().equals(ChessColor.NONE))
                        chessboardPoints.add(new ChessboardPoint(i,j));
        return chessboardPoints;
    }
    public KingChessComponent(int x,int y){
        super(x, y);
    }
}
