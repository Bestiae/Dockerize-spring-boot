package com.capco.expensesapp.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "groupvariety")
public class GroupVariety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "groupvar_name", nullable = false)
    private String groupVarietyName;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "expenses_done", nullable = false)
    private Boolean expensesDone;
}
