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

    public int findLeastPrice(){
        Map<Product, Integer> itemMap = vendingMachine.getItemMap();
        return itemMap.entrySet().stream()
            .filter(item -> item.getValue() != 0)
            .min((e1, e2) -> e1.getKey().getPrice() - e2.getKey().getPrice()).get().getKey().getPrice();
    }

    public void pickOneItem(String item){
        Map<Product, Integer> map = vendingMachine.getItemMap();
        Product key = map.entrySet().stream()
            .filter(items -> items.getKey().getName().equals(item)).findAny().get().getKey();
        try {
            checkPrice(key.getPrice());
            map.put(key, map.get(key) - 1);
            clientMoney -= key.getPrice();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void checkPrice(int itemPrice){
        if(itemPrice > clientMoney){
            throw new IllegalArgumentException("[ERROR] 상품 가격이 더 남은 고객의 금액보다 비쌉니다.");
        }
    }

    public VendingMachine getVendingMachine(){
        return vendingMachine;
    }

    public int getClientMoney(){
        return clientMoney;
    }

}
