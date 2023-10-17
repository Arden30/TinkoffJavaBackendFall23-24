package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Цифровая строчка")
    void digitalString() {
        //given
        String str = "123456";

        //when
        String result = Task4.fixString(str);

        //then
        assertThat(result)
            .isEqualTo("214365");
    }

    @Test
    @DisplayName("Длинная строчка с пробелами")
    void mixedString() {
        //given
        String str = "hTsii  s aimex dpus rtni.g";

        //when
        String result = Task4.fixString(str);

        //then
        assertThat(result)
            .isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("В строке нечетное число символов")
    void oddLenString() {
        //given
        String str = "badce";

        //when
        String result = Task4.fixString(str);

        //then
        assertThat(result)
            .isEqualTo("abcde");
    }

    @Test
    @DisplayName("Различные пробелы")
    void withSpacesString() {
        //given
        String str = "   b     ad  c   e      ";

        //when
        String result = Task4.fixString(str);

        //then
        assertThat(result)
            .isEqualTo("  b     a  dc   e       ");
    }

    @Test
    @DisplayName("Строка из пробелов")
    void spacedString() {
        //given
        String str = "   ";

        //when
        String result = Task4.fixString(str);

        //then
        assertThat(result)
            .isEqualTo("   ");
    }

    @Test
    @DisplayName("Пустая строка")
    void emptyString() {
        //given
        String str = "";

        //when
        String result = Task4.fixString(str);

        //then
        assertThat(result)
            .isEqualTo("");
    }

    @Test
    @DisplayName("Null string")
    void nullString() {
        //given
        String str = null;

        //when
        String result = Task4.fixString(str);

        //then
        assertThat(result)
            .isEqualTo(null);
    }

    @Test
    @DisplayName("1 символ")
    void singleCharacter() {
        //given
        String str = "к";

        //when
        String result = Task4.fixString(str);

        //then
        assertThat(result)
            .isEqualTo("к");
    }
}
