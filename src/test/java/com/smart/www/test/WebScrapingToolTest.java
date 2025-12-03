package com.smart.www.test;

import com.smart.www.tools.WebScrapingTool;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WebScrapingToolTest {

    @Test
    public void testScrapeWebPage() {
        WebScrapingTool tool = new WebScrapingTool();
        String url = "http://210.38.224.229/suzhi/index.jsp";
        String result = tool.scrapeWebPage(url);
        assertNotNull(result);
    }
}
