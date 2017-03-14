package com.jecyhw.mvc.service;

import com.jecyhw.core.upload.UploadFile;
import com.jecyhw.mvc.domain.Picture;

import java.io.InputStream;

/**
 * Created by jecyhw on 16-11-3.
 */
public interface PictureService {

    /**
     * @param uploadFile
     * @return 对上传图片进行保存,并返回图片的相关信息
     */
    Picture create(UploadFile<Picture> uploadFile);

    /**
     * @param fileId
     * @return 根据图片的id获取图片流
     */
    InputStream findByFileIdAsInputStream(String fileId);
}
