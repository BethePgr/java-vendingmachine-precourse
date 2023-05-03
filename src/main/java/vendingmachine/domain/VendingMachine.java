package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private Map<Integer,Integer> coinList;
    private final int money;

    public VendingMachine(int money){
        this.money = money;
        initMap();
        makeCoinListWithRandoms();
    }
    private void initMap(){
        coinList = new HashMap<>();
        for(Coin coin : Coin.values()){
            coinList.put(coin.getAmount(),0);
        }
    }

    private void makeCoinListWithRandoms(){
        int tempMoney = money;
        while(tempMoney != 0) {
            int randomCoin = Coin.getRandomCoin();
            if(tempMoney >= randomCoin){
                coinList.put(randomCoin,coinList.get(randomCoin)+1);
                tempMoney -= randomCoin;
            }
        }
    }

    public Map<Integer, Integer> getCoinList() {
        return coinList;
    }
}
