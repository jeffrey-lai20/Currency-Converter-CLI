import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Options {
    public static void oneToOneConverter(Stage primaryStage, Scene home) {
        GridPane oneToOneGrid = new GridPane();
        //oneToOneGrid.setGridLinesVisible(true);
        oneToOneGrid.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        oneToOneGrid.setPadding(new Insets(10, 20, 20, 20));
        oneToOneGrid.setVgap(15);
        oneToOneGrid.setHgap(20);

        Text title = new Text("One to one converter");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        oneToOneGrid.add(title, 0, 0, 2, 1);

        Label amount = new Label("Amount");
        oneToOneGrid.add(amount, 0, 1);

        Text result = new Text();
        result.setText("Result: ");
        result.setFont(Font.font("Arial", FontWeight.MEDIUM, 24));
        oneToOneGrid.add(result,1,3);

        TextField firstCurrencyAmount = new TextField();
        oneToOneGrid.add(firstCurrencyAmount, 1, 1);

        ObservableList<String> currencies = FXCollections.observableArrayList(
                "USD ($)",
                "AUD (A$)",
                "GBP (\u00a3)",
                "EUR (\u20ac)",
                "JPY (\u00a5)"
        );
        final ComboBox fromCurrencySymbols = new ComboBox();
        fromCurrencySymbols.setItems(currencies);
        fromCurrencySymbols.getSelectionModel().selectFirst();
        oneToOneGrid.add(fromCurrencySymbols, 2,1);

        Label to = new Label("to");
        oneToOneGrid.add(to, 3, 1);

        final ComboBox toCurrencySymbols = new ComboBox();
        toCurrencySymbols.setItems(currencies);
        toCurrencySymbols.getSelectionModel().select(1);
        oneToOneGrid.add(toCurrencySymbols, 4, 1);

        Text response = new Text();
        response.setLayoutX(90);
        response.setLayoutY(230);

        Button backButton = new Button("Back");
        oneToOneGrid.add(backButton,2,4);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(home);
            }
        });

        Group oneToOneGroup = new Group(oneToOneGrid, response);
        Scene oneToOneScene = new Scene(oneToOneGroup, 1100, 360, Color.BEIGE);

        Button convertBtn = new Button("Convert");
        oneToOneGrid.add(convertBtn, 1, 4);
        convertBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (firstCurrencyAmount.getText().trim().isEmpty()) {
                    response.setFill(Color.RED);
                    response.setText("Amount field cannot be empty");
                } else {

                    //=================================
                    // Currency Coversion Calculations Here
                    // firstCurrencyAmount --> the amount entered

                    double amount = Double.parseDouble(firstCurrencyAmount.getText());

                    double convertedAmount = 0;
                    double exchangeValue = Converter.convert((String)fromCurrencySymbols.getValue(),(String)toCurrencySymbols.getValue());

                    String selectedFrom = (String)fromCurrencySymbols.getValue();
                    String selectedTo = (String)toCurrencySymbols.getValue();
                    convertedAmount = amount * exchangeValue;
                    //=================================
                    //primaryStage.setScene(oneToOneScene);
                    primaryStage.setScene(oneToOneScene);
                    response.setText("");
                    Text convertedCurrency = new Text();
                    convertedCurrency.setText(" ");
                    convertedCurrency.setText(Double.toString(convertedAmount));

                    Rectangle cover = new Rectangle(100,20,Color.BEIGE);
                    oneToOneGrid.add(cover, 2, 3);
                    oneToOneGrid.add(convertedCurrency, 2, 3);
                }
            }
        });
        showCurrencyRates(oneToOneGrid);
        primaryStage.setScene(oneToOneScene);
    }

    public static void manyToOneConverter(Stage primaryStage,Scene home) {
        GridPane manyToOneGrid = new GridPane();
        //Scene manyToOneScene = new Scene(manyToOneGrid, 1100, 360);
        manyToOneGrid.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        manyToOneGrid.setPadding(new Insets(10, 20, 20, 20));
        manyToOneGrid.setVgap(15);
        manyToOneGrid.setHgap(20);

        Text title = new Text("Many to one converter");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        manyToOneGrid.add(title, 0, 0, 2, 1);
        Text result = new Text();
        result.setText("Result: ");
        result.setFont(Font.font("Arial", FontWeight.MEDIUM, 24));
        manyToOneGrid.add(result,1,4);
        //this list should be global so can be access by both functions.
        ObservableList<String> currencies = FXCollections.observableArrayList(
                "USD ($)",
                "AUD (A$)",
                "GBP (\u00a3)",
                "EUR (\u20ac)",
                "JPY (\u00a5)"
        );

        //amount 1
        Text amount1 = new Text("Amount 1");
        amount1.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
        manyToOneGrid.add(amount1, 0, 1);
        TextField firstCurrencyAmount = new TextField();
        manyToOneGrid.add(firstCurrencyAmount, 1, 1);
        //from box
        final ComboBox fromCurrencySymbols1 = new ComboBox();
        fromCurrencySymbols1.setItems(currencies);
        fromCurrencySymbols1.getSelectionModel().selectFirst();
        manyToOneGrid.add(fromCurrencySymbols1, 2,1);

        //amount 2
        Text amount2 = new Text("Amount 2");
        amount2.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
        manyToOneGrid.add(amount2, 0, 2);
        TextField secondCurrencyAmount = new TextField();
        manyToOneGrid.add(secondCurrencyAmount, 1, 2);
        //from box
        final ComboBox fromCurrencySymbols2 = new ComboBox();
        fromCurrencySymbols2.setItems(currencies);
        fromCurrencySymbols2.getSelectionModel().selectFirst();
        manyToOneGrid.add(fromCurrencySymbols2, 2,2);
        Label to2 = new Label("to");
        manyToOneGrid.add(to2, 3, 2);
        //to box
        final ComboBox toCurrencySymbols2 = new ComboBox();
        toCurrencySymbols2.setItems(currencies);
        toCurrencySymbols2.getSelectionModel().select(1);
        manyToOneGrid.add(toCurrencySymbols2, 4, 2);
        //amount 3
        Text amount3 = new Text("Amount 3");
        amount3.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
        manyToOneGrid.add(amount3, 0, 3);
        TextField thirdCurrencyAmount = new TextField();
        manyToOneGrid.add(thirdCurrencyAmount, 1, 3);
        //from box
        final ComboBox fromCurrencySymbols3 = new ComboBox();
        fromCurrencySymbols3.setItems(currencies);
        fromCurrencySymbols3.getSelectionModel().selectFirst();
        manyToOneGrid.add(fromCurrencySymbols3, 2,3);

        showCurrencyRates(manyToOneGrid);

        Button backButton = new Button("Back");
        manyToOneGrid.add(backButton,2,5);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(home);
            }
        });
        Text response = new Text();
        response.setLayoutX(100);
        response.setLayoutY(280);

        Group manyToOneGroup = new Group(manyToOneGrid, response);
        Scene manyToOneScene = new Scene(manyToOneGroup, 1100, 360, Color.BEIGE);
        //Group manyToOne = new Group(manyToOneGrid);

        Button convertBtn = new Button("Convert");
        manyToOneGrid.add(convertBtn, 1, 5);
        convertBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (firstCurrencyAmount.getText().trim().isEmpty() && secondCurrencyAmount.getText().trim().isEmpty()&&thirdCurrencyAmount.getText().trim().isEmpty()) {
                    response.setFill(Color.RED);
                    response.setText("At least one field must be filled in");
                } else {
                    //=================================
                    // Currency Coversion Calculations Here
                    // firstCurrencyAmount --> the amount entered

                    double amount = Double.parseDouble(firstCurrencyAmount.getText());
                    double exchangeValue =  Converter.convert((String)fromCurrencySymbols1.getValue(),(String)toCurrencySymbols2.getValue());
                    double convertedAmount = amount*exchangeValue;

                    double amount2 = Double.parseDouble(secondCurrencyAmount.getText());
                    double exchangeValue2 =  Converter.convert((String)fromCurrencySymbols2.getValue(),(String)toCurrencySymbols2.getValue());
                    double convertedAmount2= amount2 * exchangeValue2;

                    double amount3 = Double.parseDouble(thirdCurrencyAmount.getText());
                    double exchangeValue3  =  Converter.convert((String)fromCurrencySymbols3.getValue(),(String)toCurrencySymbols2.getValue());
                    double convertedAmount3= amount3 * exchangeValue3;

                    double totalConvertedAmount = convertedAmount+convertedAmount2+convertedAmount3;
                    //=================================
                    //primaryStage.setScene(oneToOneScene);
                    primaryStage.setScene(manyToOneScene);
                    //response.setText("");
                    Text convertedCurrency = new Text();
                    convertedCurrency.setText(" ");
                    convertedCurrency.setText(Double.toString(totalConvertedAmount));
                    Rectangle cover = new Rectangle(150,20,Color.BEIGE);
                    manyToOneGrid.add(cover, 2, 4);
                    manyToOneGrid.add(convertedCurrency, 2, 4);
                }
            }
        });
        primaryStage.setScene(manyToOneScene);
    }

    public static void showCurrencyRates(GridPane grid) {
        int gridStartCol = 8;
        int gridStartRow = 2;
        Text exchangeTableTitle = new Text("Currency Exchange Rates");
        exchangeTableTitle.setFont(Font.font("Arial", FontWeight.BOLD, 21));
        grid.add(exchangeTableTitle, 8, 0, 6, 1);

        Text usd = new Text("USD ($)");
        usd.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        grid.add(usd, 8, 1);
        Text gbp = new Text("GBP (\u00a3)");
        gbp.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        grid.add(gbp, 9, 1);
        Text aud = new Text("AUD (A$)");
        aud.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        grid.add(aud, 10, 1);
        Text eur = new Text("EUR (\u20ac)");
        eur.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        grid.add(eur, 11, 1);
        Text jpy = new Text("JPY (\u00a5)");
        jpy.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        grid.add(jpy, 12, 1);

        Text oneUsd = new Text("1 USD($)");
        oneUsd.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        grid.add(oneUsd, 7, 2);
        Text oneGbp = new Text("1 GBP(\u00a3)");
        oneGbp.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        grid.add(oneGbp, 7, 3);
        Text oneAud = new Text("1 AUD(A$)");
        oneAud.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        grid.add(oneAud, 7, 4);
        Text oneEur = new Text("1 EUR(\u20ac)");
        oneEur.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        grid.add(oneEur, 7, 5);
        Text oneJpy = new Text("1 JPY(\u00a5)");
        oneJpy.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        grid.add(oneJpy, 7, 6);

        int idx = 0;
        for (int i = gridStartCol; i < gridStartCol+5; i++) {
            for (int j = gridStartRow; j < gridStartRow+5; j++) {
                grid.add(new Text(Double.toString(Converter.currencyExchangeRates.get(idx).getExchangeValue())), i, j);
                idx++;
            }
        }
///        grid.setGridLinesVisible(true);
    }
}
