package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputMachineHavingMoney(){
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputMachineHavingItems(){
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputClientMoney(){
        System.out.println("투입 금액을 입력해 주세요.");
        return Console.readLine();
    }


    public static String inputBuyingItem(int money){
        printNowMoney(money);
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }

    private static void printNowMoney(int money){
        System.out.println("투입 금액: " + money+"원");
    }
}
