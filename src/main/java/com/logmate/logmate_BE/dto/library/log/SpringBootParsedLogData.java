package com.logmate.logmate_BE.dto.library.log;

import java.time.LocalDateTime;


public record SpringBootParsedLogData(
    boolean isFormatCorrect,
    LocalDateTime timestamp,
    String level,
    String thread,
    String logger,
    String message
) {

}
