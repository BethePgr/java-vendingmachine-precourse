package vendingmachine.controller;

import java.util.List;
import java.util.Map;
import vendingmachine.domain.VendingMachine;
import vendingmachine.util.UtilService;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    public void run(){
        int money = InputController.machineHavingMoney();
        Map<Integer, Integer> coinMap = UtilService.makeCoinListWithRandoms(money);
        OutputView.printCoinMap(coinMap);
        List<String> items = InputController.machineHavingItems();
        VendingMachine vendingMachine = new VendingMachine(money, coinMap, items);

    }
}
