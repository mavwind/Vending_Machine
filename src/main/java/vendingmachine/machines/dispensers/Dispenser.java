package vendingmachine.machines.dispensers;

import vendingmachine.machines.products.Product;

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

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
