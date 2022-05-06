import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = ConcreteChessGame.chessBoard;
        int x = super.getX();
        int y = super.getY();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessComponent chess = chessComponents[x][y];
        int initAngle = 0;
        for(int i = 1;i <= 7;i += 2) {
            for (int j = 1; j < 8; j++) {
                double s = Math.sin(initAngle + i * 0.7854);
                double c = Math.cos(initAngle + i * 0.7854);
                int sinAngle = (int) Math.round(s * 1.4);
                int cosAngle = (int) Math.round(c * 1.4);
                int targetX = x + j * cosAngle;
                int targetY = y + j * sinAngle;
                if (isValid(targetX) && isValid(targetY)) {
                    if (chessComponents[targetX][targetY].name != '_') {
                        if (chess.isOpposite(chessComponents[targetX][targetY])) {
                            chessboardPoints.add(new ChessboardPoint(targetX, targetY));
                        }
                        break;
                    } else {
                        chessboardPoints.add(new ChessboardPoint(targetX, targetY));
                    }
                } else {
                    break;
                }
            }
        }
        return chessboardPoints;
    }
    public BishopChessComponent(int x,int y){
        super(x,y);
    }
    public BishopChessComponent(){}
}
