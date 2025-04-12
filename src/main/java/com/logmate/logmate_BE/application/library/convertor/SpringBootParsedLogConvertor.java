package com.logmate.logmate_BE.application.library.convertor;

import com.logmate.logmate_BE.domain.library.entity.SpringBootParsedLog;
import com.logmate.logmate_BE.dto.library.log.SpringBootParsedLogData;

public class SpringBootParsedLogConvertor {
  public static SpringBootParsedLog from(SpringBootParsedLogData dto, String userCode) {
    return SpringBootParsedLog.builder()
        .isFormatCorrect(dto.isFormatCorrect())
        .timestamp(dto.timestamp())
        .level(dto.level())
        .thread(dto.thread())
        .logger(dto.logger())
        .message(dto.message())
        .userCode(userCode)
        .build();
  }

}
