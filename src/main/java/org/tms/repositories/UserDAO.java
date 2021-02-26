package org.tms.repositories;
import org.tms.dao.datamodel.UserPojo;
import org.tms.dao.mappers.UserMapper;
import org.tms.domain.User;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface UserDAO {

    @SqlQuery("SELECT id, name FROM fullnames")
    @Mapper(UserMapper.class)
    List<User> findAll();      
    
    @SqlUpdate("INSERT INTO fullnames (name) VALUES (:columnName)")    
    void createFullNames(@Bind("columnName") String strFulname);
    
    //@SqlUpdate("TRUNCATE fullnames RESTART WITH 1")
    //ALTER SEQUENCE product_id_seq RESTART WITH 1453
    @SqlUpdate("TRUNCATE TABLE fullnames RESTART IDENTITY")
    void clearTableFullNames();
    
}
