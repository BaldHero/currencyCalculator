package currencyCalculator;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
    private Scanner scanner;
    private String currency;

    public UserInput() {
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public String getInput() {
        scanner = new Scanner(System.in);
        System.out.println("Enter currency code:");
        String currency = scanner.next();
        scanner.close();
        setCurrency(currency);
        return currency;
    }

    public double getAvgRate() throws IOException {
        String input = getInput();
        return sendRequest(input);
    }

    public double sendRequest(String input) throws IOException {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + input + "?format=json");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Chrome");
        Scanner scanner = new Scanner(connection.getInputStream());
        String stream = scanner.nextLine();
        Gson gson = new Gson();
        RootObject obj = gson.fromJson(stream, RootObject.class);
//        Rate rate = gson.fromJson(stream, Rate.class);
        ArrayList<Rate> rates = obj.getRates();
        scanner.close();
        return rates.get(0).getAsk();
    }

    public void howMuchFor100Pln(String input) throws IOException {
        double result = (double) Math.round((100 / sendRequest(input)) * 100) / 100;
        System.out.println("For 100PLN you will receive: " + result + input.toUpperCase());
    }
}
