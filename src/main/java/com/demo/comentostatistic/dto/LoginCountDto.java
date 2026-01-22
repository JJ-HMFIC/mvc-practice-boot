package com.demo.comentostatistic.dto;

import lombok.Data;

@Data
public class LoginCountDto {
    private String key; // 날짜, 부서명 등 구분 값
    private int count; // 로그인 수
}
