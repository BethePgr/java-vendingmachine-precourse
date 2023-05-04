package vendingmachine.validate;

public class InputItemsValidation {

    public static void checkItems(String input){
        String[] split = input.split(";");
        for(String smallSplits : split) {
            if(!isStartAndEndEqualsBracket(smallSplits)){
                throw new IllegalArgumentException("[ERROR] 대괄호로 시작해서 대괄호로 끝나야합니다.");
            }
            smallSplits = smallSplits.substring(1,smallSplits.length()-1);
            if (!isSmallSplitsLengthThree(smallSplits)) {
                throw new IllegalArgumentException("[ERROR] 상품명,상품가격,상품개수만 컴마를 이용해 작성하고 각각 ; 통해 구분합니다.");
            }
            if (!isStringArraySecondIndexOver100AndDivide10(smallSplits.split(",")[1])){
                throw new IllegalArgumentException("[ERROR] 가격은 100보다 크면서 10으로 나누어 떨어져야합니다.");
            }
            if (!notZero(smallSplits.split(",")[2])) {
                throw new IllegalArgumentException("[ERROR] 개수는 0개 이상이여야 합니다.");
            }
        }
    }

    private static boolean isStartAndEndEqualsBracket(String input){
        return input.startsWith("[") && input.endsWith("]");
    }

    private static boolean isSmallSplitsLengthThree(String smallSplits){
        return smallSplits.split(",").length == 3;
    }

    private static boolean onlyNumber(String input){
        String reg = "^[0-9]+$";
        return input.matches(reg);
    }

    private static boolean isStringArraySecondIndexOver100AndDivide10(String input){
        if(onlyNumber(input)) {
            return Integer.parseInt(input) >= 100 && Integer.parseInt(input) % 10 == 0;
        }
        return false;
    }

    public static boolean notZero(String input){
        if(onlyNumber(input)){
            return Integer.parseInt(input) != 0;
        }
        return false;
    }

}
