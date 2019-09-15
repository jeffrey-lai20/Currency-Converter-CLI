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
        assertEquals(100, conv.convert("USD ($)", "($)GBP (\u00a3)", 83.102));
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
    }

//    /**
//     * Test for non-numeric input
//     */
//    @Test
//    public void nonNumTest() {
//        Converter conv = new Converter();
//        conv.initializeCurrencies();
//        double notNum = "hello";
//        assertThrows(NumberFormatException.class, () -> {
//            conv.convert( "USD ($)", "USD ($)", "notNum");
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