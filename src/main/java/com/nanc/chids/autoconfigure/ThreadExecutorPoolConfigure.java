package com.nanc.chids.autoconfigure;

import org.springframework.aop.interceptor.AsyncExecutionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ThreadExecutorPoolConfigure {

    @Bean("testThreadPool")
    public ThreadPoolTaskExecutor getThreadPoolExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setQueueCapacity(1024);
        threadPoolTaskExecutor.setCorePoolSize(2);
        threadPoolTaskExecutor.setMaxPoolSize(4);
        threadPoolTaskExecutor.setThreadNamePrefix("SpringSettingExecutorThread");
        threadPoolTaskExecutor.setKeepAliveSeconds(2);
        //一旦设置了这个core线程也是会推出的
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        return threadPoolTaskExecutor;
    }
}
