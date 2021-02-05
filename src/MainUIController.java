import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {

    @FXML
    private Text clockText;
    @FXML
    private Button plus10Min, plus1Min, minus10Min, minus1Min, startButton, stopButton;

    @Override
    public void initialize(URL location, ResourceBundle resource) {}

}
