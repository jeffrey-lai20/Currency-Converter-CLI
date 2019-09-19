import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Converter.initializeCurrencies();

        primaryStage.setTitle("Currency App");

        GridPane homePage = new GridPane();
        homePage.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        homePage.setPadding(new Insets(10, 20, 20, 20));
        homePage.setVgap(15);
        homePage.setHgap(20);

        Text homeTitle = new Text("Agile_Team43");
        homeTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        homePage.add(homeTitle, 0, 0, 2, 1);

        Button oneToOne = new Button("One to one conversion");
        homePage.add(oneToOne, 1, 2);

        Button manyToOne = new Button("Combination conversion(up to 3)");
        homePage.add(manyToOne, 3, 2);

        Options.showCurrencyRates(homePage);

        Scene scene = new Scene(homePage, 1110, 360);

        oneToOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Options.oneToOneConverter(primaryStage,scene);
            }
        });
        manyToOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Options.manyToOneConverter(primaryStage,scene);
            }
        });
        primaryStage.setScene(scene);
//        scene.getStylesheets().add(getClass().getResource("/App.css").toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
