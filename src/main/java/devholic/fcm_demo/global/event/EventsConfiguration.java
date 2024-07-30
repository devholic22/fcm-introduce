package devholic.fcm_demo.global.event;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class EventsConfiguration {

    private final ApplicationContext applicationContext;

    @Bean
    public InitializingBean eventInitializer() {
        return () -> Events.setPublisher(applicationContext);
    }
}
