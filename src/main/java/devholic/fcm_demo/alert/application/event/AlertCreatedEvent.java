package devholic.fcm_demo.alert.application.event;

public record AlertCreatedEvent(
        String title,
        String body,
        String sender,
        Long receiverId
) {
}
