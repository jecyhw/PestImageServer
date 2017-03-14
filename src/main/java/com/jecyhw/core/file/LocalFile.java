package com.jecyhw.core.file;

import com.jecyhw.core.util.ObjectUtils;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by jecyhw on 16-11-29.
 */
public class LocalFile implements FileOperations{

    private final String uploadPath;

    public LocalFile(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @Override
    public String store(InputStream content) {
        return store(content, UUID.randomUUID().toString() + ".jpg");
    }

    /**
     保存成功,返回文件所在的全路径;保存失败,返回null
     * @param content
     * @param fileName 要保存的文件名
     * @return
     */
    @Override
    public String store(InputStream content, String fileName) {
        File file = Paths.get(uploadPath, fileName).toFile();
        try {
            FileUtils.copyInputStreamToFile(content, file);
            return file.getAbsolutePath();
        } catch (IOException e) {
            return ObjectUtils.nullObj();
        }
    }

    /**
     * 根据文件的全路径返回文件流,不存在返回null
     * @param filePath
     * @return
     */
    @Override
    public InputStream findByFileIdAsInputStream(String filePath) {
        try {
            return new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            return ObjectUtils.nullObj();
        }
    }

    /**
     * 根据文件路径删除文件
     * @param filePath
     */
    @Override
    public void delete(String filePath) {
        FileUtils.deleteQuietly(new File(filePath));
    }
}
