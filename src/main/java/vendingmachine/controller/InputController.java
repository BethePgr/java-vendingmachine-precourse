package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.service.VendingMachineService;
import vendingmachine.validate.InputBuyingItemValidation;
import vendingmachine.validate.InputClientMoneyValidation;
import vendingmachine.validate.InputItemsValidation;
import vendingmachine.validate.InputMoneyValidation;
import vendingmachine.view.InputView;

public class InputController {

    public static int machineHavingMoney(){
        try{
            String input = InputView.inputMachineHavingMoney();
            InputMoneyValidation.validateMachineHavingMoney(input);
            return Integer.parseInt(input);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return machineHavingMoney();
        }
    }

    public static List<String> machineHavingItems(){
        try{
            String input = InputView.inputMachineHavingItems();
            InputItemsValidation.checkItems(input);
            return Arrays.stream(input.split(";")).collect(Collectors.toList());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return machineHavingItems();
        }
    }

    public static int clientToMachineMoney(){
        try{
            String input = InputView.inputClientMoney();
            InputClientMoneyValidation.checkClientMoney(input);
            return Integer.parseInt(input);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return clientToMachineMoney();
        }
    }

    public static String clientBuyingItem(int clientMoney,VendingMachineService vendingMachineService){
        try{
            String input = InputView.inputBuyingItem(clientMoney);
            InputBuyingItemValidation.checkBuyingItem(vendingMachineService,input);
            return input;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return clientBuyingItem(clientMoney,vendingMachineService);
        }
    }


}
