package org.example.common.subStringUtils;

import org.example.common.substring.SubStringUtils;
import org.junit.Test;

public class SubStringUtilsTest {
    @Test
    public void subTextTest() {
        String text = "a加b等于c，如果a等1、b等于2，那么c等3";
        try {
            String subTextUTF8 = SubStringUtils.subText(text, 6, "utf-8");
            System.out.println("UTF-8：" + subTextUTF8);
            String substring = text.substring(0, 6);
            System.out.println("subString：" + substring);
            String subTextGBK = SubStringUtils.subText(text, 6, "gbk");
            System.out.println("GBK：" + subTextGBK);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
