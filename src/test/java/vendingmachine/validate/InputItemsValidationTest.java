package vendingmachine.validate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputItemsValidationTest {

    @Test
    @DisplayName("양식에 맞게 잘 쓴 상황")
    void success1() throws Exception {
        //given
        assertDoesNotThrow(() -> InputItemsValidation.checkItems("[콜라,1500,20];[사이다,1000,10]"));
    }

    @Test
    @DisplayName("양식에 맞게 쓰지 못한 상황 - ;없음")
    void fail1() throws Exception {
        //given
        assertThrows(IllegalArgumentException.class,
            () -> InputItemsValidation.checkItems("[콜라,1500,20][사이다,1000,10]"));
    }

    @Test
    @DisplayName("양식에 맞게 쓰지 못한 상황 - 가격 100보다 작음")
    void fail2() throws Exception {
        //given
        assertThrows(IllegalArgumentException.class,
            () -> InputItemsValidation.checkItems("[콜라,10,20][사이다,1000,10]"));
    }

    @Test
    @DisplayName("양식에 맞게 쓰지 못한 상황 - 가격 10으로 안 나누어떨어짐")
    void fail3() throws Exception {
        //given
        assertThrows(IllegalArgumentException.class,
            () -> InputItemsValidation.checkItems("[콜라,11,20][사이다,1000,10]"));
    }

    @Test
    @DisplayName("양식에 맞게 쓰지 못한 상황 - 개수가 0개임")
    void fail4() throws Exception {
        //given
        assertThrows(IllegalArgumentException.class,
            () -> InputItemsValidation.checkItems("[콜라,11,20][사이다,1000,0]"));
    }

    @Test
    @DisplayName("양식에 맞게 쓰지 못한 상황 - ,로 나누었을 때 4개로 나누어짐")
    void fail5() throws Exception {
        //given
        assertThrows(IllegalArgumentException.class,
            () -> InputItemsValidation.checkItems("[콜라,1500,2,0][사이다,1000,20]"));
    }

    @Test
    @DisplayName("양식에 맞게 쓰지 못한 상황 - 대괄호 없음")
    void fail6() throws Exception {
        //given
        assertThrows(IllegalArgumentException.class,
            () -> InputItemsValidation.checkItems("[콜라,1500,2,0]사이다,1000,20]"));
    }
}