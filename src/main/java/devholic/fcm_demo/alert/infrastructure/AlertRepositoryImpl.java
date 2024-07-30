package devholic.fcm_demo.alert.infrastructure;

import devholic.fcm_demo.alert.domain.Alert;
import devholic.fcm_demo.alert.domain.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AlertRepositoryImpl implements AlertRepository {

    private final AlertJpaRepository alertJpaRepository;

    @Override
    public Alert save(final Alert alert) {
        return alertJpaRepository.save(alert);
    }
}
