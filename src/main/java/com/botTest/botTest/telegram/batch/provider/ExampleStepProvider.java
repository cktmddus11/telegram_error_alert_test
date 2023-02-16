package com.botTest.botTest.telegram.batch.provider;

import com.botTest.botTest.framework.provider.StepBuildProvider;
import com.botTest.botTest.telegram.api.TelegramApiClient;
import com.botTest.botTest.telegram.batch.tasklet.ExampleTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExampleStepProvider {
    private final StepBuildProvider stepBuildProvider;
    private final TelegramApiClient telegramApiClient;


    public Step tutorialStep(){
        return stepBuildProvider.buildStep("exampleStep", new ExampleTasklet(telegramApiClient));
    }

}
