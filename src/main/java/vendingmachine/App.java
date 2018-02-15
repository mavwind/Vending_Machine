package vendingmachine;

import vendingmachine.machines.IMachine;
import vendingmachine.machines.VendingMachine;
import vendingmachine.machines.commons.Coins;
import vendingmachine.machines.wallets.exceptions.WalletRestPreparingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        IMachine vendingMachine = new VendingMachine();

        //==========PRINT LIST OF PRODUCTS AND CODES========================
        Set<String> choicesMap = vendingMachine.getContainer().getCodes();

        for (String key : choicesMap) {
            System.out.println(key);
        }
        //====================================================================


        //=======================PRODUCT CHOICE===============================
        System.out.println("Choose product");
        String choice = reader.readLine();
        vendingMachine.readChoice(choice);
        int productPrice = vendingMachine.getPaymentAmount();
        //====================================================================


        try {
            //================PAYMENT====================================
            System.out.println("Amount to pay: " + formatNumber(productPrice));
            System.out.println("Put money");
            boolean paid = false;
            while (paid == false) {
                String cents = reader.readLine();
                vendingMachine.insertCoin(identifyCoinByCentValue(cents));
                paid = vendingMachine.isEnough();
            }
            //=====================================================================

            //================GIVE CHANGE======================================
            Map<Coins, Integer> rest = vendingMachine.prepareRest();

            System.out.println("Change was given:");
            for (Coins key : rest.keySet()) {
                System.out.println(rest.get(key) + " x " + key.name());
            }
            //====================================================================
            System.out.println("Product released");
        } catch (WalletRestPreparingException e) {
            System.out.println("The process was interrupted - spending change is impossible. Money is returned");
        }
    }

    private static Coins identifyCoinByCentValue(String coin) {
        Coins result;
        switch (coin) {
            case "1":
                result = Coins.ONE_GR;
                break;
            case "2":
                result = Coins.TWO_GR;
                break;
            case "5":
                result = Coins.FIVE_GR;
                break;
            case "10":
                result = Coins.TEN_GR;
                break;
            case "20":
                result = Coins.TWENTY_GR;
                break;
            case "50":
                result = Coins.FIFTY_GR;
                break;
            case "100":
                result = Coins.ONE_PLN;
                break;
            case "200":
                result = Coins.TWO_PLN;
                break;
            case "500":
                result = Coins.FIVE_PLN;
                break;
            case "1000":
                result = Coins.TEN_PLN;
                break;
            case "2000":
                result = Coins.TWENTY_PLN;
                break;
            case "5000":
                result = Coins.FIFTY_PLN;
                break;
            case "10000":
                result = Coins.ONE_HUNDRED_PLN;
                break;
            case "20000":
                result = Coins.TWO_HUNDRED_PLN;
                break;
            default:
                result = null;
                break;
        }
        return result;
    }

    private static float formatNumber(int number) {
        return (float) number / 100;
    }
}
