import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = ConcreteChessGame.chessBoard;
        int x = super.getX();
        int y = super.getY();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessComponent chess = chessComponents[x][y];
        int initAngle = 0;
        for(int i = 1;i <= 8;i++) {
            for (int j = 1; j < 8; j++) {
                double s = Math.sin(initAngle + i * 0.7854);
                double c = Math.cos(initAngle + i * 0.7854);
                int sinAngle = Math.abs(s) > 0.1 ? (s > 0 ? (int) Math.floor(s * 1.5) : (int) Math.ceil(s * 1.5)) : 0;
                int cosAngle = Math.abs(c) > 0.1 ? (c > 0 ? (int) Math.floor(c * 1.5) : (int) Math.ceil(c * 1.5)) : 0;
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

    public QueenChessComponent(int x,int y){
        super(x, y);
    }
    public QueenChessComponent(){}
}
