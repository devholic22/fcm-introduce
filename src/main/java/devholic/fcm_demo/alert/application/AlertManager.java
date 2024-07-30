package devholic.fcm_demo.alert.application;

import devholic.fcm_demo.alert.domain.Alert;

public interface AlertManager {

    void send(Alert alert, String sender, String token);
}
