import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {

    @FXML
    private Text clockText;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        clockText.setText("12:04");
    }

}
