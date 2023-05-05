package vendingmachine.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import vendingmachine.domain.Coin;
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

    public Map<Integer,Integer> calculateCharge(){
        Map<Integer, Integer> coinMap = vendingMachine.getCoinMap();
        Set<Integer> keys = coinMap.keySet();
        for(int key : keys){
            while(coinMap.get(key) != 0 || clientMoney !=0){
                coinMap.put(key,coinMap.get(key)-1);
                clientMoney-=key;
            }
        }
        return coinMap;
    }


    public VendingMachine getVendingMachine(){
        return vendingMachine;
    }

    public int getClientMoney(){
        return clientMoney;
    }

}
