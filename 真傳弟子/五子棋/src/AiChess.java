public class AiChess extends Chess {

    String name;
    ChessGame game;

    public AiChess(ChessGame game){
        this.name = "AI電腦";
        this.game = game;
    }

    @Override
    public int[] playchess() {
        int [] select= new int [2];

        select[0] = (int)(Math.random()*game.getChessBoard().length+1);
        select[1] = (int)(Math.random()*game.getChessBoard().length+1);

        return select;
    }

    @Override
    public String getName() {
        return name;
    }
}
