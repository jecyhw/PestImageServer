package com.jecyhw.core.file;

import com.jecyhw.core.util.ObjectUtils;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import java.io.InputStream;
import java.util.UUID;

/**
 * GridFs文件操作类,保存、获取文件流,删除文件
 * Created by jecyhw on 16-11-1.
 */
public class GridFsFile implements FileOperations {

    private GridFsOperations gridFsOperations;

    public GridFsFile(GridFsOperations gridFsOperations) {
        this.gridFsOperations = gridFsOperations;

    }

    /**
     * @param fileId
     * @return 根据fileId获取mongodb中的文件流,不存在返回null
     */
    @Override
    public InputStream findByFileIdAsInputStream(String fileId) {
        GridFSDBFile fsdbFile = gridFsOperations.findOne(createQueryById(fileId));
        if (!ObjectUtils.isNull(fsdbFile)) {
            return fsdbFile.getInputStream();
        }
        return ObjectUtils.nullObj();
    }

    /**
     * 保存文件流到mongo gridfs中,返回文件在mongo gridfs的id
     * @param content
     * @return
     */
    @Override
    public String store(InputStream content) {
        return store(content, UUID.randomUUID().toString());
    }

    /**
     * 保存文件流到mongo gridfs中,返回文件在mongo gridfs的id
     * @param content
     * @param fileName 文件名
     * @return
     */
    @Override
    public String store(InputStream content, String fileName) {
        GridFSFile gridFSFile = gridFsOperations.store(content, fileName);
        return gridFSFile.getId().toString();
    }

    @Override
    public void delete(String fileId) {
        gridFsOperations.delete(createQueryById(fileId));
    }

    private Query createQueryById(String fileId) {
        return Query.query(Criteria.where("_id").is(fileId));
    }
}
