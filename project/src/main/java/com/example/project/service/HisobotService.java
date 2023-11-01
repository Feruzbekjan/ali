package com.example.project.service;


import com.example.project.entity.Hisobot;
import com.example.project.entity.Xodim;
import com.example.project.repository.HisobotRepsitory;
import com.example.project.repository.XodimRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;


@Service
public class HisobotService {
private final   HisobotRepsitory hisobotRepsitory;
private final XodimRepository xodimRepository;


  public HisobotService(HisobotRepsitory hisobotRepsitory, XodimRepository xodimRepository) {
    this.hisobotRepsitory = hisobotRepsitory;
    this.xodimRepository = xodimRepository;
  }

  public Double oyliklar(Long id) {
    Xodim xodim = xodimRepository.findById(id).orElse(null);

    if (xodim == null) {
      return 0d;
    }

    double dailySalary = xodim.getMaoshi() / 30;
    List<Hisobot> hisobots = hisobotRepsitory.findByXodimId(id);
    int totalWorkDays = hisobots.size();
    int totalLateDays = 0;
    for (Hisobot hisobot : hisobots) {
      LocalDateTime checkInTime = hisobot.getKelishvaqti();
      LocalDateTime expectedCheckInTime = checkInTime.withHour(8).withMinute(0).withSecond(0);
      if (checkInTime.isAfter(expectedCheckInTime)) {
        totalLateDays++;
      }
    }

    int totalAbsentDays = 30 - totalWorkDays;
    double monthlySalary = (totalWorkDays * dailySalary) - (totalLateDays * dailySalary) - (totalAbsentDays * dailySalary);

    return monthlySalary;
  }



  public Map<String, Integer> oylikstatistika() {
    Map<String, Integer> monthlyStatistics = new HashMap<>();

    List<Xodim> xodims = xodimRepository.findAll();
    for (Xodim xodim : xodims) {
     List<Hisobot> timeSheetsz = hisobotRepsitory.findByXodimId(xodim.getId());
      int workedDays = timeSheetsz.size();
      monthlyStatistics.put(String.valueOf(xodim.getPasport()), workedDays);
    }

    return monthlyStatistics;
  }



  public List<Map<String, Object>> getIshXodimlar() {
    List<Map<String, Object>> ishchilar = new ArrayList<>();
    LocalDate currentDate = LocalDate.now();
    LocalDate startOfMonth = currentDate.withDayOfMonth(1);
    LocalDate endOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());

    List<Xodim> xodims = xodimRepository.findAll();
    for (Xodim xodim : xodims) {
      List<Hisobot> timeSheets = hisobotRepsitory.findByEmployeeIdAndCheckInTimeBetween(xodim.getId(), startOfMonth.atStartOfDay(), endOfMonth.atTime(LocalTime.MAX));
      if (!timeSheets.isEmpty()) {
        Map<String, Object> employeeData = new HashMap<>();
        employeeData.put("employee", xodim);
        employeeData.put("workedDays", timeSheets.size());
        ishchilar.add(employeeData);
      }
    }

    return ishchilar;
  }



  public List<Map<String, Object>> kechqolganlar() {
    List<Map<String, Object>> kechqolgan = new ArrayList<>();
    LocalTime currentTime = LocalTime.now();
    LocalDate currentDate = LocalDate.now();
    LocalDate previousDate = currentDate.minusDays(1);

    List<Xodim> employees = xodimRepository.findAll();
    for (Xodim employee : employees) {
      List<Hisobot> timeSheets = hisobotRepsitory.findByEmployeeIdAndCheckInTimeBetween(employee.getId(), previousDate.atTime(LocalTime.MIN), currentDate.atTime(currentTime.minusMinutes(15)));
      if (timeSheets.isEmpty()) {
        Map<String, Object> employeeData = new HashMap<>();
        employeeData.put("employee", employee);
        kechqolgan.add(employeeData);
      }
    }

    return kechqolgan;
  }

}

