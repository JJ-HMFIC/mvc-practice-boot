package com.demo.comentostatistic.controller;

import com.demo.comentostatistic.dto.LoginCountDto;
import com.demo.comentostatistic.dto.YearCountDto;
import com.demo.comentostatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatisticController {

    @Autowired
    StatisticService statisticService;


    @RequestMapping(value="/api/v1/logins/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year){

        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthLoginCount(@PathVariable("year") String year, @PathVariable("month") String month){

        return ResponseEntity.ok(statisticService.getYearMonthLogins(year, month));
    }

    //4주차 과제
    // 1. 월별 접속자 수 API
    @GetMapping("/api/v1/logins/monthly")
    public ResponseEntity<List<LoginCountDto>> getMonthlyLoginCount() {
        return ResponseEntity.ok(statisticService.getMonthlyLogins());
    }

    // 2. 일자별 접속자 수 API
    @GetMapping("/api/v1/logins/daily")
    public ResponseEntity<List<LoginCountDto>> getDailyLoginCount() {
        return ResponseEntity.ok(statisticService.getDailyLogins());
    }

    // 3. 평균 하루 로그인 수 API
    @GetMapping("/api/v1/logins/average")
    public ResponseEntity<Double> getAvgDailyLoginCount() {
        return ResponseEntity.ok(statisticService.getAvgDailyLogins());
    }

    // 4. 부서별 월별 로그인 수 API
    @GetMapping("/api/v1/logins/department")
    public ResponseEntity<List<LoginCountDto>> getDeptMonthlyLoginCount() {
        return ResponseEntity.ok(statisticService.getDeptMonthlyLogins());
    }

    // 5. 휴일을 제외한 로그인 수 API
    @GetMapping("/api/v1/logins/exclude-holiday")
    public ResponseEntity<Long> getLoginCountExcludeHoliday() {
        return ResponseEntity.ok(statisticService.getLoginCountExcludingHolidays());
    }
}
