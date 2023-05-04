package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    private Map<Integer, Integer> coinMap;
    private final int money;
    private Map<Product, Integer> itemMap;

    public VendingMachine(int money) {
        this.money = money;
        initMap();
        makeCoinListWithRandoms();
    }

    private void initMap() {
        coinMap = new HashMap<>();
        for (Coin coin : Coin.values()) {
            coinMap.put(coin.getAmount(), 0);
        }
    }

    private void makeCoinListWithRandoms() {
        int tempMoney = money;
        while (tempMoney != 0) {
            int randomCoin = Coin.getRandomCoin();
            if (tempMoney >= randomCoin) {
                coinMap.put(randomCoin, coinMap.get(randomCoin) + 1);
                tempMoney -= randomCoin;
            }
        }
    }

    private void makeItemMap(List<String> itemList) {
        for (String item : itemList) {
            item = item.substring(1, item.length() - 1);
            String[] splits = item.split(",");
            itemMap.put(new Product(splits[0], Integer.parseInt(splits[1])),
                Integer.parseInt(splits[3]));
        }
    }

    public Map<Integer, Integer> getCoinList() {
        return coinMap;
    }

    public Map<Product,Integer> getItemMap(){
        return itemMap;
    }
}
