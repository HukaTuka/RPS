package rps.bll.player;

//Project imports
import rps.bll.game.IGameState;
import rps.bll.game.Move;
import rps.bll.game.Result;

//Java imports
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        int rock = 0;
        int paper = 0;
        int scissors = 0;

        List<Result> results = (List<Result>) state.getHistoricResults();

        for (Result r : results) {
            if (r.getWinnerPlayer() != null &&
                    r.getWinnerPlayer().getPlayerType() == PlayerType.Human) {

                if (r.getWinnerMove() == Move.Rock) {
                    rock++;
                } else if (r.getWinnerMove() == Move.Paper) {
                    paper++;
                } else if (r.getWinnerMove() == Move.Scissor) {
                    scissors++;
                }
            }
        }

        if (rock == 0 && paper == 0 && scissors == 0) {
            return Move.values()[RANDOM.nextInt(Move.values().length)];
        }

        if (rock >= paper && rock >= scissors) {
            return Move.Paper;
        } else if (paper >= rock && paper >= scissors) {
            return Move.Scissor;
        } else {
            return Move.Rock;
        }
    }
}

