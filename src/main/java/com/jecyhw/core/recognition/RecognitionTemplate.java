package com.jecyhw.core.recognition;

import com.jecyhw.core.util.ObjectUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jecyhw on 16-11-29.
 */
public class RecognitionTemplate {

    private static final Logger logger = LoggerFactory.getLogger(RecognitionTemplate.class);
    private static final Pattern ID_PATTERN = Pattern.compile("[a-z0-9A-Z]{24}");
    private static final int LIMIT = 5;
    private String pyPath;

    public RecognitionTemplate(String pyPath) {
        this.pyPath = pyPath;
    }

    public List<String> recognition(String picturePath, int limit) {
        if (limit <= 0) {
            limit = LIMIT;
        }
        List<String> result = new ArrayList<>();
        try {
            String command = String.format("python %s %s", pyPath, picturePath);
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while (!ObjectUtils.isNull(line = bufferedReader.readLine())) {
                builder.append(line);
            }
            bufferedReader.close();
            Matcher matcher = ID_PATTERN.matcher(builder.toString());
            int count = 0;
            while (matcher.find()) {
                result.add(matcher.group());
                ++count;
                if (count >= limit) {
                    break;
                }
            }
            logger.debug(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileUtils.deleteQuietly(new File(picturePath));
        }
        return result;
    }
}
