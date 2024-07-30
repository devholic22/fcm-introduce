package devholic.fcm_demo.alert.application.event;

public record AlertTokenCreatedEvent(
        Long id,
        String token
) {
}
