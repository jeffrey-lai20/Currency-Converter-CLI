import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class AppTest extends ApplicationTest {

    private Button button;
    private Stage stage;

    @Override
    public void start(Stage stage) {
//        button = new Button("click me!");
//        button.setOnAction(actionEvent -> button.setText("clicked!"));
//        stage.setScene(new Scene(new StackPane(button), 100, 100));
////        stage.show();
//        this.stage = stage;
//        stage.show();

    }
//    @Test
//    public void myTest1() {
//        FxAssert.verifyThat(".button", LabeledMatchers.hasText("click me!"));
//    }
//
//    @Test
//    public void myTest2() {
//        clickOn(".button");
//        FxAssert.verifyThat(".button", LabeledMatchers.hasText("clicked!"));
//    }

    /**
     * Test for normal cases
     */
    @Test
    public void basicTest() {
        Converter conv = new Converter();
        conv.initializeCurrencies();

        assertEquals(100, conv.convert("USD ($)", "USD ($)", 100));
        assertEquals(100, conv.convert("AUD (A$)", "AUD (A$)", 100));
        assertEquals(100, conv.convert("EUR (\u20ac)", "EUR (\u20ac)", 100));
        assertEquals(100, conv.convert("JPY (\u00a5)", "JPY (\u00a5)", 100));
        assertEquals(100, conv.convert("GBP (\u00a3)", "GBP (\u00a3)", 100));

        assertEquals(83.102, conv.convert("USD ($)", "GBP (\u00a3)", 100));
        assertEquals(149.417, conv.convert("USD ($)", "AUD (A$)", 100));
        assertEquals(91.431, conv.convert("USD ($)", "EUR (\u20ac)", 100));
        assertEquals(10630.6, conv.convert("USD ($)", "JPY (\u00a5)", 100));

        assertEquals(66.932, conv.convert("AUD (A$)", "USD ($)", 100));
        assertEquals(120.336, conv.convert("GBP (\u00a3)", "USD ($)", 100));
        assertEquals(179.802, conv.convert("GBP (\u00a3)", "AUD (A$)", 100));
        assertEquals(110.09, conv.convert("GBP (\u00a3)", "EUR (\u20ac)", 100));
//        assertEquals(12792.4, conv.convert("GBP (\u00a3)", "JPY (\u00a5)", 100));

        assertEquals(66.932, conv.convert("AUD (A$)", "USD ($)", 100));
//        assertEquals(55.621, conv.convert("AUD (A$)", "GBP (\u00a3)", 100));
//        assertEquals(61.188, conv.convert("AUD (A$)", "EUR (\u20ac)", 100));
//        assertEquals(7114.91, conv.convert("AUD (A$)", "JPY (\u00a5)", 100));

        assertEquals(109.372, conv.convert("EUR (\u20ac)", "USD ($)", 100));
        assertEquals(90.889, conv.convert("EUR (\u20ac)", "GBP (\u00a3)", 100));
        assertEquals(163.421, conv.convert("EUR (\u20ac)", "AUD (A$)", 100));
        assertEquals(11627.0, conv.convert("EUR (\u20ac)", "JPY (\u00a5)", 100));

        assertEquals(0.941, conv.convert("JPY (\u00a5)", "USD ($)", 100));
        assertEquals(0.782, conv.convert("JPY (\u00a5)", "GBP (\u00a3)", 100));
        assertEquals(1.405, conv.convert("JPY (\u00a5)", "AUD (A$)", 100));
        assertEquals(0.860, conv.convert("JPY (\u00a5)", "EUR (\u20ac)", 100));
    }

    /**
     * Test for negative numbers
     */
    @Test
    public void negativeTest() {
        Converter conv = new Converter();
        conv.initializeCurrencies();
        assertThrows(IllegalArgumentException.class, () -> {
            conv.convert( "USD ($)", "USD ($)", -1);
        });
    }

    /**
     * Test for extremely large numbers
     */
    @Test
    public void largeTest() {
        Converter conv = new Converter();
        conv.initializeCurrencies();
        double max = Double.MAX_VALUE;
        assertEquals(max, conv.convert("USD ($)", "USD ($)", max));
        assertEquals(max, conv.convert("AUD (A$)", "AUD (A$)", max));
        assertEquals(max, conv.convert("EUR (\u20ac)", "EUR (\u20ac)", max));
        assertEquals(max, conv.convert("JPY (\u00a5)", "JPY (\u00a5)", max));
        assertEquals(max, conv.convert("GBP (\u00a3)", "GBP (\u00a3)", max));

        assertEquals(0.83102*max, conv.convert("USD ($)", "GBP (\u00a3)", max));
        assertEquals(1.49417*max, conv.convert("USD ($)", "AUD (A$)", max));
        assertEquals(0.91431*max, conv.convert("USD ($)", "EUR (\u20ac)", max));
        assertEquals(106.306*max, conv.convert("USD ($)", "JPY (\u00a5)", max));

        assertEquals(0.66932*max, conv.convert("AUD (A$)", "USD ($)", max));
        assertEquals(1.20336*max, conv.convert("GBP (\u00a3)", "USD ($)", max));
        assertEquals(1.79802*max, conv.convert("GBP (\u00a3)", "AUD (A$)", max));
        assertEquals(1.1009*max, conv.convert("GBP (\u00a3)", "EUR (\u20ac)", max));
//        assertEquals(127.924*max, conv.convert("GBP (\u00a3)", "JPY (\u00a5)", max));

        assertEquals(0.66932*max, conv.convert("AUD (A$)", "USD ($)", max));
//        assertEquals(0.55621*max, conv.convert("AUD (A$)", "GBP (\u00a3)", max));
//        assertEquals(0.61188*max, conv.convert("AUD (A$)", "EUR (\u20ac)", max));
//        assertEquals(71.1491*max, conv.convert("AUD (A$)", "JPY (\u00a5)", max));

        assertEquals(1.09372*max, conv.convert("EUR (\u20ac)", "USD ($)", max));
        assertEquals(0.90889*max, conv.convert("EUR (\u20ac)", "GBP (\u00a3)", max));
        assertEquals(1.63421*max, conv.convert("EUR (\u20ac)", "AUD (A$)", max));
        assertEquals(116.270*max, conv.convert("EUR (\u20ac)", "JPY (\u00a5)", max));

        assertEquals(0.00941*max, conv.convert("JPY (\u00a5)", "USD ($)", max));
        assertEquals(0.00782*max, conv.convert("JPY (\u00a5)", "GBP (\u00a3)", max));
        assertEquals(0.01405*max, conv.convert("JPY (\u00a5)", "AUD (A$)", max));
        assertEquals(0.00860*max, conv.convert("JPY (\u00a5)", "EUR (\u20ac)", max));
    }

    /**
     * Test for extremely small numbers
     */
    @Test
    public void smallTest() {
        Converter conv = new Converter();
        conv.initializeCurrencies();
        double min = Double.MIN_VALUE;
        assertEquals(min, conv.convert("USD ($)", "USD ($)", min));
        assertEquals(min, conv.convert("AUD (A$)", "AUD (A$)", min));
        assertEquals(min, conv.convert("EUR (\u20ac)", "EUR (\u20ac)", min));
        assertEquals(min, conv.convert("JPY (\u00a5)", "JPY (\u00a5)", min));
        assertEquals(min, conv.convert("GBP (\u00a3)", "GBP (\u00a3)", min));

        assertEquals(0.83102*min, conv.convert("USD ($)", "GBP (\u00a3)", min));
        assertEquals(1.49417*min, conv.convert("USD ($)", "AUD (A$)", min));
        assertEquals(0.91431*min, conv.convert("USD ($)", "EUR (\u20ac)", min));
        assertEquals(106.306*min, conv.convert("USD ($)", "JPY (\u00a5)", min));

        assertEquals(0.66932*min, conv.convert("AUD (A$)", "USD ($)", min));
        assertEquals(0.91431*min, conv.convert("GBP (\u00a3)", "USD ($)", min));
        assertEquals(1.79802*min, conv.convert("GBP (\u00a3)", "AUD (A$)", min));
        assertEquals(1.1009*min, conv.convert("GBP (\u00a3)", "EUR (\u20ac)", min));
//        assertEquals(127.924*min, conv.convert("GBP (\u00a3)", "JPY (\u00a5)", max));

        assertEquals(0.66932*min, conv.convert("AUD (A$)", "USD ($)", min));
//        assertEquals(0.55621*min, conv.convert("AUD (A$)", "GBP (\u00a3)", min));
//        assertEquals(0.61188*min, conv.convert("AUD (A$)", "EUR (\u20ac)", min));
//        assertEquals(71.1491*min, conv.convert("AUD (A$)", "JPY (\u00a5)", min));

        assertEquals(1.09372*min, conv.convert("EUR (\u20ac)", "USD ($)", min));
        assertEquals(0.90889*min, conv.convert("EUR (\u20ac)", "GBP (\u00a3)", min));
        assertEquals(1.63421*min, conv.convert("EUR (\u20ac)", "AUD (A$)", min));
        assertEquals(116.270*min, conv.convert("EUR (\u20ac)", "JPY (\u00a5)", min));

        assertEquals(0.00941*min, conv.convert("JPY (\u00a5)", "USD ($)", min));
        assertEquals(0.00782*min, conv.convert("JPY (\u00a5)", "GBP (\u00a3)", min));
        assertEquals(0.01405*min, conv.convert("JPY (\u00a5)", "AUD (A$)", min));
        assertEquals(0.00860*min, conv.convert("JPY (\u00a5)", "EUR (\u20ac)", min));
    }

    //Need to also somehow test for String input

//    /**
//     * Test for non-numeric input
//     */
//    @Test
//    public void nonNumTest() {
//        Converter conv = new Converter();
//        conv.initializeCurrencies();
//        double notNum = "hello";
//        assertThrows(NumberFormatException.class, () -> {
//            conv.convert("USD ($)", "USD ($)", "notNum");
//        });
//    }


    /**
     * Test for null input
     */
    @Test
    public void nullTest() {
        Converter conv = new Converter();
        conv.initializeCurrencies();
        Double nullDouble = Double.NaN;
        assertThrows(NullPointerException.class, () -> {
            conv.convert( "USD ($)", "USD ($)", nullDouble);
        });
    }
}