package com.jecyhw.config.gridfs;

import com.jecyhw.core.file.GridFsFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

/**
 * Created by jecyhw on 16-11-21.
 */
@Configuration
public class GridFsConfig {
    @Bean
    public GridFsFile gridFsFile(GridFsOperations gridFsOperations) {
        return new GridFsFile(gridFsOperations);
    }
}
