package vendingmachine.util;

import java.util.HashMap;
import java.util.Map;
import vendingmachine.domain.Coin;

public class UtilService {

    public static Map<Integer, Integer> makeCoinListWithRandoms(int money) {
        Map<Integer, Integer> coinMap = new HashMap<>();
        int tempMoney = money;
        while (tempMoney != 0) {
            int randomCoin = Coin.getRandomCoin();
            if (tempMoney >= randomCoin) {
                coinMap.put(randomCoin, coinMap.getOrDefault(randomCoin, 0) + 1);
                tempMoney -= randomCoin;
            }
        }
        return coinMap;
    }

}
