package vendingmachine.validate;

public class InputClientMoneyValidation {

    public static void checkClientMoney(String input) {
        if (isInputEqualsNumber(input)) {
            if (isDivideBy10(input)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 10으로 나누어 떨어지는 숫자를 입력해주세요.");
    }

    private static boolean isInputEqualsNumber(String input) {
        String reg = "^[0-9]+$";
        return input.matches(reg);
    }

    private static boolean isDivideBy10(String input) {
        return Integer.parseInt(input) % 10 == 0;
    }
}
