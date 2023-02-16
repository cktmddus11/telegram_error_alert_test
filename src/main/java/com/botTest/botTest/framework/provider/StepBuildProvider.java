package com.botTest.botTest.framework.provider;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class StepBuildProvider {
    final private StepBuilderFactory stepBuilderFactory;

    public Step buildStep(@NonNull String step, Tasklet taskletk) {
        return stepBuilderFactory.get(step)
                .tasklet(taskletk)
                .build();
    }

}
