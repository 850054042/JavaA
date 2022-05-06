import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    public static ChessComponent[][] chessBoard = new ChessComponent[8][8];
    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++){
                switch (chessboard.get(i).charAt(j)){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    default:
                        chessComponents[i][j] = new EmptySlotComponent(i,j);
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        break;
                }
                chessComponents[i][j].name = chessboard.get(i).charAt(j);
            }
        }
        for(int i = 0;i < 8;i++)
            for(int j = 0;j < 8;j++){
                chessBoard[i][j] = chessComponents[i][j];
            }
        currentPlayer = chessboard.get(8).charAt(0) == 'w' ? ChessColor.WHITE:ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++){
                sb.append(chessComponents[i][j].name);
            }
            if(i != 7)
                sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        HashMap<Character,Integer> chesses = new HashMap<>();
        char[] chessName = {'K','Q','R','B','N','P'};
        chesses.put('R',2);
        chesses.put('N',2);
        chesses.put('B',2);
        chesses.put('Q',1);
        chesses.put('K',1);
        chesses.put('P',8);
        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++){
                char chess = chessComponents[i][j].name;
                if(player.equals(ChessColor.BLACK)){
                    if(chesses.containsKey(chess)){
                        chesses.replace(chess,chesses.get(chess) - 1);
                    }
                }
                else{
                    if(Character.isLowerCase(chess)){
                        chess = Character.toUpperCase(chess);
                        chesses.replace(chess,chesses.get(chess) - 1);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean isBlack = player.equals(ChessColor.BLACK) ? true:false;
        for(int i = 0;i < 6;i++){
            if(chesses.get(chessName[i]) != 0){
                char name = chessName[i];
                if(!isBlack)
                    name = Character.toLowerCase(name);
                sb.append(name + " " + chesses.get(chessName[i]) + "\n");
            }
        }
        return sb.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> chessboardPoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        chessboardPoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                return o1.getX() == o2.getX() ? new Integer(o1.getY()).compareTo(new Integer(o2.getY())):new Integer(o1.getX()).compareTo(new Integer(o2.getX()));
            }
        });
        return chessboardPoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean canMove = false;
        if(getCanMovePoints(new ChessboardPoint(sourceX,sourceY)).contains(new ChessboardPoint(targetX,targetY)))
            canMove = true;
        if(canMove){
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setX(targetX);
            chessComponents[targetX][targetY].setY(targetY);
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX,sourceY);
            return true;
        }
        return false;
    }
}
