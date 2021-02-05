import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            // シーン作成
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainUI.fxml"));
            loader.setController(new MainUIController());
            Scene scene = new Scene(loader.load());

            // ステージ初期化
            stage.setTitle("ラーメンタイマー");
            stage.setScene(scene);

            // UI表示
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
