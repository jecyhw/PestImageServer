package com.jecyhw.mvc.repository;


import com.jecyhw.mvc.domain.Pest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by jecyhw on 16-9-6.
 */
public interface PestRepository  extends MongoRepository<Pest, String> {
    List<Pest> findByIdIn(Collection ids);
}
