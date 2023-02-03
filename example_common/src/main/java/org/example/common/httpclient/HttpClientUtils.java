package org.example.common.httpclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: WangTao
 * @Date: 2023-02-02 22:33
 * @Version: 1.0
 * @Desc: 发送Http请求工具类
 */
public class HttpClientUtils {
    public static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
    public static final int DEFAULT_SOCKET_TIMEOUT = 15000;
    public static final int DEFAULT_CONNECT_TIMEOUT = 6000;

    /**
     * Http发送Get请求
     */
    public static String sendGetRequest(String url, int socketTimeout, int connectTimeout) {
        // 创建Get请求
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        // 设置请求头
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
        httpGet.setConfig(requestConfig);
        // 响应模型
        CloseableHttpResponse response = null;
        String result = "";
        try {
            // 由客户端执行(发送)Get请求
            response = client.execute(httpGet);
            // 处理响应结果
            result = validation(response, url);
        } catch (IOException e) {
            logger.error("GET请求出错, url = {}", url, e);
        } finally {
            close(client, response);
        }
        return result;
    }

    /**
     * Http发送Post请求
     */
    public static String sendPostRequest(String url, String jsonData, int socketTimeout, int connectTimeout) {
        // 创建Post请求
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        // 设置请求头
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
        httpPost.setConfig(requestConfig);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.setHeader("Accept", "application/json");

        // 设置请求体
        StringEntity entity = new StringEntity(jsonData, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);

        // 响应模型
        CloseableHttpResponse response = null;
        String result = "";
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 处理响应结果
            result = validation(response, url);
        } catch (Exception e) {
            logger.error("请求出错, url = {}", url, e);
        } finally {
            close(httpClient, response);
        }
        return result;
    }

    /**
     * 响应信息处理
     */
    private static String validation(CloseableHttpResponse response, String url) {
        String result = "";
        if (response != null && response.getStatusLine() != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            try {
                // 读取服务器返回过来的json字符串数据
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
                logger.info("接口 {} 响应数据====== {} =====", url, result);
            } catch (Exception e) {
                logger.error("POST请求出错, url = {}", url, e);
            }
        }
        return result;
    }

    /**
     * 判断是否为Ajax请求
     * header = request.getHeader("X-Requested-With");
     */
    public static boolean isAjaxRequest(String header) {
        String requestWith = "XMLHttpRequest";
        if (requestWith.equals(header)) {
            return true;
        }
        return false;
    }

    /**
     * 释放资源
     */
    private static void close(CloseableHttpClient httpClient, CloseableHttpResponse httpResponse) {
        try {
            if (httpClient != null) {
                httpClient.close();
            }
            if (httpResponse != null) {
                httpResponse.close();
            }
        } catch (IOException e) {
            logger.error("释放资源出错,  原因 {}", e.getLocalizedMessage());
        }
    }
}
