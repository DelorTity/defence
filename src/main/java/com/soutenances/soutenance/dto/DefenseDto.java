package com.soutenances.soutenance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder @NoArgsConstructor
@AllArgsConstructor
public class DefenseDto {
    private LocalDate date;
    private String time;
    private String classroom;
    private long student;
    private long jury1;
    private long jury2;
    private long jury3;
    private long supervisor;
}
