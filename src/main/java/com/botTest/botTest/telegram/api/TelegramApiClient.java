package com.botTest.botTest.telegram.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="telegram",url="https://api.telegram.org")

public interface TelegramApiClient {
    @GetMapping(value="/bot{token}/sendMessage")
    Object sendMessage(@PathVariable("token") String token
            , @RequestParam("text") String text
            , @RequestParam("chat_id") String chatId);
}
