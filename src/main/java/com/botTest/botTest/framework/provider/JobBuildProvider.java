package com.botTest.botTest.framework.provider;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.builder.SimpleJobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class JobBuildProvider {
    final private JobBuilderFactory jobBuilderFactory;

    public Job buildJob(@NonNull String jobName, Step... steps) {
        return jobBuilderFactory.get(jobName)
                .start(steps[0])   // flow랑 리턴값이 다르네
                .build();
    }

   /* public Job buildJob(@NonNull String jobName, Step... steps){
        JobBuilder jobBuilder = this.jobBuilderFactory.get(jobName)
                .incrementer(new RunIdIncrementer());
                //.listener(this.jobExecutionListener);

        SimpleJobBuilder simpleJobBuilder = new SimpleJobBuilder(jobBuilder);

        List<Step> stepList = new ArrayList<>();
        if (steps.length == 0) {
            List<BatchJobStepVo> stepVos = this.batchService.getBatchJobStepList(jobName);
            for (BatchJobStepVo stepVo : stepVos) {
                stepList.add(this.stepBuildProvider.buildStep(stepVo));
            }
        } else {
            stepList.addAll(Arrays.asList(steps));
        }

        for (int i = 0; i < stepList.size(); i++) {
            Step step = stepList.get(i);

            simpleJobBuilder = i == 0 ? simpleJobBuilder.start(step) : simpleJobBuilder.next(step);
        }

        Job job = simpleJobBuilder.build();
        if (!this.registry.getJobNames().contains(jobName)) {
            log.info("ooo ooo ooo Job Name [{}] is null. Add Job Factory", jobName);

            ReferenceJobFactory factory = new ReferenceJobFactory(job);
            try {
                this.registry.register(factory);
            } catch (DuplicateJobException e) {
                // TODO 처리 필요.
            }
        }

        return job;
    }*/

}
