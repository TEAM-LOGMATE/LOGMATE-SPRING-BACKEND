package com.logmate.logmate_BE.domain.library.repository;

import com.logmate.logmate_BE.domain.library.entity.SpringBootParsedLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringBootParsedLogRepository extends JpaRepository<SpringBootParsedLog, Long> {
}