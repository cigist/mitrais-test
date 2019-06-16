package com.irwan.mitrais.repository;

import com.irwan.mitrais.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by cigist on 15/06/19.
 */
public interface RegisterRepository extends JpaRepository<Register,Integer>{
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Register c where c.phoneNumber = :phone")
    boolean findByPhone(@Param("phone") String phone);
}
