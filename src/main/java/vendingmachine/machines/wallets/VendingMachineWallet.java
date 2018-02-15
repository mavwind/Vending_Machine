package vendingmachine.machines.wallets;

import vendingmachine.machines.commons.Coins;
import vendingmachine.machines.commons.InitialState;
import vendingmachine.machines.wallets.exceptions.WalletRestPreparingException;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineWallet implements IWallet {
    private static final String ERROR_MESSAGE = "Error during rest preparing";

    private Map<Coins, Integer> vault = InitialState.getInstance().createVault();

    @Override
    public Map<Coins, Integer> getRest(int paidAmount, int priceToPay) throws WalletRestPreparingException {
        int startNominal = 0;
        return getRest(startNominal, paidAmount, priceToPay);
    }

    private Map<Coins, Integer> getRest(int startNominal, int paidAmount, int priceToPay) throws WalletRestPreparingException {
        Map<Coins, Integer> result = new HashMap<>();
        int restToPrepare = paidAmount - priceToPay;
        int restLeft = restToPrepare;
        Coins[] coins = Coins.values();
        Map<Coins, Integer> vaultCopy = vault;
        for (int i = startNominal; i < coins.length; i++) {
            while (coins[i].getCents() <= restLeft && vault.get(coins[i]) != null && vaultCopy.get(coins[i]) > 0) {
                if (result.get(coins[i]) == null) {
                    result.put(coins[i], 0);
                }
                result.put(coins[i], result.get(coins[i]) + 1);
                vaultCopy.put(coins[i], vaultCopy.get(coins[i])-1);
                restLeft -= coins[i].getCents();
            }
        }
        if (!isRestCorrect(restToPrepare, result)) {
            if (startNominal == coins.length) {
                throw new WalletRestPreparingException(ERROR_MESSAGE);
            }
            return getRest(startNominal + 1, paidAmount, priceToPay);
        }
        return result;
    }

    private boolean isRestCorrect(int restToPrepare, Map<Coins, Integer> rest) {
        int sum = 0;
        for (Map.Entry<Coins, Integer> entry : rest.entrySet()) {
            sum += entry.getValue() * entry.getKey().getCents();
        }
        return sum == restToPrepare;
    }


    public void setVault(Map<Coins, Integer> vault) {
        this.vault = vault;
    }
}
