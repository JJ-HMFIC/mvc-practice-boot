package com.demo.comentostatistic.service;

import com.demo.comentostatistic.dao.StatisticMapper;
import com.demo.comentostatistic.dto.LoginCountDto;
import com.demo.comentostatistic.dto.YearCountDto;
import com.demo.comentostatistic.dto.YearMonthCountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {


    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){

        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){

        return statisticMapper.selectYearMonthLogin(year+month);
    }


    //4주차 과제
    // 1. 월별 접속자 수
    public List<LoginCountDto> getMonthlyLogins() {
        return statisticMapper.selectMonthlyLoginCount();
    }

    // 2. 일자별 접속자 수
    public List<LoginCountDto> getDailyLogins() {
        return statisticMapper.selectDailyLoginCount();
    }

    // 3. 평균 하루 로그인 수
    public Double getAvgDailyLogins() {
        return statisticMapper.selectAvgDailyLoginCount();
    }

    // 4. 부서별 월별 로그인 수
    public List<LoginCountDto> getDeptMonthlyLogins() {
        return statisticMapper.selectDeptMonthlyLoginCount();
    }

    /**
     * 휴일을 제외한 로그인 수
     * SQL의 WHERE NOT IN을 쓰지 않고, Java 코드(Stream)로 필터링합니다.
     */
    public Long getLoginCountExcludingHolidays() {
        // A. 전체 로그인 기록 날짜를 가져오기
        List<String> allLoginDates = statisticMapper.selectAllLoginDates();

        // B. 휴일 목록을 DB에서 가져오기
        List<String> holidayDates = statisticMapper.selectHolidays();

        // C. 자바 스트림을 사용하여 필터링 (로그인 날짜가 휴일 목록에 없으면 카운트)
        long count = allLoginDates.stream()
                .filter(date -> !holidayDates.contains(date)) // 휴일 목록에 포함되지 않은 날짜만 남김
                .count();

        return count;
    }


}
