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
    private List<Currency> currencyExchangeRates = new ArrayList<Currency>();
    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeCurrencies();

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


        Button manyToOne = new Button("Convert Three Currencies to One");
        homePage.add(manyToOne, 3, 2);



        showCurrencyRates(homePage);

        Scene scene = new Scene(homePage, 1100, 360);

        oneToOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                oneToOneConverter(primaryStage,scene);
            }
        });
        manyToOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                manyToOneConverter(primaryStage,scene);
            }
        });
        primaryStage.setScene(scene);
//        scene.getStylesheets().add(getClass().getResource("/App.css").toExternalForm());
        primaryStage.show();
    }

    private void oneToOneConverter(Stage primaryStage,Scene home) {
        GridPane oneToOneGrid = new GridPane();

//        oneToOneGrid.setGridLinesVisible(true);
        oneToOneGrid.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        oneToOneGrid.setPadding(new Insets(10, 20, 20, 20));
        oneToOneGrid.setVgap(15);
        oneToOneGrid.setHgap(20);

        Text title = new Text("One to one converter");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        oneToOneGrid.add(title, 0, 0, 2, 1);

        Label amount = new Label("Amount");
        oneToOneGrid.add(amount, 0, 1);

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
        response.setLayoutX(50);
        response.setLayoutY(200);

        Button backButton = new Button("Back");
        oneToOneGrid.add(backButton,2,3);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(home);
            }
        });


        Group oneToOneGroup = new Group(oneToOneGrid, response);
        Scene oneToOneScene = new Scene(oneToOneGroup, 1100, 360, Color.BEIGE);


        Button convertBtn = new Button("Convert");
        oneToOneGrid.add(convertBtn, 1, 3);
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
                    double exchangeValue = 0;

                    String selectedFrom = (String)fromCurrencySymbols.getValue();
                    String selectedTo = (String)toCurrencySymbols.getValue();
                    
                    // USD CONVERSIONS
                    if (selectedFrom.equals("USD ($)") && selectedTo.equals("USD ($)")) {
                        exchangeValue = currencyExchangeRates.get(0).getExchangeValue();
                    }
                    if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("USD ($)")) {
                        exchangeValue = currencyExchangeRates.get(1).getExchangeValue();
                    }
                    if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("USD ($)")) {
                        exchangeValue = currencyExchangeRates.get(2).getExchangeValue();
                    }
                    if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("USD ($)")) {
                        exchangeValue = currencyExchangeRates.get(3).getExchangeValue();
                    }
                    if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("USD ($)")) {
                        exchangeValue = currencyExchangeRates.get(4).getExchangeValue();
                    }
                    
                    // GBP CONVERSIONS
                    if (selectedFrom.equals("USD ($)") && selectedTo.equals("GBP (\u00a3)")) {
                        exchangeValue = currencyExchangeRates.get(5).getExchangeValue();
                    }
                    if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("GBP (\u00a3)")) {
                        exchangeValue = currencyExchangeRates.get(6).getExchangeValue();
                    }
                    if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("GBP (\u00a3)")) {
                        exchangeValue = currencyExchangeRates.get(7).getExchangeValue();
                    }
                    if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("GBP (\u00a3)")) {
                        exchangeValue = currencyExchangeRates.get(8).getExchangeValue();
                    }
                    if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("GBP (\u00a3)")) {
                        exchangeValue = currencyExchangeRates.get(9).getExchangeValue();
                    }
                
                    // AUS CONVERSIONS
                    if (selectedFrom.equals("USD ($)") && selectedTo.equals("AUD (A$)")) {
                        exchangeValue = currencyExchangeRates.get(10).getExchangeValue();
                    }
                    if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("AUD (A$)")) {
                        exchangeValue = currencyExchangeRates.get(11).getExchangeValue();
                    }
                    if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("AUD (A$)")) {
                        exchangeValue = currencyExchangeRates.get(12).getExchangeValue();
                    }
                    if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("AUD (A$)")) {
                        exchangeValue = currencyExchangeRates.get(13).getExchangeValue();
                    }
                    if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("AUD (A$)")) {
                        exchangeValue = currencyExchangeRates.get(14).getExchangeValue();
                    }
                    
                    // EUR CONVERSIONS
                    if (selectedFrom.equals("USD ($)") && selectedTo.equals("EUR (\u20ac)")) {
                        exchangeValue = currencyExchangeRates.get(15).getExchangeValue();
                    }
                    if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("EUR (\u20ac)")) {
                        exchangeValue = currencyExchangeRates.get(16).getExchangeValue();
                    }
                    if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("EUR (\u20ac)")) {
                        exchangeValue = currencyExchangeRates.get(17).getExchangeValue();
                    }
                    if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("EUR (\u20ac)")) {
                        exchangeValue = currencyExchangeRates.get(18).getExchangeValue();
                    }
                    if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("EUR (\u20ac)")) {
                        exchangeValue = currencyExchangeRates.get(19).getExchangeValue();
                    }
                    
                    // JPY CONVERSIONS
                    if (selectedFrom.equals("USD ($)") && selectedTo.equals("JPY (\u00a5)")) {
                        exchangeValue = currencyExchangeRates.get(20).getExchangeValue();
                    }
                    if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("JPY (\u00a5)")) {
                        exchangeValue = currencyExchangeRates.get(21).getExchangeValue();
                    }
                    if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("JPY (\u00a5)")) {
                        exchangeValue = currencyExchangeRates.get(22).getExchangeValue();
                    }
                    if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("JPY (\u00a5)")) {
                        exchangeValue = currencyExchangeRates.get(23).getExchangeValue();
                    }
                    if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("JPY (\u00a5)")) {
                        exchangeValue = currencyExchangeRates.get(24).getExchangeValue();
                    }
                    
                    convertedAmount = amount * exchangeValue;
                    //=================================
                    //primaryStage.setScene(oneToOneScene);
                    primaryStage.setScene(oneToOneScene);
                    response.setText("");
                    Text convertedCurrency = new Text();
                    convertedCurrency.setText(" ");
                    convertedCurrency.setText(Double.toString(convertedAmount));
                    Rectangle cover = new Rectangle(70,20,Color.BEIGE);
                    oneToOneGrid.add(cover, 2, 4);
                    oneToOneGrid.add(convertedCurrency, 2, 4);
                }
            }
        });

        showCurrencyRates(oneToOneGrid);
        primaryStage.setScene(oneToOneScene);
    }

    private void manyToOneConverter(Stage primaryStage,Scene home) {
        GridPane manyToOneGrid = new GridPane();
        Scene manyToOneScene = new Scene(manyToOneGrid, 1100, 360);
        manyToOneGrid.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        manyToOneGrid.setPadding(new Insets(10, 20, 20, 20));
        manyToOneGrid.setVgap(15);
        manyToOneGrid.setHgap(20);

        Text title = new Text("Three to one converter");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        manyToOneGrid.add(title, 0, 0, 2, 1);

        //this list should be global so can be access by both functions.
        ObservableList<String> currencies = FXCollections.observableArrayList(
                "USD ($)",
                "AUD (A$)",
                "GBP (\u00a3)",
                "EUR (\u20ac)",
                "JPY (\u00a5)"
        );


        Text amount1 = new Text("Amount 1");
        amount1.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
        manyToOneGrid.add(amount1, 0, 1);
        TextField firstCurrencyAmount = new TextField();
        manyToOneGrid.add(firstCurrencyAmount, 1, 1);
        final ComboBox fromCurrencySymbols1 = new ComboBox();
        fromCurrencySymbols1.setItems(currencies);
        fromCurrencySymbols1.getSelectionModel().selectFirst();
        manyToOneGrid.add(fromCurrencySymbols1, 2,1);
        Label to1 = new Label("to");
        manyToOneGrid.add(to1, 3, 1);
        final ComboBox toCurrencySymbols1 = new ComboBox();
        toCurrencySymbols1.setItems(currencies);
        toCurrencySymbols1.getSelectionModel().select(1);
        manyToOneGrid.add(toCurrencySymbols1, 4, 1);

        //amount 2
        Text amount2 = new Text("Amount 2");
        amount2.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
        manyToOneGrid.add(amount2, 0, 2);
        TextField secondCurrencyAmount = new TextField();
        manyToOneGrid.add(secondCurrencyAmount, 1, 2);
        final ComboBox fromCurrencySymbols2 = new ComboBox();
        fromCurrencySymbols2.setItems(currencies);
        fromCurrencySymbols2.getSelectionModel().selectFirst();
        manyToOneGrid.add(fromCurrencySymbols2, 2,2);
        Label to2 = new Label("to");
        manyToOneGrid.add(to2, 3, 2);
        final ComboBox toCurrencySymbols2 = new ComboBox();
        toCurrencySymbols2.setItems(currencies);
        toCurrencySymbols2.getSelectionModel().select(1);
        manyToOneGrid.add(toCurrencySymbols2, 4, 2);


        Text amount3 = new Text("Amount 3");
        amount3.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
        manyToOneGrid.add(amount3, 0, 3);
        TextField thirdCurrencyAmount = new TextField();
        manyToOneGrid.add(thirdCurrencyAmount, 1, 3);
        final ComboBox fromCurrencySymbols3 = new ComboBox();
        fromCurrencySymbols3.setItems(currencies);
        fromCurrencySymbols3.getSelectionModel().selectFirst();
        manyToOneGrid.add(fromCurrencySymbols3, 2,3);
        Label to3 = new Label("to");
        manyToOneGrid.add(to3, 3, 3);
        final ComboBox toCurrencySymbols3 = new ComboBox();
        toCurrencySymbols3.setItems(currencies);
        toCurrencySymbols3.getSelectionModel().select(1);
        manyToOneGrid.add(toCurrencySymbols3, 4, 3);
        showCurrencyRates(manyToOneGrid);
        Button backButton = new Button("Back");
        manyToOneGrid.add(backButton,2,4);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(home);
            }
        });


        //Group manyToOne = new Group(manyToOneGrid);

        Button convertBtn = new Button("Convert");
        manyToOneGrid.add(convertBtn, 4, 0);
        convertBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (firstCurrencyAmount.getText().trim().isEmpty() || secondCurrencyAmount.getText().trim().isEmpty()||thirdCurrencyAmount.getText().trim().isEmpty()) {
//                    response.setFill(Color.RED);
//                    response.setText("Amount field cannot be empty");
                } else {

                    //=================================
                    // Currency Coversion Calculations Here
                    // firstCurrencyAmount --> the amount entered

                    double amount = Double.parseDouble(firstCurrencyAmount.getText());

                    double convertedAmount = 0;
                    double exchangeValue = 0;

                    String selectedFrom = (String)fromCurrencySymbols1.getValue();
                    String selectedTo = (String)toCurrencySymbols1.getValue();

                    // USD CONVERSIONS
                    if (selectedFrom.equals("USD ($)") && selectedTo.equals("USD ($)")) {
                        exchangeValue = currencyExchangeRates.get(0).getExchangeValue();
                    }
                    if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("USD ($)")) {
                        exchangeValue = currencyExchangeRates.get(1).getExchangeValue();
                    }
                    if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("USD ($)")) {
                        exchangeValue = currencyExchangeRates.get(2).getExchangeValue();
                    }
                    if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("USD ($)")) {
                        exchangeValue = currencyExchangeRates.get(3).getExchangeValue();
                    }
                    if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("USD ($)")) {
                        exchangeValue = currencyExchangeRates.get(4).getExchangeValue();
                    }

                    // GBP CONVERSIONS
                    if (selectedFrom.equals("USD ($)") && selectedTo.equals("GBP (\u00a3)")) {
                        exchangeValue = currencyExchangeRates.get(5).getExchangeValue();
                    }
                    if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("GBP (\u00a3)")) {
                        exchangeValue = currencyExchangeRates.get(6).getExchangeValue();
                    }
                    if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("GBP (\u00a3)")) {
                        exchangeValue = currencyExchangeRates.get(7).getExchangeValue();
                    }
                    if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("GBP (\u00a3)")) {
                        exchangeValue = currencyExchangeRates.get(8).getExchangeValue();
                    }
                    if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("GBP (\u00a3)")) {
                        exchangeValue = currencyExchangeRates.get(9).getExchangeValue();
                    }

                    // AUS CONVERSIONS
                    if (selectedFrom.equals("USD ($)") && selectedTo.equals("AUD (A$)")) {
                        exchangeValue = currencyExchangeRates.get(10).getExchangeValue();
                    }
                    if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("AUD (A$)")) {
                        exchangeValue = currencyExchangeRates.get(11).getExchangeValue();
                    }
                    if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("AUD (A$)")) {
                        exchangeValue = currencyExchangeRates.get(12).getExchangeValue();
                    }
                    if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("AUD (A$)")) {
                        exchangeValue = currencyExchangeRates.get(13).getExchangeValue();
                    }
                    if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("AUD (A$)")) {
                        exchangeValue = currencyExchangeRates.get(14).getExchangeValue();
                    }

                    // EUR CONVERSIONS
                    if (selectedFrom.equals("USD ($)") && selectedTo.equals("EUR (\u20ac)")) {
                        exchangeValue = currencyExchangeRates.get(15).getExchangeValue();
                    }
                    if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("EUR (\u20ac)")) {
                        exchangeValue = currencyExchangeRates.get(16).getExchangeValue();
                    }
                    if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("EUR (\u20ac)")) {
                        exchangeValue = currencyExchangeRates.get(17).getExchangeValue();
                    }
                    if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("EUR (\u20ac)")) {
                        exchangeValue = currencyExchangeRates.get(18).getExchangeValue();
                    }
                    if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("EUR (\u20ac)")) {
                        exchangeValue = currencyExchangeRates.get(19).getExchangeValue();
                    }

                    // JPY CONVERSIONS
                    if (selectedFrom.equals("USD ($)") && selectedTo.equals("JPY (\u00a5)")) {
                        exchangeValue = currencyExchangeRates.get(20).getExchangeValue();
                    }
                    if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("JPY (\u00a5)")) {
                        exchangeValue = currencyExchangeRates.get(21).getExchangeValue();
                    }
                    if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("JPY (\u00a5)")) {
                        exchangeValue = currencyExchangeRates.get(22).getExchangeValue();
                    }
                    if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("JPY (\u00a5)")) {
                        exchangeValue = currencyExchangeRates.get(23).getExchangeValue();
                    }
                    if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("JPY (\u00a5)")) {
                        exchangeValue = currencyExchangeRates.get(24).getExchangeValue();
                    }

                    convertedAmount = amount * exchangeValue;
                    //=================================
                    //primaryStage.setScene(oneToOneScene);
                    primaryStage.setScene(manyToOneScene);
                    //response.setText("");
                    Text convertedCurrency = new Text();
                    convertedCurrency.setText(" ");
                    convertedCurrency.setText(Double.toString(convertedAmount));
                    Rectangle cover = new Rectangle(70,20,Color.BEIGE);
                    manyToOneGrid.add(cover, 2, 4);
                    manyToOneGrid.add(convertedCurrency, 2, 4);
                }
            }
        });
        primaryStage.setScene(manyToOneScene);
    }

    private void showCurrencyRates(GridPane grid) {
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
                grid.add(new Text(Double.toString(currencyExchangeRates.get(idx).getExchangeValue())), i, j);
                idx++;
            }
        }

//        grid.setGridLinesVisible(true);


    }

    private void initializeCurrencies() {
        Currency USDUSD =  new Currency("USD", "USD", 1);
        currencyExchangeRates.add(USDUSD);
        Currency USDGBP =  new Currency("USD", "GBP", 0.83102);
        currencyExchangeRates.add(USDGBP);
        Currency USDAUD =  new Currency("USD", "AUD", 1.49417);
        currencyExchangeRates.add(USDAUD);
        Currency USDEUR =  new Currency("USD", "EUR", 0.91431);
        currencyExchangeRates.add(USDEUR);
        Currency USDJPY =  new Currency("USD", "JPY", 106.306);
        currencyExchangeRates.add(USDJPY);
        Currency GBPUSD =  new Currency("GBP", "USD", 0.91431);
        currencyExchangeRates.add(GBPUSD);
        Currency GBPGBP =  new Currency("GBP", "GBP", 1);
        currencyExchangeRates.add(GBPGBP);
        Currency GBPAUD =  new Currency("GBP", "AUD", 1.79802);
        currencyExchangeRates.add(GBPAUD);
        Currency GBPEUR =  new Currency("GBP", "EUR", 1.1009);
        currencyExchangeRates.add(GBPEUR);
        Currency GBPJPY =  new Currency("GBP", "JPY", 127.924);
        currencyExchangeRates.add(GBPJPY);
        Currency AUDUSD =  new Currency("AUD", "USD", 0.66932);
        currencyExchangeRates.add(AUDUSD);
        Currency AUDGBP =  new Currency("AUD", "GBP", 0.55621);
        currencyExchangeRates.add(AUDGBP);
        Currency AUDAUD =  new Currency("AUD", "AUD", 1);
        currencyExchangeRates.add(AUDAUD);
        Currency AUDEUR =  new Currency("AUD", "EUR", 0.61188);
        currencyExchangeRates.add(AUDEUR);
        Currency AUDJPY =  new Currency("AUD", "JPY", 71.1491);
        currencyExchangeRates.add(AUDJPY);
        Currency EURUSD =  new Currency("EUR", "USD", 1.09372);
        currencyExchangeRates.add(EURUSD);
        Currency EURGBP =  new Currency("EUR", "GBP", 0.90889);
        currencyExchangeRates.add(EURGBP);
        Currency EURAUD =  new Currency("EUR", "AUD", 1.63421);
        currencyExchangeRates.add(EURAUD);
        Currency EUREUR =  new Currency("EUR", "EUR", 1);
        currencyExchangeRates.add(EUREUR);
        Currency EURJPY =  new Currency("EUR", "JPY", 116.270);
        currencyExchangeRates.add(EURJPY);
        Currency JPYUSD =  new Currency("JPY", "USD", 0.00941);
        currencyExchangeRates.add(JPYUSD);
        Currency JPYGBP =  new Currency("JPY", "GBP", 0.00782);
        currencyExchangeRates.add(JPYGBP);
        Currency JPYAUD =  new Currency("JPY", "AUD", 0.01405);
        currencyExchangeRates.add(JPYAUD);
        Currency JPYEUR =  new Currency("JPY", "EUR", 0.00860);
        currencyExchangeRates.add(JPYEUR);
        Currency JPYJPY =  new Currency("JPY", "JPY", 1);
        currencyExchangeRates.add(JPYJPY);
    }

    class Currency {
        private String from;
        private String to;
        private double exchangeValue;
        public Currency(String f, String t, double exchangeVal) {
            this.from = f;
            this.to = t;
            this.exchangeValue = exchangeVal;
        }

        public String getFrom() {
            return this.from;
        }

        public String getTo() {
            return this.to;
        }

        public double getExchangeValue() {
            return this.exchangeValue;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
