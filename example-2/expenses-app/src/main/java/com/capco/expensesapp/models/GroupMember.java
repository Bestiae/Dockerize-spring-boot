package com.capco.expensesapp.models;

import lombok.Data;
import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "groupmember")
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "groupvar_id")
    private GroupVariety groupVariety;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupMember that = (GroupMember) o;
        return groupVariety.equals(that.groupVariety) && person.equals(that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupVariety, person);
    }
}
