package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vendingmachine.util.UtilService;

public class VendingMachine {

    private Map<Integer, Integer> coinMap;
    private final int money;
    private Map<Product, Integer> itemMap = new HashMap<>();

    public VendingMachine(int money,Map<Integer, Integer> coinMap,List<String> itemList) {
        this.money = money;
        this.coinMap = coinMap;
        makeItemMap(itemList);
    }

    private void makeItemMap(List<String> itemList) {
        for (String item : itemList) {
            item = item.substring(1, item.length() - 1);
            String[] splits = item.split(",");
            itemMap.put(new Product(splits[0], Integer.parseInt(splits[1])),
                Integer.parseInt(splits[2]));
        }
    }

    public Map<Integer, Integer> getCoinMap() {
        return coinMap;
    }

    public Map<Product,Integer> getItemMap(){
        return itemMap;
    }

    public int getMoney(){
        return money;
    }
}
