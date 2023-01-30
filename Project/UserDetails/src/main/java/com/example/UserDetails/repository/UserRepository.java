package com.example.UserDetails.repository;

import com.example.UserDetails.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.MonthDay;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>
    {
        @Query(value = "select * from userdetail ud where ud.day_month= ?1", nativeQuery = true)
        Optional<UserEntity> findByDate(Date birthday);

        @Query(value =  "select email from userdetail where to_char(CURRENT_DATE, 'MM-dd')=to_char(day_month, 'MM-dd')",nativeQuery = true)
        List<String> findAllByDayMonth();
    }
