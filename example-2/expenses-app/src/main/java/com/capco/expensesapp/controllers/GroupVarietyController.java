package com.capco.expensesapp.controllers;

import com.capco.expensesapp.dtos.GroupVarietyDTO;
import com.capco.expensesapp.services.GroupVarietyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("group")
public class GroupVarietyController {

    private final GroupVarietyService groupVarietyService;

    public GroupVarietyController(GroupVarietyService groupVarietyService) {
        this.groupVarietyService = groupVarietyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<GroupVarietyDTO>> getAllGroupVariety() {
        log.info("groupVarietyService.getAllGroupVariety();");
        return ResponseEntity.ok().body(groupVarietyService.getAllGroupVariety());
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> addGroupVariety(@RequestBody GroupVarietyDTO groupVariety) {
        log.info("Creating groupVariety -> groupVarietyService.addGroupVariety({});", groupVariety);
        groupVarietyService.addGroupVariety(groupVariety);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGroupVariety(@PathVariable(value = "id") Long id) {
        log.info("Deleting groupVariety by id -> groupVarietyService.deleteGroupVarietyById({}});", id);
        try{
            groupVarietyService.deleteGroupVarietyById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/find/{name}")
    public ResponseEntity<GroupVarietyDTO> findGroupVarietyByName(@PathVariable(value = "name") String groupVarietyName) {
        log.info("Find groupVariety by name -> groupVarietyService.findGroupVarietyByName({});", groupVarietyName);
        return ResponseEntity.ok().body(groupVarietyService.findGroupVarietyByName(groupVarietyName));
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<GroupVarietyDTO> updateGroupVariety(@RequestBody GroupVarietyDTO groupVarietyDTO) {
        log.info("Updating group -> groupVarietyService.updateGroupVariety({});", groupVarietyDTO);
        return ResponseEntity.ok().body(groupVarietyService.updateGroupVariety(groupVarietyDTO));
    }
}
