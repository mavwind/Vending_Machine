package vendingmachine.machines.containers;

import vendingmachine.machines.dispensers.Dispenser;

import java.util.Set;

public interface IContainer {

    Dispenser getDispenserByCode(String code);

    Set<String> getCodes();
}
