package com.example.project.repository;

import com.example.project.entity.Hisobot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HisobotRepsitory extends JpaRepository<Hisobot,Long> {
    List<Hisobot> findAllByCheckInTimeBetween(LocalDateTime localDateTime, LocalDateTime localDateTime1);

    List<Hisobot> findByEmployeeIdAndCheckInTimeBetween(Long id, LocalDateTime localDateTime, LocalDateTime localDateTime1);
    List<Hisobot> findByXodimId(Long id);
}
