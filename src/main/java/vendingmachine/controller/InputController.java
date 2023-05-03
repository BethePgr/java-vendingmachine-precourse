package vendingmachine.controller;

import vendingmachine.validate.InputValidation;
import vendingmachine.view.InputView;

public class InputController {

    public static int machineHavingMoney(){
        try{
            String input = InputView.inputMachineHavingMoney();
            InputValidation.validateMachineHavingMoney(input);
            return Integer.parseInt(input);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return machineHavingMoney();
        }
    }
}
