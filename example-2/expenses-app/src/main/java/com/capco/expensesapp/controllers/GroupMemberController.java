package com.capco.expensesapp.controllers;

import com.capco.expensesapp.dtos.GroupMemberDTO;
import com.capco.expensesapp.services.GroupMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("group-member")
public class GroupMemberController {

    private final GroupMemberService groupMemberService;

    public GroupMemberController(GroupMemberService groupMemberService) {
        this.groupMemberService = groupMemberService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<GroupMemberDTO>> getAllGroupMembers(){
        return ResponseEntity.ok().body(groupMemberService.getAllGroupMembers());
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<GroupMemberDTO> addGroupMember(@RequestBody GroupMemberDTO groupMemberDTO) {
        log.info("Adding group member -> groupMemberService.addGroupMember({});", groupMemberDTO);
        return ResponseEntity.ok().body(groupMemberService.addGroupMember(groupMemberDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFriendById(@PathVariable(value = "id") Long id) {
        log.info("Deleting by id -> groupMemberService.deleteGroupMemberById({});", id);
        try {
            groupMemberService.deleteGroupMemberById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
