package com.demo.comentostatistic.dao;

import com.demo.comentostatistic.dto.YearCountDto;
import com.demo.comentostatistic.dto.YearMonthCountDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(String yearMonth);

}