package currencyCalculator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        UserInput userInput = new UserInput();
        System.out.println(userInput.getAvgRate());
        userInput.howMuchFor100Pln(userInput.getCurrency());
    }
}
