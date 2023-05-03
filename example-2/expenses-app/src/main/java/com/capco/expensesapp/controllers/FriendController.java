package com.capco.expensesapp.controllers;

import com.capco.expensesapp.dtos.FriendDTO;
import com.capco.expensesapp.services.FriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("friend")
public class FriendController {

    private final FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<FriendDTO>> getAllFriend() {
        log.info("friendService.getAllFriends();");
        return ResponseEntity.ok().body(friendService.getAllFriends());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<FriendDTO>> findAllFriendsByPersonId(@PathVariable(value = "id") Long id) {
        log.info("friendService.findFriendsById({});", id);
        return ResponseEntity.ok().body(friendService.findFriendsByPersonId(id));
    }

    @PostMapping(value = "/add", consumes = "application/json",produces = "application/json")
    public ResponseEntity<FriendDTO> addFriend(@RequestBody FriendDTO friend) {
        log.info("friendService.addFriend({});", friend);
        return ResponseEntity.ok().body(friendService.addFriend(friend));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFriendById(@PathVariable(value = "id") Long id) {
        log.info("friendService.deleteFriendById({});", id);
        try {
            friendService.deleteFriendById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-friends/{id}")
    public ResponseEntity<List<FriendDTO>> findPersonFriendsById(@PathVariable(value = "id") Long id) {
        log.info("friendService.findPersonFriendsById(id);");
        return ResponseEntity.ok().body(friendService.findPersonFriendsById(id));
    }

    @PostMapping("/add")
    public void addFriend(@RequestParam Long friendOne, @RequestParam Long friendTwo) {
        log.info("Adding friend -> friendService.ddFriend( {}, {});", friendOne, friendTwo);
        // THINK FOR THE IMPLEMENTATION OF THIS METHOD.
        friendService.addFriend(friendOne, friendTwo);
    }
}
