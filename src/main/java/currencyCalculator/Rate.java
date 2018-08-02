package currencyCalculator;

public class Rate {

    private String no;
    private String effectiveDate;
    private double bid;
    private double ask;

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public double getBid() {
        return this.bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return this.ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }
}
