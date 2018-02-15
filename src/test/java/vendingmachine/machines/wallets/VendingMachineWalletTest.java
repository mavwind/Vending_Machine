package vendingmachine.machines.wallets;

import org.junit.Assert;
import org.junit.Test;
import vendingmachine.machines.commons.Coins;
import vendingmachine.machines.wallets.exceptions.WalletRestPreparingException;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineWalletTest {

    @Test
    public void shouldPrepareRest_10GR_20GR_1GR() throws Exception, WalletRestPreparingException {

        //given
        final Map<Coins, Integer> expectedRest = new HashMap<>();
        expectedRest.put(Coins.TEN_GR, 1);
        expectedRest.put(Coins.TWENTY_GR, 1);
        expectedRest.put(Coins.ONE_GR, 1);

        final int priceToBePaid = 169;
        final int paidAmount = 200;

        VendingMachineWallet vendingMachineWallet = new VendingMachineWallet();
        vendingMachineWallet.setVault(prepareVault1());

        //when
        Map<Coins, Integer> rest = vendingMachineWallet.getRest(paidAmount, priceToBePaid);

        //then
        Assert.assertEquals(expectedRest, rest);
    }

    @Test
    public void shouldPrepareRest_3x50GR_1GR() throws Exception, WalletRestPreparingException {
        //given
        final Map<Coins, Integer> expectedRest = new HashMap<>();
        expectedRest.put(Coins.FIFTY_GR, 3);
        expectedRest.put(Coins.ONE_GR, 1);

        final int priceToBePaid = 149;
        final int paidAmount = 300;

        VendingMachineWallet vendingMachineWallet = new VendingMachineWallet();
        vendingMachineWallet.setVault(prepareVault2());

        //when
        Map<Coins, Integer> rest = vendingMachineWallet.getRest(paidAmount, priceToBePaid);

        //then
        Assert.assertEquals(expectedRest, rest);
    }

    @Test
    public void shouldPrepareRest_3x20GR_1x1GR() throws Exception, WalletRestPreparingException {
        //given
        final Map<Coins, Integer> expectedRest = new HashMap<>();
        expectedRest.put(Coins.TWENTY_GR, 3);

        final int priceToBePaid = 140;
        final int paidAmount = 200;

        VendingMachineWallet vendingMachineWallet = new VendingMachineWallet();
        vendingMachineWallet.setVault(prepareVault3());

        //when
        Map<Coins, Integer> rest = vendingMachineWallet.getRest(paidAmount, priceToBePaid);

        //then
        Assert.assertEquals(expectedRest, rest);
    }

    @Test
    public void shouldThrowExceptionDuringRestPreparation() throws Exception, WalletRestPreparingException {
        //given
        final Map<Coins, Integer> expectedRest = new HashMap<>();
        expectedRest.put(Coins.TWENTY_GR, 3);

        final int priceToBePaid = 250;
        final int paidAmount = 10000;

        VendingMachineWallet vendingMachineWallet = new VendingMachineWallet();
        vendingMachineWallet.setVault(prepareVault4());

        //when
        try {
            Map<Coins, Integer> rest = vendingMachineWallet.getRest(paidAmount, priceToBePaid);
            Assert.fail();
        } catch (WalletRestPreparingException e) {
        }

    }


    private Map<Coins, Integer> prepareVault1() {
        Map<Coins, Integer> vault = new HashMap<>();
        vault.put(Coins.FIFTY_GR, 2);
        vault.put(Coins.TWENTY_GR, 3);
        vault.put(Coins.TEN_GR, 2);
        vault.put(Coins.ONE_GR, 1);
        return vault;
    }

    private Map<Coins, Integer> prepareVault2() {
        Map<Coins, Integer> vault = new HashMap<>();
        vault.put(Coins.FIFTY_GR, 3);
        vault.put(Coins.TWENTY_GR, 3);
        vault.put(Coins.TEN_GR, 2);
        vault.put(Coins.ONE_GR, 1);
        return vault;
    }

    private Map<Coins, Integer> prepareVault3() {
        Map<Coins, Integer> vault = new HashMap<>();
        vault.put(Coins.FIFTY_GR, 3);
        vault.put(Coins.TWENTY_GR, 3);
        return vault;
    }

    private Map<Coins, Integer> prepareVault4() {
        Map<Coins, Integer> vault = new HashMap<>();
        vault.put(Coins.ONE_GR, 20);
        vault.put(Coins.TWENTY_GR, 10);
        vault.put(Coins.ONE_PLN,30);
        return vault;
    }
}