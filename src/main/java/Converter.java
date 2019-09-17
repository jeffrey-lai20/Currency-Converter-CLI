import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Converter {
    public static HashMap<String, Double> currencyExchangeRatesMap = new HashMap<String, Double>();
    public static List<Double> currencyExchangeRates = new ArrayList<Double>();

    static Object[] keys = currencyExchangeRatesMap.keySet().toArray();
    static double convert(String selectedFrom, String selectedTo,double amount){
        return currencyExchangeRatesMap.get(selectedFrom+selectedTo)*amount;
    };
    static void initializeCurrencies() {
        currencyExchangeRatesMap.put("USD ($)USD ($)", 1.0);
        currencyExchangeRatesMap.put("USD ($)GBP (\u00a3)", 0.83102);
        currencyExchangeRatesMap.put("USD ($)AUD (A$)", 1.49417);
        currencyExchangeRatesMap.put("USD ($)EUR (\u20ac)", 0.91431);
        currencyExchangeRatesMap.put("USD ($)JPY (\u00a5)", 106.306);
        currencyExchangeRatesMap.put("GBP (\u00a3)USD ($)", 1.20336);
        currencyExchangeRatesMap.put("GBP (\u00a3)GBP (\u00a3)", 1.0);
        currencyExchangeRatesMap.put("GBP (\u00a3)AUD (A$)", 1.79802);
        currencyExchangeRatesMap.put("GBP (\u00a3)EUR (\u20ac)", 1.1009);
        currencyExchangeRatesMap.put("GBP (\u00a3)JPY (\u00a5)", 127.924);
        currencyExchangeRatesMap.put("AUD (A$)USD ($)", 0.66932);
        currencyExchangeRatesMap.put("AUD (A$)GBP (\u00a3)", 0.55621);
        currencyExchangeRatesMap.put("AUD (A$)AUD (A$)", 1.0);
        currencyExchangeRatesMap.put("AUD (A$)EUR (\u20ac)", 0.61188);
        currencyExchangeRatesMap.put("AUD (A$)JPY (\u00a5)", 71.1491);
        currencyExchangeRatesMap.put("EUR (\u20ac)USD ($)", 1.09372);
        currencyExchangeRatesMap.put("EUR (\u20ac)GBP (\u00a3)", 0.90889);
        currencyExchangeRatesMap.put("EUR (\u20ac)AUD (A$)", 1.63421);
        currencyExchangeRatesMap.put("EUR (\u20ac)EUR (\u20ac)", 1.0);
        currencyExchangeRatesMap.put("EUR (\u20ac)JPY (\u00a5)", 116.270);
        currencyExchangeRatesMap.put("JPY (\u00a5)USD ($)", 0.00941);
        currencyExchangeRatesMap.put("JPY (\u00a5)GBP (\u00a3)", 0.00782);
        currencyExchangeRatesMap.put("JPY (\u00a5)AUD (A$)", 0.01405);
        currencyExchangeRatesMap.put("JPY (\u00a5)EUR (\u20ac)", 0.00860);
        currencyExchangeRatesMap.put("JPY (\u00a5)JPY (\u00a5)", 1.0);
        keys = currencyExchangeRatesMap.keySet().toArray();
        currencyExchangeRates.add(1.0);
        currencyExchangeRates.add(0.83102);
        currencyExchangeRates.add(1.49417);
        currencyExchangeRates.add(0.91431);
        currencyExchangeRates.add(106.306);
        currencyExchangeRates.add(1.20336);
        currencyExchangeRates.add(1.0);
        currencyExchangeRates.add(1.79802);
        currencyExchangeRates.add(1.1009);
        currencyExchangeRates.add(127.924);
        currencyExchangeRates.add(0.66932);
        currencyExchangeRates.add(0.55621);
        currencyExchangeRates.add(1.0);
        currencyExchangeRates.add(0.61188);
        currencyExchangeRates.add(71.1491);
        currencyExchangeRates.add(1.09372);
        currencyExchangeRates.add(0.90889);
        currencyExchangeRates.add(1.63421);
        currencyExchangeRates.add(1.0);
        currencyExchangeRates.add(116.270);
        currencyExchangeRates.add(0.00941);
        currencyExchangeRates.add(0.00782);
        currencyExchangeRates.add(0.01405);
        currencyExchangeRates.add(0.00860);
        currencyExchangeRates.add(1.0);
    }

}
