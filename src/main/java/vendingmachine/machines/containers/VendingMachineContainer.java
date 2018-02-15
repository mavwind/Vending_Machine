package vendingmachine.machines.containers;

import vendingmachine.machines.commons.InitialState;
import vendingmachine.machines.dispensers.Dispenser;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class VendingMachineContainer implements IContainer {

    private Map<String, Dispenser> stock;

    private InitialState initialState = InitialState.getInstance();

    public VendingMachineContainer() {
        this.stock = initialState.createStock();
    }

    @Override
    public Dispenser getDispenserByCode(String code) {
        return stock.get(code);
    }

    @Override
    public Set<String> getCodes() {
        return stock.keySet().stream()
                .filter(x -> stock.get(x).getNumber() > 0)
                .map(x -> x + " " + stock.get(x).getProduct().getName())
                .collect(Collectors.toSet());
    }
}
