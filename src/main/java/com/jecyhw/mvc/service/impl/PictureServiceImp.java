package com.jecyhw.mvc.service.impl;

import com.jecyhw.core.file.GridFsFile;
import com.jecyhw.core.upload.UploadFile;
import com.jecyhw.mvc.domain.Picture;
import com.jecyhw.mvc.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Created by jecyhw on 16-11-3.
 */
@Service
public class PictureServiceImp implements PictureService {

    @Autowired
    GridFsFile gridFsFile;

    @Override
    public Picture create(UploadFile<Picture> uploadFile) {
        return uploadFile.storeThenTransfer(gridFsFile);
    }

    @Override
    public InputStream findByFileIdAsInputStream(String fileId) {
        return gridFsFile.findByFileIdAsInputStream(fileId);
    }
}
