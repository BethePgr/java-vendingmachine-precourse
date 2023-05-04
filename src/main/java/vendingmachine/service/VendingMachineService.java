package vendingmachine.service;

import java.util.Map;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

public class VendingMachineService {

    private final VendingMachine vendingMachine;
    private int clientMoney;

    public VendingMachineService(VendingMachine vendingMachine, int clientMoney){
        this.vendingMachine = vendingMachine;
        this.clientMoney = clientMoney;
    }

    private int findLeastPrice(Map<Product,Integer> itemMap){
        return itemMap.entrySet().stream()
            .filter(item -> item.getValue() != 0)
            .min((e1, e2) -> e1.getKey().getPrice() - e2.getKey().getPrice()).get().getKey().getPrice();
    }

    private void pickOneItem(String item){
        Map<Product, Integer> map = vendingMachine.getItemMap();
        Product key = map.entrySet().stream()
            .filter(items -> items.getKey().getName().equals(item)).findAny().get().getKey();
        map.put(key,map.get(key) - 1);
    }



    public VendingMachine getVendingMachine(){
        return vendingMachine;
    }

}
