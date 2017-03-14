package com.jecyhw.core.recognition;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RecognitionTemplate Tester.
 *
 * @author <Authors name>
 * @since <pre>十一月 29, 2016</pre>
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecognitionTemplateTest {

    @Autowired
    RecognitionTemplate recognitionTemplate;
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: recognition(String picturePath)
     *
     */
    @Test
    public void testRecognition() throws Exception {
    }
}
