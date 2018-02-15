package vendingmachine.machines;

import vendingmachine.machines.commons.Coins;
import vendingmachine.machines.containers.IContainer;
import vendingmachine.machines.containers.VendingMachineContainer;
import vendingmachine.machines.wallets.IWallet;
import vendingmachine.machines.wallets.VendingMachineWallet;
import vendingmachine.machines.wallets.exceptions.WalletRestPreparingException;

import java.util.Map;

public class VendingMachine implements IMachine {

    private String choice;

    private IContainer container;

    private IWallet wallet;

    private int money = 0;

    public VendingMachine() {
        container = new VendingMachineContainer();
        wallet = new VendingMachineWallet();
    }

    @Override
    public void readChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public IContainer getContainer() {
        return container;
    }

    @Override
    public int getPaymentAmount() {
        return container.getDispenserByCode(choice).getProduct().getPrice();
    }

    @Override
    public void insertCoin(Coins coin) {
        this.money += coin.getCents();
    }

    @Override
    public boolean isEnough() {
        return this.money >= getPaymentAmount();
    }

    @Override
    public Map<Coins, Integer> prepareRest() throws WalletRestPreparingException {
        return wallet.getRest(money, getPaymentAmount());
    }
}
