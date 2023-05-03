package com.capco.expensesapp.repositories;

import com.capco.expensesapp.models.GroupVariety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupVarietyRepository extends JpaRepository<GroupVariety, Long> {

    GroupVariety findGroupVarietyByGroupVarietyName(String groupName);
}
