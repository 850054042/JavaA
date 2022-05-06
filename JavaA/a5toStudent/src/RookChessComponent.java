import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = super.getChessBoard();
        int x = super.getX();
        int y = super.getY();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for(int i = 0;i < 8;i++){
            if(x + i < 8){
                chessboardPoints.add(new ChessboardPoint(x + i,y));
            }
            else{
                break;
            }
        }
        for(int i = 0;i < 8;i++){
            if(x - i >= 0){
                chessboardPoints.add(new ChessboardPoint(x - i,y));
            }
            else{
                break;
            }
        }
        for(int i = 0;i < 8;i++){
            if(y + i < 8){
                chessboardPoints.add(new ChessboardPoint(x,y + i));
            }
            else{
                break;
            }
        }
        for(int i = 0;i < 8;i++){
            if(y - i >= 0){
                chessboardPoints.add(new ChessboardPoint(x,y - i));
            }
            else{
                break;
            }
        }
        List<ChessboardPoint> toDelete = new ArrayList<>();
        ChessComponent chess = chessComponents[x][y];
        boolean blocked = false;
        for(ChessboardPoint chessboardPoint : chessboardPoints){
            int targetX = chessboardPoint.getX();
            int targetY = chessboardPoint.getY();
            if(targetX == x && targetY == y){
                blocked = false;
                toDelete.add(chessboardPoint);
                continue;
            }
            if(blocked == true){
                toDelete.add(chessboardPoint);
                continue;
            }
            if(chessComponents[targetX][targetY].name != '_'){
                if(chess.isOpposite(chessComponents[targetX][targetY])){
                    blocked = true;
                }
                else{
                    blocked = true;
                    toDelete.add(chessboardPoint);
                }
            }
        }
        for(ChessboardPoint chessboardPoint : toDelete){
            chessboardPoints.remove(chessboardPoint);
        }
        return chessboardPoints;
    }
    public RookChessComponent(int x,int y){
        super(x,y);
    }
    public RookChessComponent(){}
}
