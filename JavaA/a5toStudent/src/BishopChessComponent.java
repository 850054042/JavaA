import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = super.getX();
        int y = super.getY();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for(int i = 0;i < 8;i++){
            if(x + i < 8 && y + i < 8){
                chessboardPoints.add(new ChessboardPoint(x + i,y + i));
            }
            else{
                break;
            }
        }
        for(int i = 0;i < 8;i++){
            if(x + i < 8 && y - i >= 0){
                chessboardPoints.add(new ChessboardPoint(x + i,y - i));
            }
            else{
                break;
            }
        }
        for(int i = 0;i < 8;i++){
            if(x - i >= 0 && y + i < 8){
                chessboardPoints.add(new ChessboardPoint(x - i,y + i));
            }
            else{
                break;
            }
        }
        for(int i = 0;i < 8;i++){
            if(x - i >= 0 && y - i >= 0){
                chessboardPoints.add(new ChessboardPoint(x - i,y - i));
            }
            else{
                break;
            }
        }
        return chessboardPoints;
    }
    public BishopChessComponent(int x,int y){
        super(x,y);
    }
    public BishopChessComponent(){}
    public boolean isValid(int a){
        return a <= 7 & a >= 0;
    }
}
