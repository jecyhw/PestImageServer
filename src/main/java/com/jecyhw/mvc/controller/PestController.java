package com.jecyhw.mvc.controller;

import com.jecyhw.core.file.FileOperations;
import com.jecyhw.core.recognition.RecognitionTemplate;
import com.jecyhw.core.response.Response;
import com.jecyhw.core.upload.PictureFile;
import com.jecyhw.core.upload.RecognitionFile;
import com.jecyhw.core.util.ObjectUtils;
import com.jecyhw.core.validation.ValidationMessageCodeResolver;
import com.jecyhw.mvc.domain.Pest;
import com.jecyhw.mvc.domain.Picture;
import com.jecyhw.mvc.service.PestService;
import com.jecyhw.mvc.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jecyhw on 16-10-28.
 */
@RestController
@RequestMapping(value = "pest")
public class PestController{

    @Autowired
    PictureService pictureService;

    @Autowired
    ValidationMessageCodeResolver validationMessageCodeResolver;

    @Autowired
    PestService pestService;

    @Autowired
    RecognitionTemplate recognitionTemplate;

    @Autowired
    @Qualifier("localFile")
    FileOperations fileOperations;

    @RequestMapping(value = "upload/{id}", method = RequestMethod.POST)
    public Response<?> upload(@PathVariable("id") String pestId, PictureFile pictureFile) {
        Pest pest = pestService.findById(pestId);
        if (ObjectUtils.isNull(pest)) {
            return Response.notFound("未找到图片的所属记录");
        }
        Picture picture =  pictureService.create(pictureFile);
        if (ObjectUtils.isNull(picture)) {
            return Response.fail("图片保存失败");
        }
        List<Picture> pictures = pest.getPictures();
        if (ObjectUtils.isNull(pictures)) {
            pictures = new ArrayList<>();
            pest.setPictures(pictures);
        }
        pictures.add(picture);
        pestService.save(pest);
        return Response.success(picture);
    }

    @RequestMapping(value = "recognition", method = RequestMethod.POST)
    public Response<?> recognition(RecognitionFile recognitionFile, @RequestParam(required = false) Integer limit) {
        try {
            String picturePath = recognitionFile.store(fileOperations);
            List<String> ids = recognitionTemplate.recognition(picturePath, ObjectUtils.isNull(limit) ? 0 : limit);
            List<Pest> pests = pestService.findByIds(ids);
            return Response.success(pests);
        } catch (IOException e) {
            return Response.fail("图片识别失败");
        }
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Response<?> create(@RequestBody @Valid Pest pest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Response.createFail(validationMessageCodeResolver.bindingResultToSimple(bindingResult));
        }
        pestService.save(pest);
        return Response.success(pest);
    }

    @RequestMapping(value = "pictures/{pestId}", method = { RequestMethod.GET })
    public Response<?> pictures(@PathVariable String pestId) {
        Pest pest = pestService.findById(pestId);
        if (ObjectUtils.isNull(pest)) {
            return Response.notFound("未找到记录");
        } else {
            return Response.success(pest.getPictures());
        }
    }
}
