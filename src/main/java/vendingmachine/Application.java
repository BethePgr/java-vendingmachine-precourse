package vendingmachine;

import java.util.HashMap;
import java.util.Map;
import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.Product;
import vendingmachine.service.VendingMachineService;

public class Application {

    public static void main(String[] args) {
        VendingMachineController vendingMachineController = new VendingMachineController();
        vendingMachineController.run();
    }
}
