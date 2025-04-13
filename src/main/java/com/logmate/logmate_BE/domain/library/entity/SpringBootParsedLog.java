package com.logmate.logmate_BE.domain.library.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class SpringBootParsedLog {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private boolean isFormatCorrect;
  private LocalDateTime timestamp;
  private String level;
  private String thread;
  private String logger;

  @Column(nullable = false)
  private String message;

  @Column(nullable = false)
  private String userCode;
}