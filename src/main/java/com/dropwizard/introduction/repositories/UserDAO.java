package com.dropwizard.introduction.repositories;
import com.dropwizard.introduction.dao.mappers.BrandMapper;
import com.dropwizard.introduction.domain.Brand;

import java.util.List;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface BrandDAO {

    @SqlQuery("SELECT * FROM Brand")
    @Mapper(BrandMapper.class)
    public List<Brand> findAll();

}
