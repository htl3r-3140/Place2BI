package place2BI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Place2BI extends Application {
    final int width = 1000;
    final int height = 750;

    @Override
    public void start(Stage stage) {
        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/maps/austria/Dblrw.png"))));
        imageView.setFitWidth(width);
        imageView.setPreserveRatio(true);

        StackPane stackPane = new StackPane(imageView);
        stackPane.setAlignment(Pos.BOTTOM_CENTER);

        Scene scene = new Scene(stackPane, width, height);
        stage.setScene(scene);
        stage.setTitle("Place2BI");
        stage.show();
    }
}