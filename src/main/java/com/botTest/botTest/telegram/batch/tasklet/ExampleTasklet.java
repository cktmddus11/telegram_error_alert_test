package com.botTest.botTest.telegram.batch.tasklet;

import com.botTest.botTest.telegram.api.TelegramApiClient;
import com.botTest.botTest.telegram.model.ApiErrorDao;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@Getter
@Setter
@RequiredArgsConstructor
@StepScope
public class ExampleTasklet implements Tasklet {

    private final TelegramApiClient telegramApiClient;

    @Value("${telegram.token}")
    private String token;

    @Value("${telegram.chatId}")
    private String chatId;


  /*  public ExampleTasklet(TelegramApiClient telegramApiClient) {
        this.telegramApiClient = telegramApiClient;
    }*/

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("send message start");

        List<ApiErrorDao> apiErrorDaoList = getApiErrorList();
        if(apiErrorDaoList.isEmpty()){
            return RepeatStatus.FINISHED;
        }

        String textMessage = makeSendMessage(apiErrorDaoList);

        log.info("telegram.token: " + this.token);
        log.info("telegram.chatId: " + this.chatId);

        log.info("send Message : " + textMessage);

       // telegramApiClient.sendMessage(token, textMessage, chatId);
        telegramApiClient.sendMessage("A", textMessage, "B");


        log.info("send message finished");

        return RepeatStatus.FINISHED;
    }

    private String makeSendMessage(List<ApiErrorDao> apiErrorDaoList) {
        String textMessage = ">>> api에러발생\n ";
        textMessage += apiErrorDaoList.stream().map(ApiErrorDao::toString)
                .collect(Collectors.joining("\n"));
        return textMessage;
    }

    private List<ApiErrorDao> getApiErrorList() {
        List<ApiErrorDao> apiErrorDaoList = new ArrayList<>();
        ApiErrorDao apiErrorDao1 = ApiErrorDao.builder()
                .apiNm("마일리지 적립")
                .apiNo("PNTS_1012")
                .spNm("SP_LOY_TME_PSDF_SDFDS")
                .rstCd("999")
                .rstMsg("인덱스에러로인안에러 ㄴㅁ아럼ㄴ앎ㄻㄴasdfasdfasdfaskjsadfs ㄸ아럼ㅇ럼ㄴ이ㅏ럼ㅇㄴ라ㅣㄴ어")
                .lstAccral(LocalDateTime.now())
                .cnt(99)
                .build();
        apiErrorDaoList.add(apiErrorDao1);

        ApiErrorDao apiErrorDao2 = ApiErrorDao.builder()
                .apiNm("마일리지 적립")
                .apiNo("PNTS_1012")
                .spNm("SP_LOY_TME_PSDF_SDFDS")
                .rstCd("999")
                .rstMsg("인덱스에러로인안에러 ㄴㅁ아럼ㄴ앎ㄻㄴasdfasdfasdfaskjsadfs ㄸ아럼ㅇ럼ㄴ이ㅏ럼ㅇㄴ라ㅣㄴ어")
                .lstAccral(LocalDateTime.now())
                .cnt(10)
                .build();
        apiErrorDaoList.add(apiErrorDao2);


    return apiErrorDaoList;
    }
}
