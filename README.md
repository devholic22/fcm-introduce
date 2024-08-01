# fcm-introduce-spring
본 리포지터리는 블로그 내용을 쉽게 실습하실 수 있도록 스프링 환경에서의 FCM 알림 기능 구현 코드를 담은 리포지터리입니다.

## 적용한 기술 환경
* Spring Boot 3.3.2
* Java 17
* Spring Data JPA 3.3.2
* Hibernate 6.5.2
* Spring Data Redis 3.3.2
* Spring Web 3.3.2
* Lombok 1.18.34
* MySQL 8.3.0
* FCM (firebase-admin) 9.3.0

## 주의사항
### 1. 파이어베이스 파일이 필요합니다.
샘플 코드에는 firebase.json 파일을 보관해두지 않았습니다.  
블로그 글을 참고하여 파이어베이스 파일을 받은 뒤 `src/main/resources/firebase.json`으로 저장해주시기 바랍니다.
### 2. 파이어베이스 토큰이 필요합니다.
샘플 코드에는 파이어베이스 토큰을 아래처럼 작성해두었기 때문에 제대로 실행되지 않습니다.  
블로그 글을 참고하여 토큰을 발급받은 뒤 대체하시기 바랍니다.
```java
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
```
## 참고 링크 (블로그 글, Pull Request)
* [[ATWOZ] FCM 알림 기능 개발 기록기 (1) - FCM 도입 이유와 아키텍처 구조](https://devwriter.tistory.com/49)
* [[ATWOZ] FCM 알림 기능 개발 기록기 (2) - FCM 토큰 관리 방법 및 스프링 코드 설명](https://devwriter.tistory.com/50)
* [[ATWOZ] FCM 알림 기능 개발 기록기 (3) - 안드로이드 에뮬레이터로 알림 검증하기](https://devwriter.tistory.com/51)
* [프로젝트 FCM 기능 적용 Pull Request](https://github.com/sosow0212/atwoz/pull/41)
