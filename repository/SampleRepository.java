package com.example.demo.repository;

import com.example.demo.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SampleRepository extends JpaRepository<SampleEntity,Integer> {

    @Query(nativeQuery = true,value="select * from sb_table1 where first_name=?")
    //-- @Query(value="select ref from SampleEntity ref where ref.first_name=:name")
    //-- @Query(value = "select * from SampleEntity ref")
    List<SampleEntity> demo(String name);

    @Modifying
    @Query(nativeQuery = true,value="delete from sb_table1 where first_name=?")
    void deleteByName(String name);

    @Query(nativeQuery = true,value="select * from sb_table1 where first_name like %?%")
    //-- @Query(value="select re from SampleEntity re where re.first_name like %:firstname%")
    //-- @Query(name="like_name")
    List<SampleEntity> listQuery(@Param("firstname") String firstname);

    //@Query(nativeQuery = true,value="select count(*) from sb_table1")
    //@Query(value="select count(*) from SampleEntity ref_name")
    @Query(name="total")
    int countdata();
}
