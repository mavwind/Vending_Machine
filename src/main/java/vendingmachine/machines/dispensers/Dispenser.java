package vendingmachine.machines.dispensers;

import vendingmachine.machines.products.Product;

/**
 * Class represnting dispensers with products and specified number of products
 */
public class Dispenser {
    private Product product;
    private int number;

    public Dispenser(Product product, int number) {
        this.product = product;
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public int getNumber() {
        return number;
    }

}
