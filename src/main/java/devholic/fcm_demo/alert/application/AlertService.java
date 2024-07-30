package devholic.fcm_demo.alert.application;

import devholic.fcm_demo.alert.domain.Alert;
import devholic.fcm_demo.alert.domain.AlertRepository;
import devholic.fcm_demo.alert.domain.AlertTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class AlertService {

    private static final String TOKEN = "..."; // 실제 FCM 토큰으로 테스트 해 보시면 됩니다.

    private final AlertRepository alertRepository;
    private final AlertTokenRepository tokenRepository;
    private final AlertManager alertManager;

    // 토큰 저장
    public void saveToken(final Long id, final String token) {
        tokenRepository.saveToken(id, token);
    }

    // 알림 전송
    public void sendAlert(final String title, final String body, final String sender, final Long receiverId) {
        // String token = tokenRepository.getToken(receiverId); 프로젝트에서는 레디스를 이용해서 토큰을 조회합니다.
        Alert alert = Alert.createWith(title, body, receiverId);
        Alert savedAlert = alertRepository.save(alert);
        alertManager.send(savedAlert, sender, TOKEN);
    }
}
