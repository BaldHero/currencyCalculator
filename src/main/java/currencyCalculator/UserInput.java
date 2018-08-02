package currencyCalculator;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
    Scanner scanner;

    public String getInput() {
        scanner = new Scanner(System.in);
        System.out.println("Enter currency:");
        String currency = scanner.next();
        scanner.close();
        return currency;
    }

    public double getAvgRate() throws IOException {
        double avgRate = 0;
        String input = getInput();
        return sendRequest(input);
    }

    public double sendRequest(String input) throws IOException {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/" + input + "?format=json");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Chrome");
        Scanner scanner = new Scanner(connection.getInputStream());
        String stream = scanner.nextLine();
        Gson gson = new Gson();
        RootObject obj = gson.fromJson(stream, RootObject.class);
//        Rate rate = gson.fromJson(stream, Rate.class);
        ArrayList<Rate> rates = obj.getRates();
        scanner.close();
        return rates.get(0).getMid();
    }
}
