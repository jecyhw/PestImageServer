package com.jecyhw.mvc.domain;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by jecyhw on 16-10-28.
 */
final public class Picture {
    /**
     *  图片在mongo数据库的文件索引,引用的fs.files的_id
     */
    @Field("file_id")
    private String fileId;

    /**
     * 图片名
     */
    private String name;

    /**
     * 图片标题
     */
    private String title;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Picture)) return false;

        Picture picture = (Picture) o;

        if (getFileId() != null ? !getFileId().equals(picture.getFileId()) : picture.getFileId() != null) return false;
        return getTitle() != null ? getTitle().equals(picture.getTitle()) : picture.getTitle() == null;

    }

    @Override
    public int hashCode() {
        int result = getFileId() != null ? getFileId().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        return result;
    }
}
