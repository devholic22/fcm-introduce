package devholic.fcm_demo.alert.domain;

import devholic.fcm_demo.global.domain.SoftDeleteBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@EqualsAndHashCode(of = "id", callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Alert extends SoftDeleteBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean isRead;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Long receiverId;

    public static Alert createWith(final String title, final String body, final Long receiverId) {
        return Alert.builder()
                .title(title)
                .body(body)
                .receiverId(receiverId)
                .isRead(false)
                .build();
    }

    public void read() {
        if (!isRead) {
            this.isRead = true;
        }
    }
}
