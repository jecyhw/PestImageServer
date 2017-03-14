package com.jecyhw.core.upload;

import com.jecyhw.core.file.FileOperations;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by jecyhw on 16-11-23.
 */
public class RecognitionFile extends UploadFile<String> {
    /**
     * 不支持该操作
     * @param fileId
     * @return
     */
    @Override
    public String transfer(String fileId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String store(FileOperations operations) throws IOException {
        int index = getFile().getOriginalFilename().indexOf(".");
        String fileName = UUID.randomUUID().toString() + (index > -1 ? getFile().getOriginalFilename().substring(index) : ".jpg");
        return operations.store(getFile().getInputStream(), fileName);
    }
}
