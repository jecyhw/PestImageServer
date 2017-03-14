package com.jecyhw.core.upload;


import com.jecyhw.mvc.domain.Picture;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 上传文件是图片
 * Created by jecyhw on 16-11-3.
 */
public class PictureFile extends UploadFile<Picture> {

    /**
     * 图片标题
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Picture transfer(String fileId) {
        Picture picture = new Picture();
        picture.setTitle(getTitle());
        picture.setFileId(fileId);
        try {
            picture.setName(URLDecoder.decode(getFile().getOriginalFilename(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return picture;
    }
}
