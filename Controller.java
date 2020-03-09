import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

public class Controller {

    public Controller(){

    }


    @FXML
    private Pane boardPane;

    @FXML
    private Pane parentGrid;

    @FXML
    private Button simulatedAnnealingBtn;

    @FXML
    private Button geneticAlgorithmBtn;

    @FXML
    private Label attackingLbl;

    @FXML
    private Label timeLbl;

    @FXML
    private void initialize(){
        ChessBoard board = new ChessBoard(25);

        boardPane.getChildren().add(board);

        geneticAlgorithmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                timeLbl.setText(board.geneticAlgorithm() + "");
                board.placeQueens();

                attackingLbl.setText(board.getPuzzle().getAttackingValue()+"");
                
            }
        });

        simulatedAnnealingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                timeLbl.setText(board.simulatedAnnealing() + "");
                board.placeQueens();

                attackingLbl.setText(board.getPuzzle().getAttackingValue()+"");
            }
        });

    }

}
