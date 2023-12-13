package edu.hw6.task5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @Test
    @DisplayName("Test 1 (hackerNewsTopStories)")
    void test1() {
        HackerNews hackerNews = new HackerNews();
        long[] res = hackerNews.hackerNewsTopStories();
        assertThat(res.length).isGreaterThan(400);
    }

    @Test
    @DisplayName("Test 2 (news)")
    void test2() {
        HackerNews hackerNews = new HackerNews();
        String expected = "\"JDK 21 Release Notes\"";
        String res = hackerNews.news(37570037);
        assertThat(res).isEqualTo(expected);
    }
}
