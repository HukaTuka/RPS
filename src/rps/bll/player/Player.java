package rps.bll.player;

//Project imports
import rps.bll.game.IGameState;
import rps.bll.game.Move;
import rps.bll.game.Result;

//Java imports
import java.util.ArrayList;

/**
 * Example implementation of a player.
 *
 * @author smsj
 */
public class Player implements IPlayer {

    private String name;
    private PlayerType type;
    private double[][] draw;
    private double[][] won;
    private double[][] loss;
    /**
     * @param name
     */
    public Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
    }


    @Override
    public String getPlayerName() {
        return name;
    }


    @Override
    public PlayerType getPlayerType() {
        return type;
    }


    /**
     * Decides the next move for the bot...
     * @param state Contains the current game state including historic moves/results
     * @return Next move
     */
    @Override
    public Move doMove(IGameState state) {

        //Historic data to analyze and decide next move...
        ArrayList<Result> results = (ArrayList<Result>) state.getHistoricResults();

        for (Result r: results) {
            if (r.getWinnerPlayer().getPlayerType() == PlayerType.Human)
                System.out.println(r.getWinnerPlayer().getPlayerName() + ":" + r.getWinnerMove());
        }

        //whenever there is a draw, the chances of the player choosing anything becomes random
        draw = new double[][]{
                {0.33, 0.33, 0.33},
                {0.33, 0.33, 0.33},
                {0.33, 0.33, 0.33}};

        /*When the AI wins going down it,s Rock, Paper, Scissor. Across it's Rock, Paper, Scissor
        It shows the likelihood of the player choosing RPS*/
        won = new double[][] {
                {0.3, 0.6, 0.1},
                {0.1, 0.3, 0.6},
                {0.6, 0.1, 0.3}};

        /*When the AI losses with RPS this shows the chances that
        the player will choose something other than what they chose before*/
        loss = new double[][]{
                {0.2, 0.6, 0.2},
                {0.2, 0.2, 0.6},
                {0.6, 0.2, 0.2}};

        //Implement better AI here...
        return Move.Paper;
    }
}
