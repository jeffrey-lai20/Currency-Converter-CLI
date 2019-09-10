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
        GridPane grid = new GridPane();
        grid.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        grid.setPadding(new Insets(10, 20, 20, 20));
        grid.setVgap(15);
        grid.setHgap(20);

        Text title = new Text("Agile_Team43");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        grid.add(title, 0, 0, 2, 1);

        Label amount = new Label("Amount");
        grid.add(amount, 0, 1);

        TextField firstCurrencyAmount = new TextField();
        grid.add(firstCurrencyAmount, 1, 1);

        ObservableList<String> currencies = FXCollections.observableArrayList(
                "USD ($)",
                "AUD (A$)",
                "GBP (£)",
                "EUR (€)",
                "JPY (¥)"
        );
        final ComboBox currencySymbols = new ComboBox();
        currencySymbols.setItems(currencies);
        grid.add(currencySymbols, 2,1);

        Button convertBtn = new Button("Convert");
        HBox btn = new HBox(0);
        btn.setAlignment(Pos.BOTTOM_RIGHT);
        btn.getChildren().add(convertBtn);
        grid.add(btn, 1, 4);

        Text response = new Text();
        grid.add(response, 2 ,0);

        convertBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setFill(Color.BLACK);
                response.setText(firstCurrencyAmount.getText());

                // Currency Coversion Calculations Here

                Text convertedCurrency = new Text();
                convertedCurrency.setText(firstCurrencyAmount.getText());
                grid.add(convertedCurrency, 2, 4);
            }
        });

        Scene scene = new Scene(grid, 1080, 720, Color.CRIMSON);
        primaryStage.setScene(scene);
//        scene.getStylesheets().add(getClass().getResource("/App,css").toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
