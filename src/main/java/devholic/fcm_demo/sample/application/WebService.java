package devholic.fcm_demo.sample.application;

import devholic.fcm_demo.alert.application.event.AlertCreatedEvent;
import devholic.fcm_demo.global.event.Events;
import devholic.fcm_demo.sample.application.dto.AlertRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional // 별도의 트랜잭션 작업이 이루어진다고 가정합니다.
@Service
public class WebService {

    // 데모를 위해 발신자와 수신자 id는 상수 값을 이용합니다.
    private static final String SENDER = "발신자";
    private static final Long RECEIVER_ID = 1L;

    public void call(final AlertRequest request) {
        Events.raise(new AlertCreatedEvent(request.title(), request.body(), SENDER, RECEIVER_ID));
    }
}
