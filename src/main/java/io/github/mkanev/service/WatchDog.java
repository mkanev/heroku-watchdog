package io.github.mkanev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.github.mkanev.common.LoggedClass;

/**
 * @author <a href="mailto:maksim.kanev@waveaccess.ru">Maksim Kanev</a>
 */
@Component
public class WatchDog extends LoggedClass {

    private final int POOL_SIZE = 25;
    @Autowired
    @Qualifier("myExecutor")
    private TaskExecutor taskExecutor;

    @Scheduled(fixedDelay = 100)
    public void poll() {
        for (int i = 0; i < POOL_SIZE; i++) {
            taskExecutor.execute(new WatchUnit());
        }
    }
}
