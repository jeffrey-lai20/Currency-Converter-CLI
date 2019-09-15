public class Currency {
    private String from;
    private String to;
    private double exchangeValue;
    Currency(String f, String t, double exchangeVal) {
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
    double getExchangeValue() {
        return this.exchangeValue;
    }
}
