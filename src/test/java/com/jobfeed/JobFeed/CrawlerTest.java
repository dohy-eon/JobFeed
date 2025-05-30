package com.jobfeed.JobFeed;

import com.jobfeed.JobFeed.domain.crawler.JobKoreaCrawler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CrawlerTest {

    @Autowired
    private JobKoreaCrawler jobKoreaCrawler;

    @Test
    @DisplayName("JobKorea 채용 공고 개수를 정상적으로 가져온다")
    void testGetJobCount() {
        // given
        Map<String, Object> condition = new HashMap<>();
        condition.put("keyword", "금융");  // ✅ 실제 Crawler에서 요구하는 key
        condition.put("local", "부산");  // ✅ 지역 코드로 바꿔야 할 수도 있음

        // when & then
        assertDoesNotThrow(() -> {
            int count = jobKoreaCrawler.getJobCount(condition);
            System.out.println("채용 공고 개수: " + count);
            assertTrue(count >= 0, "채용 공고 개수는 0 이상이어야 합니다.");
        });
    }
}
