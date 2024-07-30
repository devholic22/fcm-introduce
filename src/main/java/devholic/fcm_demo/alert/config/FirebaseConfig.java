package devholic.fcm_demo.alert.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.ThreadManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    private static final String FIREBASE_FILE_URL = "src/main/resources/firebase.json";
    private static final String FIREBASE_FILE_EXCEPTION_MESSAGE = "FCM 파일 변환 과정에서 예외가 발생했습니다.";

    @Bean
    public FirebaseApp firebaseApp() {
        if (!FirebaseApp.getApps().isEmpty()) {
            return FirebaseApp.getInstance();
        }
        ThreadManager threadManager = new FirebaseThreadManager();
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setThreadManager(threadManager)
                .setCredentials(getCredentials())
                .build();
        return FirebaseApp.initializeApp(options);
    }

    private GoogleCredentials getCredentials() {
        try {
            FileInputStream serviceAccount = new FileInputStream(FIREBASE_FILE_URL);
            return GoogleCredentials.fromStream(serviceAccount);
        } catch (IOException e) {
            throw new RuntimeException(FIREBASE_FILE_EXCEPTION_MESSAGE);
        }
    }
}
