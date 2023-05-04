package vendingmachine.validate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputMoneyValidationTest {

    @Test
    @DisplayName("10으로 나누어지지 않으므로 에러를 발생시킨다.")
    void notDivideBy10() throws Exception {
        //given
        String input = "11";
        //then
        assertThrows(IllegalArgumentException.class,() -> InputMoneyValidation.validateMachineHavingMoney(input));
    }

    @Test
    @DisplayName("숫자로만 이루어져 있지 않으므로 에러를 발생시킨다.")
    void notOnlyNumber() throws Exception {
        //given
        String input = "ab10";
        //then
        assertThrows(IllegalArgumentException.class,()-> InputMoneyValidation.validateMachineHavingMoney(input));
    }

    @Test
    @DisplayName("10으로 나누어 떵러지면서 숫자로만 이루어져 있으므로 에러를 발생시키지 않는다.")
    void divideBy10AndOnlyNumber1() throws Exception {
        //given
        String input = "10";
        //then
        assertDoesNotThrow(() -> InputMoneyValidation.validateMachineHavingMoney(input));
    }
    @Test
    @DisplayName("10으로 나누어 떵러지면서 숫자로만 이루어져 있으므로 에러를 발생시키지 않는다.")
    void divideBy10AndOnlyNumber2() throws Exception {
        //given
        String input = "120";
        //then
        assertDoesNotThrow(() -> InputMoneyValidation.validateMachineHavingMoney(input));
    }
}