package devholic.fcm_demo.sample.ui;

import devholic.fcm_demo.sample.application.WebService;
import devholic.fcm_demo.sample.application.dto.AlertRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/sample")
@RestController
public class WebController {

    private final WebService webService;

    @PostMapping("/alert")
    public ResponseEntity<String> send(@RequestBody final AlertRequest request) {
        webService.call(request);
        return ResponseEntity.ok("알림 전송 완료");
    }
}
