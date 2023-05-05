package vendingmachine.view;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    public static void printCoinMap(Map<Integer, Integer> coinMap) {
        System.out.println("자판기가 보유한 동전");
        printSortedMap(coinMap);

    }

    public static void printCalculateCharge(Map<Integer, Integer> coinMap,int clientMoney){
        System.out.println("투입 금액: " + clientMoney + "원");
        System.out.println("잔돈");
        printSortedMap(coinMap);
    }

    private static void printSortedMap(Map<Integer, Integer> coinMap){
        coinMap.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
            .forEach(entry -> System.out.println(entry.getKey()+"원 - "+ entry.getValue()+"개"));
    }


}
