package vendingmachine.controller;

import java.util.List;
import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineService;
import vendingmachine.util.UtilService;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    public void run(){
        int money = InputController.machineHavingMoney();
        Map<Integer, Integer> coinMap = UtilService.makeCoinListWithRandoms(money);
        OutputView.printCoinMap(coinMap);
        List<String> items = InputController.machineHavingItems();
        VendingMachine vendingMachine = new VendingMachine(money, coinMap, items);
        VendingMachineService vendingMachineService = new VendingMachineService(vendingMachine,
            InputController.clientToMachineMoney());
        while(vendingMachineService.getClientMoney() >= vendingMachineService.findLeastPrice()){
            String itemPrice = InputController.clientBuyingItem(vendingMachineService.getClientMoney(), vendingMachineService);
            vendingMachineService.pickOneItem(itemPrice);
        }
        OutputView.printCalculateCharge(vendingMachine.getCoinMap(),
            vendingMachineService.getClientMoney());
    }

}
