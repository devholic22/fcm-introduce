package devholic.fcm_demo.alert.application;

import devholic.fcm_demo.alert.application.event.AlertCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@RequiredArgsConstructor
@Component
public class AlertEventHandler {

    private static final String ASYNC_EXECUTOR = "asyncExecutor";

    private final AlertService alertService;

    @Async(value = ASYNC_EXECUTOR)
    @TransactionalEventListener
    public void sendAlertCreatedEvent(final AlertCreatedEvent event) {
        log.info("sendAlertCreatedEvent 이벤트 핸들러 탐지 " + Thread.currentThread().getName());
        alertService.sendAlert(event.title(), event.body(), event.sender(), event.receiverId());
    }
}
