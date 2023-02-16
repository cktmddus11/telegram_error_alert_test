package com.botTest.botTest.telegram.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@Setter
public class ApiErrorDao {

    private String apiNm;
    private String apiNo;
    private String spNm;
    private String rstCd;
    private String rstMsg;
    private int cnt;
    private LocalDateTime lstAccral;

    @Override
    public String toString() {
        return String.format("(%s | %s) \n" +
                "에러코드 : %s, 발생건수 : %d \n" +
                "=> 에러내용 [%s] \n", apiNo, apiNm, rstCd, cnt, rstMsg);

    }
}

/*

API 에러발생
PNTS_1012/마일리지 적립 | 999 => 인덱스에러로인안에러 ㄴㅁ아럼ㄴ앎ㄻㄴasdfasdfasdfaskjsadfs ㄸ아럼ㅇ럼ㄴ이ㅏ럼ㅇㄴ라ㅣㄴ어 */
