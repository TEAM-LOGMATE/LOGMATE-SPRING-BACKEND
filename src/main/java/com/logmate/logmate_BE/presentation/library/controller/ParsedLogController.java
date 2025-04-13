package com.logmate.logmate_BE.presentation.library.controller;

import com.logmate.logmate_BE.application.library.convertor.SpringBootParsedLogConvertor;
import com.logmate.logmate_BE.domain.library.entity.SpringBootParsedLog;
import com.logmate.logmate_BE.domain.library.repository.SpringBootParsedLogRepository;
import com.logmate.logmate_BE.dto.library.log.SpringBootParsedLogData;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class ParsedLogController {

  private final SpringBootParsedLogRepository springBootParsedLogRepository;
  private final SimpMessagingTemplate messagingTemplate;
  private final EntityManager entityManager;

  @PostMapping("/spring/{userCode}")
  @ResponseStatus(HttpStatus.OK)
  @Transactional
  public void recieveSpringBootLog(@RequestBody List<SpringBootParsedLogData> request,
      @PathVariable String userCode) {
    // DTO로부터 전달받은 문자열을 Message 엔티티에 담아 저장
    List<SpringBootParsedLog> springBootParsedLogs = request.stream()
        .map(dto -> SpringBootParsedLogConvertor.from(dto, userCode))
        .toList();

    messagingTemplate.convertAndSend("/topic/logs/" + userCode, request);

    springBootParsedLogRepository.saveAll(springBootParsedLogs);
    entityManager.flush();
    entityManager.clear();
  }
}