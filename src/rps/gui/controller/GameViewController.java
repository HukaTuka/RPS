package rps.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import rps.bll.game.Move;
import rps.bll.player.IPlayer;

import java.net.URL;
import java.util.ResourceBundle;

public class GameViewController implements Initializable {

    @FXML public Label playerChoiceLabel;
    @FXML public Label computerChoiceLabel;
    @FXML public Label resultLabel;
    @FXML public Label playerScoreLabel;
    @FXML public Label computerScoreLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IPlayer
                playRound;
        // Labels are ready to use here
    }

    @FXML
    public Move handleRock(ActionEvent actionEvent) {
        playerChoiceLabel.setText("Your Choice: Rock");
        return Move.Rock;
    }

    @FXML
    public Move handlePaper(ActionEvent actionEvent) {
        playerChoiceLabel.setText("Your Choice: Paper");
        return Move.Paper;
    }

    @FXML
    public Move handleScissors(ActionEvent actionEvent) {
        playerChoiceLabel.setText("Your Choice: Scissors ╰(*°▽°*)╯");
        return Move.Scissor;
    }
}