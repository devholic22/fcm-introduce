package devholic.fcm_demo.alert.infrastructure;

import devholic.fcm_demo.alert.domain.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertJpaRepository extends JpaRepository<Alert, Long> {

    Alert save(Alert alert);
}
