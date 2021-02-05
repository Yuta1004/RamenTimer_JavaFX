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

    private Timer timer;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        // 初期化時に3分を設定
        timer = new Timer(3, 0);
        clockText.setText("03:00");

        // 10分増加ボタンが押されたときの動作
        plus10Min.setOnAction(event -> {
            timer.tick(10*60);
            clockText.setText( timer.toString() );
        });
    }

}
