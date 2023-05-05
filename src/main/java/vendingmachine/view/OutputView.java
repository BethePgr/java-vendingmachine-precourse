package vendingmachine.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.domain.Coin;

public class OutputView {

    public static void printCoinMap(Map<Integer, Integer> coinMap) {
        System.out.println("자판기가 보유한 동전");
        printSortedMap(coinMap);

    }

    public static void printCalculateCharge(Map<Integer, Integer> coinMap, int clientMoney) {
        System.out.println("투입 금액: " + clientMoney + "원");
        System.out.println("잔돈");
        printSortedChargeMap(coinMap);
    }

    private static void printSortedMap(Map<Integer, Integer> coinMap) {
        Arrays.stream(Coin.values()).forEach(entry -> System.out.println(entry.getAmount() + "원 - "
            + coinMap.getOrDefault(entry.getAmount(), 0) + "개"));
    }

    private static void printSortedChargeMap(Map<Integer, Integer> coinMap) {
        coinMap.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
            .forEach(entry -> System.out.println(entry.getKey() + "원 - " + entry.getValue() + "개"));
    }

}
