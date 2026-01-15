package com.demo.comentostatistic.service;

import com.demo.comentostatistic.dao.StatisticMapper;
import com.demo.comentostatistic.dto.YearCountDto;
import com.demo.comentostatistic.dto.YearMonthCountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
