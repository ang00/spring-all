package com.em.springdatasqlite.jpa;

import com.em.springdatasqlite.entity.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/16 14:48:04
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(value = "select min(id) from Person ")
    @Transactional(readOnly = true)
    long findMinId();

    @Transactional(readOnly = true)
    @Query(value = "select max(id) from Person ")
    long findMaxId();

    @Transactional(readOnly = true)
    List<Person> findByIdGreaterThan(Long id, Pageable pageable);
}
