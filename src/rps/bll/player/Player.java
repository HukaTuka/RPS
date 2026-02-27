package rps.bll.player;

//Project imports
import rps.bll.game.IGameState;
import rps.bll.game.Move;
import rps.bll.game.Result;

//Java imports
import java.util.ArrayList;
import java.util.Random;

/**
 * Example implementation of a player.
 *
 * @author smsj
 */
public class Player implements IPlayer {

    private String name;
    private PlayerType type;
    private int scissors = 0;
    private int paper = 0;
    private int rock = 0;
    private double[][] draw;
    private double[][] won;
    private double[][] loss;
    private static final Random RANDOM = new Random();

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
     *
     * @param state Contains the current game state including historic moves/results
     * @return Next move
     */
    @Override
    public Move doMove(IGameState state) {

        //Historic data to analyze and decide next move...
        ArrayList<Result> results = (ArrayList<Result>) state.getHistoricResults();

        for (Result r : results) {
            if (r.getWinnerPlayer().getPlayerType() == PlayerType.Human)
                if (r.getWinnerMove() == Move.Scissor) {
                    scissors++;
                } else if (r.getWinnerMove() == Move.Paper) {
                    paper++;
                } else if (r.getWinnerMove() == Move.Rock) {
                    rock++;
                }
        }

        if (scissors <= 1) {
            scissors--;
            return Move.Rock;
        } else if (paper <= 1) {
            paper--;
            return Move.Scissor;
        } else if (rock <= 1) {
            rock--;
            return Move.Paper;
        }
        return Move.values()[RANDOM.nextInt(Move.values().length)];
    }
}

