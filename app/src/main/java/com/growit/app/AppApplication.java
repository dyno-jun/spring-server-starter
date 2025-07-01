package com.growit.app;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
@ConfigurationPropertiesScan
public class AppApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppApplication.class, args);
  }

  @RestController
  static class HealthCheckController {
    @GetMapping("/health")
    public String health() {
      return "OK";
    }

    @PostMapping("/api/test")
    public ResponseEntity<Map<String, Object>> testPost(@RequestBody Map<String, Object> body) {
      Map<String, Object> response = new HashMap<>();
      response.put("message", "성공적으로 처리되었습니다.");
      response.put("received", body);
      return ResponseEntity.ok(response);
    }
  }
}
