package vendingmachine.machines;

import vendingmachine.machines.commons.Coins;
import vendingmachine.machines.containers.IContainer;
import vendingmachine.machines.wallets.exceptions.WalletRestPreparingException;

import java.util.Map;

public interface IMachine {
    void readChoice(String choice);

    IContainer getContainer();

    int getPaymentAmount();

    void insertCoin(Coins coin);

    boolean isEnough();

    Map<Coins, Integer> prepareRest() throws WalletRestPreparingException;
}
