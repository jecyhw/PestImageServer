package com.jecyhw.config.recognition;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

/**
 * Created by jecyhw on 16-11-23.
 */
@ConfigurationProperties(prefix = "image.recognition")
public class RecognitionProperties {
    /**
     * python file's path
     */
    @NotNull
    private String pyPath;

    /**
     * recognition image upload directory
     */
    @NotNull
    private String uploadPath;

    public String getPyPath() {
        return pyPath;
    }

    public void setPyPath(String pyPath) {
        this.pyPath = pyPath;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
