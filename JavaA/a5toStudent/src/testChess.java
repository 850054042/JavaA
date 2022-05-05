import java.util.ArrayList;
import java.util.List;

public class testChess {
    public static void main(String[] args) {
        ConcreteChessGame concreteChessGame = new ConcreteChessGame();
        List<String> board = new ArrayList<>();
        board.add("RN_QKBNR");
        board.add("PPPPPPPP");
        board.add("________");
        board.add("___B____");
        board.add("________");
        board.add("________");
        board.add("ppp_pppp");
        board.add("rnbqkbnr");
        board.add("w");
        concreteChessGame.loadChessGame(board);
        List<ChessboardPoint> chessboardPoints = concreteChessGame.getCanMovePoints(new ChessboardPoint(7,2));
        for(ChessboardPoint chessboardPoint : chessboardPoints){
            System.out.println(chessboardPoint);
        }
    }
}
