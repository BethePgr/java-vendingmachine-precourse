package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.util.UtilService;

class VendingMachineTest {

    @Test
    @DisplayName("무작위로 동전이 금액에 맞춰 잘 생성되는가")
    void testMoneyAndCoins() throws Exception {
        //given
        int realMoney = (int)((Math.random()+1)*10000);
        realMoney = realMoney - realMoney%10;
        for(int i = 0;i<5000;i++) {
            Map<Integer, Integer> coinMap = UtilService.makeCoinListWithRandoms(realMoney);
            List<String> itemList = new ArrayList<>();
            VendingMachine vendingMachine = new VendingMachine(realMoney,coinMap,itemList);
            int expectMoney = 0;
            for (Entry<Integer, Integer> entry : vendingMachine.getCoinMap().entrySet()) {
                expectMoney += entry.getKey() * entry.getValue();
            }
            assertEquals(realMoney, expectMoney);
        }
    }

}