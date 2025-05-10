package place2BI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Place2BI extends Application {
    final double height = Screen.getPrimary().getBounds().getHeight() * 0.9, width = height * 0.8 * 16 / 9;

    @Override
    public void start(Stage stage) throws IOException {
        Place place = new Place("Project/resources/places/austria/K.txt");
        Circle circle = new Circle(place.placeX, place.placeY, 10, Color.web("#DD0000"));

        VBox vBoxLeft = new VBox(createText("2.6 S", Color.WHITE, false, 30));
        vBoxLeft.setAlignment(Pos.CENTER_LEFT);
        vBoxLeft.setPrefWidth(width * 0.15);

        VBox vBoxCenter = new VBox(createText(place.place, Color.web("#DD0000"), true, 35));
        vBoxCenter.setAlignment(Pos.CENTER);
        vBoxCenter.setPrefWidth(width * 0.6);

        VBox vBoxRight = new VBox(createText("DU: 70 PT", Color.web("#00DD00"), false, 30), createText("KI: 71 PT", Color.web("#0000DD"), false, 30));
        vBoxRight.setAlignment(Pos.CENTER_RIGHT);
        vBoxRight.setPrefWidth(width * 0.15);

        BorderPane borderPane = new BorderPane(vBoxCenter, null, vBoxRight, null, vBoxLeft);
        BorderPane.setAlignment(borderPane, Pos.CENTER);
        borderPane.setMaxSize(width, height * 0.2);
        borderPane.setPadding(new Insets(0, width * 0.05, 0, width * 0.05));
        borderPane.setStyle("-fx-background-color: black; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.5), 50, 0.5, 0, 0);");

        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/maps/austria/Dblrw.png"))));
        imageView.setFitHeight(height * 0.8);
        imageView.setPreserveRatio(true);

        StackPane stackPane = new StackPane(imageView, borderPane);
        StackPane.setAlignment(imageView, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(borderPane, Pos.TOP_CENTER);

        stage.setScene(new Scene(new StackPane(stackPane, new Pane(circle)), width, height));
        stage.setTitle("Place2BI");
        stage.setResizable(false);
        stage.show();
    }

    public Text createText(String text, Color color, boolean underline, int size) {
        Text createText = new Text(text);
        createText.setFill(color);
        createText.setUnderline(underline);
        createText.setFont(Font.loadFont(Objects.requireNonNull(getClass().getResourceAsStream("/fonts/Posterama-Bold.ttf")), size));
        return createText;
    }
}