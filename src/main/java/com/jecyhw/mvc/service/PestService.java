package com.jecyhw.mvc.service;

import com.jecyhw.mvc.domain.Pest;

import java.util.List;

/**
 * Created by jecyhw on 16-9-8.
 */
public interface PestService {
    void save(List<Pest> pests);

    void save(Pest pest);

    Pest findById(String id);

    List<Pest> findByIds(List<String> ids);
}
