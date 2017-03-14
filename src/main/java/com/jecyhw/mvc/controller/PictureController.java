package com.jecyhw.mvc.controller;

import com.jecyhw.core.util.ObjectUtils;
import com.jecyhw.mvc.service.PictureService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jecyhw on 16-11-3.
 */
@RestController
@RequestMapping(value = "picture")
public class PictureController {

    @Autowired
    PictureService pictureService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> picture(@PathVariable("id") String fileId) throws IOException {
        InputStream in = pictureService.findByFileIdAsInputStream(fileId);
        if (!ObjectUtils.isNull(in)) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(IOUtils.toByteArray(in));
        }
        return new ResponseEntity<>("未找到图片", HttpStatus.NOT_FOUND);
    }
}
