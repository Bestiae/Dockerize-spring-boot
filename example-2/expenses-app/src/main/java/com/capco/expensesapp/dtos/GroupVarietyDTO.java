package com.capco.expensesapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupVarietyDTO {

    private Long Id;
    private String groupVarietyName;
    private LocalDateTime createDate;
    private Boolean expensesDone;
}