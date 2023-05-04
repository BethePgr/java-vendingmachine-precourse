package vendingmachine.view;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    public static void printCoinMap(Map<Integer, Integer> coinMap) {
        System.out.println("자판기가 보유한 동전");
        coinMap.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
            .forEach(entry -> System.out.println(entry.getKey()+"원 - "+ entry.getValue()+"개"));

    }

}
