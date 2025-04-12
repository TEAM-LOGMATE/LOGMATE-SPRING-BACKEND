package com.logmate.logmate_BE.presentation.library.controller;

import com.logmate.logmate_BE.application.library.convertor.SpringBootParsedLogConvertor;
import com.logmate.logmate_BE.domain.library.entity.SpringBootParsedLog;
import com.logmate.logmate_BE.domain.library.repository.SpringBootParsedLogRepository;
import com.logmate.logmate_BE.dto.library.log.SpringBootParsedLogData;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class ParsedLogController {

  private final SpringBootParsedLogRepository springBootParsedLogRepository;
  private final SimpMessagingTemplate messagingTemplate;

  @PostMapping("/spring/{userCode}")
  @ResponseStatus(HttpStatus.OK)
  public void recieveSpringBootLog(@RequestBody List<SpringBootParsedLogData> request,
      @PathVariable String userCode) {
    // DTO로부터 전달받은 문자열을 Message 엔티티에 담아 저장
    List<SpringBootParsedLog> springBootParsedLogs = new ArrayList<>();
    for (SpringBootParsedLogData dto : request) {
      SpringBootParsedLog springBootParsedLog = SpringBootParsedLogConvertor.from(dto, userCode);
      springBootParsedLogs.add(springBootParsedLog);
      messagingTemplate.convertAndSend("/topic/logs/" + userCode, dto);
    }
    springBootParsedLogRepository.saveAll(springBootParsedLogs);
  }
}