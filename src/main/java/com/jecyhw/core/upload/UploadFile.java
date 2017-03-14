package com.jecyhw.core.upload;

import com.jecyhw.core.file.FileOperations;
import com.jecyhw.core.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传文件抽象类
 * Created by jecyhw on 16-11-2.
 */

abstract public class UploadFile<T> {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     *
     * @param operations 用来保存上传文件的操作接口
     * @return 返回文件的索引
     * @throws IOException
     */
    public String store(FileOperations operations) throws IOException {
        return operations.store(getFile().getInputStream());
    }

    /**
     * 将store和transfer操作合并
     * @param operations
     * @return 文件保存失败将返回null
     */
    public T storeThenTransfer(FileOperations operations) {
        try {
            return transfer(store(operations));
        } catch (IOException e) {
            return ObjectUtils.nullObj();
        }
    }
    /**
     * 上传文件映射到具体的pojo上
     * @return
     */
    abstract public T transfer(String fileId);
}
