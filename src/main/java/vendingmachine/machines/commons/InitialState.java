package vendingmachine.machines.commons;

import vendingmachine.machines.dispensers.Dispenser;
import vendingmachine.machines.products.Product;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class InitialState {

    private static final InitialState instance = new InitialState();

    private InitialState() {}

    public static InitialState getInstance() {
        return instance;
    }

    public Map<String, Dispenser> createStock() {
        Map<String, Dispenser> stockMap = new LinkedHashMap<>();

        Product product1 = new Product("Coca cola", 199, ProductType.DRINK);
        stockMap.put("4F", new Dispenser(product1, 10));

        Product product2 = new Product("Coca cola light", 199, ProductType.DRINK);
        stockMap.put("22", new Dispenser(product2, 10));

        Product product3 = new Product("Snickers", 250, ProductType.SWEET);
        stockMap.put("5A", new Dispenser(product3, 10));

        Product product4 = new Product("Mars", 240, ProductType.SWEET);
        stockMap.put("8B", new Dispenser(product4, 0));

        return stockMap;
    }

    public Map<Coins, Integer> createVault() {
        Map<Coins, Integer> temp = new HashMap<>();
        temp.put(Coins.ONE_GR, 20);
        temp.put(Coins.TWENTY_GR, 10);
        temp.put(Coins.ONE_PLN,30);
        return temp;
    }
}
