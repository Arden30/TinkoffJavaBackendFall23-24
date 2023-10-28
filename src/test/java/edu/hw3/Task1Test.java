package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("Hello world!")
    void helloWorld() {
        String source = "Hello world!";
        String res = Task1.atbash(source);
        assertThat(res).isEqualTo("Svool dliow!");
    }

    @Test
    @DisplayName(
        "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler")
    void martinFowler() {
        String source =
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String res = Task1.atbash(source);
        assertThat(res).isEqualTo(
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
    }

    @Test
    @DisplayName("Not literals")
    void notLiterals() {
        String source = "__ !+1=09";
        String res = Task1.atbash(source);
        assertThat(res).isEqualTo("__ !+1=09");
    }

    @Test
    @DisplayName("Empty string")
    void emptyString() {
        String source = "";
        String res = Task1.atbash(source);
        assertThat(res).isEqualTo("");
    }

    @Test
    @DisplayName("Some symbols and different cases")
    void cases() {
        String source = "12HI21hi";
        String res = Task1.atbash(source);
        assertThat(res).isEqualTo("12SR21sr");
    }

    @Test
    @DisplayName("Null string")
    void nullStr() {
        String source = null;
        String res = Task1.atbash(source);
        assertThat(res).isEqualTo(null);
    }
}
