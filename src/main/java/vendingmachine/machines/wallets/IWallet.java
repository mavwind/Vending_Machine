package vendingmachine.machines.wallets;

import vendingmachine.machines.commons.Coins;
import vendingmachine.machines.wallets.exceptions.WalletRestPreparingException;

import java.util.Map;

public interface IWallet {
    Map<Coins, Integer> getRest(int amount, int productPrice) throws WalletRestPreparingException;
}
