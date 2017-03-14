package com.jecyhw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PestImageServerApplicationTests {

    @Test
    public void contextLoads() {
        try {
            System.out.println(URLDecoder.decode("山东省", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
