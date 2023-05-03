package com.capco.expensesapp.dtos;

import com.capco.expensesapp.models.Friend;
import com.capco.expensesapp.models.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpensesDTO {

    private Long id;
    private Person payer;
    private Friend expenses;
    private String type;
    private String comment;
    private String category;
    private LocalDateTime createDate;
    private BigDecimal amount;
    private String currency;
}
