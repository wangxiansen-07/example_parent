package org.example.common.httpclient;

import org.junit.Test;

public class HttpClientUtilsTest {

    @Test
    public void sendGetRequestTest() {
        String result = HttpClientUtils.sendGetRequest("https://www.baidu.com", 15000, 6000);
        System.out.println(result);
    }
}
