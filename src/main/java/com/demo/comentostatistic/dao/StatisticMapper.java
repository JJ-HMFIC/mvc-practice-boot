package com.demo.comentostatistic.dao;

import com.demo.comentostatistic.dto.LoginCountDto;
import com.demo.comentostatistic.dto.YearCountDto;
import com.demo.comentostatistic.dto.YearMonthCountDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(String yearMonth);

    //4주차 과제
    List<LoginCountDto> selectMonthlyLoginCount();
    List<LoginCountDto> selectDailyLoginCount();
    Double selectAvgDailyLoginCount();
    List<LoginCountDto> selectDeptMonthlyLoginCount();

    // Java 로직 처리를 위한 원시 데이터 조회
    List<String> selectAllLoginDates();
    List<String> selectHolidays();

}