package com.jecyhw.mvc.service.impl;

import com.jecyhw.mvc.domain.Pest;
import com.jecyhw.mvc.repository.PestRepository;
import com.jecyhw.mvc.service.PestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jecyhw on 16-9-8.
 */
@Service
public class PestServiceImpl implements PestService {

    @Autowired
    PestRepository pestRepository;

    public void save(List<Pest> pests) {
        pestRepository.save(pests);
    }

    public void save(Pest pest) {
        pestRepository.save(pest);
    }

    public Pest findById(String id) {
        return pestRepository.findOne(id);
    }

    public List<Pest> findByIds(List<String> ids) {
        return pestRepository.findByIdIn(ids);
    }
}
