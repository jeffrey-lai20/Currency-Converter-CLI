import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Currency App");

        GridPane homePage = new GridPane();
        homePage.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        homePage.setPadding(new Insets(10, 20, 20, 20));
        homePage.setVgap(15);
        homePage.setHgap(20);

        Text homeTitle = new Text("Agile_Team43");
        homeTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        homePage.add(homeTitle, 0, 0, 2, 1);

        Button oneToOne = new Button("Convert One Currency");
        homePage.add(oneToOne, 1, 2);
        oneToOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                oneToOneConverter(primaryStage);
            }
        });

        Button manyToOne = new Button("Convert Three Currencies to One");
        homePage.add(manyToOne, 3, 2);
        manyToOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                manyToOneConverter(primaryStage);
            }
        });

        Scene scene = new Scene(homePage, 1080, 720);
        primaryStage.setScene(scene);
//        scene.getStylesheets().add(getClass().getResource("/App,css").toExternalForm());
        primaryStage.show();
    }

    private void oneToOneConverter(Stage primaryStage) {
        GridPane oneToOneGrid = new GridPane();
        oneToOneGrid.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        oneToOneGrid.setPadding(new Insets(10, 20, 20, 20));
        oneToOneGrid.setVgap(15);
        oneToOneGrid.setHgap(20);

        Text title = new Text("Agile_Team43");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        oneToOneGrid.add(title, 0, 0, 2, 1);

        Label amount = new Label("Amount");
        oneToOneGrid.add(amount, 0, 1);

        TextField firstCurrencyAmount = new TextField();
        oneToOneGrid.add(firstCurrencyAmount, 1, 1);

        ObservableList<String> currencies = FXCollections.observableArrayList(
                "USD ($)",
                "AUD (A$)",
                "GBP (£)",
                "EUR (€)",
                "JPY (¥)"
        );
        final ComboBox fromCurrencySymbols = new ComboBox();
        fromCurrencySymbols.setItems(currencies);
        oneToOneGrid.add(fromCurrencySymbols, 2,1);

        Label to = new Label("to");
        oneToOneGrid.add(to, 3, 1);

        final ComboBox toCurrencySymbols = new ComboBox();
        toCurrencySymbols.setItems(currencies);
        oneToOneGrid.add(toCurrencySymbols, 4, 1);


        Button convertBtn = new Button("Convert");
        HBox btn = new HBox(0);
        btn.setAlignment(Pos.BOTTOM_RIGHT);
        btn.getChildren().add(convertBtn);
        oneToOneGrid.add(btn, 1, 4);

        Text response = new Text();
        oneToOneGrid.add(response, 2 ,7);

        convertBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (firstCurrencyAmount.getText().trim().isEmpty()) {
                    response.setFill(Color.RED);
                    response.setText("Amount field cannot be empty");
                } else {
                    // Currency Coversion Calculations Here

                    Text convertedCurrency = new Text();
                    convertedCurrency.setText(firstCurrencyAmount.getText());
                    oneToOneGrid.add(convertedCurrency, 2, 4);
                }

            }
        });


        Scene oneToOneScene = new Scene(oneToOneGrid, 1080, 720);
        primaryStage.setScene(oneToOneScene);
    }

    private void manyToOneConverter(Stage primaryStage) {
        GridPane manyToOneGrid = new GridPane();
        Scene manyToOneScene = new Scene(manyToOneGrid, 1080, 720);
        primaryStage.setScene(manyToOneScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
