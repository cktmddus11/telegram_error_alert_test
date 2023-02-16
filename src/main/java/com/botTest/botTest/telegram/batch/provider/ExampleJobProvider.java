package com.botTest.botTest.telegram.batch.provider;

import com.botTest.botTest.framework.provider.JobBuildProvider;
import com.botTest.botTest.framework.provider.StepBuildProvider;
import com.botTest.botTest.telegram.api.TelegramApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
@RequiredArgsConstructor
@Component
public class ExampleJobProvider {
    private final JobBuildProvider jobBuildProvider;
    private final ExampleStepProvider exampleStepProvider;

    @Bean
    public Job tutorialJob(){
        return jobBuildProvider.buildJob("exampleJob", this.exampleStepProvider.tutorialStep());
    }

}
