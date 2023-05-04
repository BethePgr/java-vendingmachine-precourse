package vendingmachine.validate;

import vendingmachine.service.VendingMachineService;

public class InputBuyingItemValidation {

    public static void checkBuyingItem(VendingMachineService vendingMachineService,String input){
         if(vendingMachineService.getVendingMachine().getItemMap().entrySet().stream()
            .noneMatch(item -> item.getKey().getName().equals(input))){
             throw new IllegalArgumentException("[ERROR] 해당 제품이 기계에 존재하지 않습니다.");
         }
    }

}
