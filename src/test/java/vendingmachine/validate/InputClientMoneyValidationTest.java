package vendingmachine.validate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputClientMoneyValidationTest {

    @Test
    void noError1() throws Exception{
        assertDoesNotThrow(() -> InputClientMoneyValidation.checkClientMoney("20"));
    }

    @Test
    void noError2() throws Exception{
        assertDoesNotThrow(() -> InputClientMoneyValidation.checkClientMoney("120"));
    }

    @Test
    void Error1() throws Exception{
        assertThrows(IllegalArgumentException.class,()-> InputClientMoneyValidation.checkClientMoney("121"));
    }
}