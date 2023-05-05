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
        VendingMachineService vmService = preService();
        buyItems(vmService);
        OutputView.printCalculateCharge(vmService.getVendingMachine().getCoinMap(),
            vmService.getClientMoney());
    }

    private Map<Integer,Integer> makeCoinMap(int money){
        Map<Integer, Integer> coinMap = UtilService.makeCoinListWithRandoms(money);
        OutputView.printCoinMap(coinMap);
        return coinMap;
    }

    private VendingMachineService preService(){
        int money = InputController.machineHavingMoney();
        Map<Integer, Integer> coinMap = makeCoinMap(money);
        List<String> items = InputController.machineHavingItems();
        return makeVendingMachineService(money, coinMap,items);
    }

    private VendingMachineService makeVendingMachineService(int money,Map<Integer,Integer> coinMap,List<String> items){
        VendingMachine vendingMachine = new VendingMachine(money, coinMap, items);
        return new VendingMachineService(vendingMachine,
            InputController.clientToMachineMoney());
    }

    private void buyItems(VendingMachineService vmService){
        while(vmService.getClientMoney() >= vmService.findLeastPrice()){
            String itemPrice = InputController.clientBuyingItem(vmService.getClientMoney(), vmService);
            vmService.pickOneItem(itemPrice);
        }
    }
}
