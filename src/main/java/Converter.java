import java.util.ArrayList;
import java.util.List;

class Converter {
    static List<Currency> currencyExchangeRates = new ArrayList<Currency>();
    static double convert(String selectedFrom, String selectedTo,double amount){
        // USD CONVERSIONS
        if (selectedFrom.equals("USD ($)") && selectedTo.equals("USD ($)")) {
            return currencyExchangeRates.get(0).getExchangeValue();
        }
        if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("USD ($)")) {
            return currencyExchangeRates.get(5).getExchangeValue();
        }
        if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("USD ($)")) {
            return currencyExchangeRates.get(10).getExchangeValue();
        }
        if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("USD ($)")) {
            return currencyExchangeRates.get(15).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("USD ($)")) {
            return currencyExchangeRates.get(20).getExchangeValue()*amount;
        }

        // GBP CONVERSIONS
        if (selectedFrom.equals("USD ($)") && selectedTo.equals("GBP (\u00a3)")) {
            return currencyExchangeRates.get(1).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("GBP (\u00a3)")) {
            return currencyExchangeRates.get(6).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("GBP (\u00a3)")) {
            return currencyExchangeRates.get(11).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("GBP (\u00a3)")) {
            return currencyExchangeRates.get(16).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("GBP (\u00a3)")) {
            return currencyExchangeRates.get(21).getExchangeValue()*amount;
        }

        // AUS CONVERSIONS
        if (selectedFrom.equals("USD ($)") && selectedTo.equals("AUD (A$)")) {
            return currencyExchangeRates.get(2).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("AUD (A$)")) {
            return currencyExchangeRates.get(7).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("AUD (A$)")) {
            return currencyExchangeRates.get(12).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("AUD (A$)")) {
            return currencyExchangeRates.get(17).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("AUD (A$)")) {
            return currencyExchangeRates.get(22).getExchangeValue()*amount;
        }

        // EUR CONVERSIONS
        if (selectedFrom.equals("USD ($)") && selectedTo.equals("EUR (\u20ac)")) {
            return currencyExchangeRates.get(3).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("EUR (\u20ac)")) {
            return currencyExchangeRates.get(8).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("EUR (\u20ac)")) {
            return currencyExchangeRates.get(13).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("EUR (\u20ac)")) {
            return currencyExchangeRates.get(18).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("EUR (\u20ac)")) {
            return currencyExchangeRates.get(23).getExchangeValue()*amount;
        }

        // JPY CONVERSIONS
        if (selectedFrom.equals("USD ($)") && selectedTo.equals("JPY (\u00a5)")) {
            return currencyExchangeRates.get(4).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("GBP (\u00a3)") && selectedTo.equals("JPY (\u00a5)")) {
            return currencyExchangeRates.get(9).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("AUD (A$)") && selectedTo.equals("JPY (\u00a5)")) {
            return currencyExchangeRates.get(14).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("EUR (\u20ac)") && selectedTo.equals("JPY (\u00a5)")) {
            return currencyExchangeRates.get(19).getExchangeValue()*amount;
        }
        if (selectedFrom.equals("JPY (\u00a5)") && selectedTo.equals("JPY (\u00a5)")) {
            return currencyExchangeRates.get(24).getExchangeValue()*amount;
        }
        else{
            return 0.0;
        }
    };
    static void initializeCurrencies() {
        //0
        Currency USDUSD =  new Currency("USD", "USD", 1);
        currencyExchangeRates.add(USDUSD);
        //1
        Currency USDGBP =  new Currency("USD", "GBP", 0.83102);
        currencyExchangeRates.add(USDGBP);
        //2
        Currency USDAUD =  new Currency("USD", "AUD", 1.49417);
        currencyExchangeRates.add(USDAUD);
        //3
        Currency USDEUR =  new Currency("USD", "EUR", 0.91431);
        currencyExchangeRates.add(USDEUR);
        //4
        Currency USDJPY =  new Currency("USD", "JPY", 106.306);
        currencyExchangeRates.add(USDJPY);
        //5
        Currency GBPUSD =  new Currency("GBP", "USD", 0.91431);
        currencyExchangeRates.add(GBPUSD);
        //6
        Currency GBPGBP =  new Currency("GBP", "GBP", 1);
        currencyExchangeRates.add(GBPGBP);
        //7
        Currency GBPAUD =  new Currency("GBP", "AUD", 1.79802);
        currencyExchangeRates.add(GBPAUD);
        //8
        Currency GBPEUR =  new Currency("GBP", "EUR", 1.1009);
        currencyExchangeRates.add(GBPEUR);
        //9
        Currency GBPJPY =  new Currency("GBP", "JPY", 127.924);
        currencyExchangeRates.add(GBPJPY);
        //10
        Currency AUDUSD =  new Currency("AUD", "USD", 0.66932);
        currencyExchangeRates.add(AUDUSD);
        //11
        Currency AUDGBP =  new Currency("AUD", "GBP", 0.55621);
        currencyExchangeRates.add(AUDGBP);
        //12
        Currency AUDAUD =  new Currency("AUD", "AUD", 1);
        currencyExchangeRates.add(AUDAUD);
        //13
        Currency AUDEUR =  new Currency("AUD", "EUR", 0.61188);
        currencyExchangeRates.add(AUDEUR);
        //14
        Currency AUDJPY =  new Currency("AUD", "JPY", 71.1491);
        currencyExchangeRates.add(AUDJPY);
        //15
        Currency EURUSD =  new Currency("EUR", "USD", 1.09372);
        currencyExchangeRates.add(EURUSD);
        //16
        Currency EURGBP =  new Currency("EUR", "GBP", 0.90889);
        currencyExchangeRates.add(EURGBP);
        //17
        Currency EURAUD =  new Currency("EUR", "AUD", 1.63421);
        currencyExchangeRates.add(EURAUD);
        //18
        Currency EUREUR =  new Currency("EUR", "EUR", 1);
        currencyExchangeRates.add(EUREUR);
        //19
        Currency EURJPY =  new Currency("EUR", "JPY", 116.270);
        currencyExchangeRates.add(EURJPY);
        //20
        Currency JPYUSD =  new Currency("JPY", "USD", 0.00941);
        currencyExchangeRates.add(JPYUSD);
        //21
        Currency JPYGBP =  new Currency("JPY", "GBP", 0.00782);
        currencyExchangeRates.add(JPYGBP);
        //22
        Currency JPYAUD =  new Currency("JPY", "AUD", 0.01405);
        currencyExchangeRates.add(JPYAUD);
        //23
        Currency JPYEUR =  new Currency("JPY", "EUR", 0.00860);
        currencyExchangeRates.add(JPYEUR);
        //24
        Currency JPYJPY =  new Currency("JPY", "JPY", 1);
        currencyExchangeRates.add(JPYJPY);
    }
}
