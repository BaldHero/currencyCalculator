package currencyCalculator;

import java.util.ArrayList;

public class RootObject {

    private String table;
    private String currency;
    private String code;
    private ArrayList<Rate> rates;

    public String getTable() {
        return this.table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Rate> getRates() {
        return this.rates;
    }

    public void setRates(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "RootObject{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }
}
