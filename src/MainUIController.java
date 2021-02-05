import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {

    @FXML
    private Text clockText;
    @FXML
    private Button plus10Min, plus1Min, plus10Sec, plus1Sec, startButton, stopButton;

    private Timer timer;
    private Timeline tl;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        // 初期化時に3分を設定
        timer = new Timer(3, 0);
        clockText.setText("03:00");

        // Timelineの初期化
        Duration d = new Duration(1000);
        KeyFrame kf = new KeyFrame(d, event -> {
            timer.tick(-1);
            clockText.setText( timer.toString() );
        });
        tl = new Timeline(kf);
        tl.setCycleCount(Timeline.INDEFINITE);

        // 10分増加ボタンが押されたときの動作
        plus10Min.setOnAction(event -> {
            timer.tick(10*60);
            clockText.setText( timer.toString() );
        });

        // 1分増加ボタンが押されたときの動作
        plus1Min.setOnAction(event -> {
            timer.tick(1*60);
            clockText.setText( timer.toString() );
        });

        // 10秒増加ボタンが押されたときの動作
        plus10Sec.setOnAction(event -> {
            timer.tick(10);
            clockText.setText( timer.toString() );
        });

        // 1秒増加ボタンが押されたときの動作
        plus1Sec.setOnAction(event -> {
            timer.tick(1);
            clockText.setText( timer.toString() );
        });

        // スタートボタンが押されたとき
        startButton.setOnAction(event -> {
            tl.play();
        });

        // ストップボタンが押されたとき
        stopButton.setOnAction(event -> {
            tl.stop();
        });
    }

}
