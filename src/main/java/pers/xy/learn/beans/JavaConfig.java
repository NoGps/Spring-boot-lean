package pers.xy.learn.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class JavaConfig {
    @Bean
    public Executor asyncExecutorTest(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        /** Set the ThreadPoolExecutor's core pool size. */
        executor.setCorePoolSize(1);
        /** Set the ThreadPoolExecutor's maximum pool size. */
        executor.setMaxPoolSize(10);
        /** Set the capacity for the ThreadPoolExecutor's BlockingQueue. */
        executor.setQueueCapacity(30);
        executor.setThreadNamePrefix("AsyncExecutor-Performance-");
        executor.initialize();
        return executor;
    }
}
