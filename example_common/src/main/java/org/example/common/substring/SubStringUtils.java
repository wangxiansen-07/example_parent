package org.example.common.substring;

import java.io.UnsupportedEncodingException;

/**
 * @Author: WangTao
 * @Date: 2023-02-02 22:28
 * @Version: 1.0
 * @Desc: 字符串截取工具
 */
public class SubStringUtils {
    /**
     * @param text:需要截取的文本
     * @param subLength:需要截取的长度
     * @param encoding:指定编码格式
     * @return :截取结果
     * @throws Exception
     */
    public static String subText(String text, int subLength, String encoding) throws UnsupportedEncodingException {
        int length = text.getBytes(encoding).length;
        if (length > subLength) {
            text = text.substring(0, text.length() - 1);
            text = subText(text, subLength, encoding);
        }
        return text;
    }
}
