package com.capco.expensesapp.dtos;

import com.capco.expensesapp.models.GroupVariety;
import com.capco.expensesapp.models.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupMemberDTO {

    private Long id;
    private GroupVariety groupVariety;
    private Person person;

}
