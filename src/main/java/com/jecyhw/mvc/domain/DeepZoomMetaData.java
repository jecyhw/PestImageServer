package com.jecyhw.mvc.domain;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by jecyhw on 16-10-28.
 */
final public class DeepZoomMetaData {
    /**
     * pivotViewer的DeepZoom的展示封面图的id
     */
    @Field("file_id")
    private String fileId;

    /**
     * 图片的宽
     */
    private Integer width;

    /**
     * 图片的高
     */
    private Integer height;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
