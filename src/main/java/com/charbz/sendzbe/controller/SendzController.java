package com.charbz.sendzbe.controller;

import com.charbz.sendzbe.entity.*;
import com.charbz.sendzbe.service.SendzService;
import com.charbz.sendzbe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SendzController {
    private final SendzService sendzService;
    private final UserService userService;

    @GetMapping("/boulderTypes")
    public List<String> getBoulderTypes() {
        return sendzService.getBoulderTypes().stream().map(BoulderType::getBoulderType).toList();
    }

    @GetMapping("/burns")
    public List<String> getBurns() {
        return sendzService.getBurns().stream().map(Burn::getBurnNumber).toList();
    }

    @GetMapping("/colors")
    public List<String> getColors() {
        return sendzService.getColors().stream().map(Color::getColor).toList();
    }

    @GetMapping("/grades")
    public List<String> getGrades() {
        return sendzService.getGrades().stream().map(Grade::getGrade).toList();
    }

    @GetMapping("/gyms")
    public List<String> getGyms() {
        return sendzService.getGyms().stream().map(Gym::getGym).toList();
    }

    @GetMapping("/holdTypes")
    public List<String> getHoldTypes() {
        return sendzService.getHoldTypes().stream().map(HoldType::getHoldType).toList();
    }

    @GetMapping("/wallTypes")
    public List<String> getWallTypes() {
        return sendzService.getWallTypes().stream().map(WallType::getWallType).toList();
    }

    @GetMapping("/login/{username}/{password}")
    public Boolean login(@PathVariable("username") String username, @PathVariable("password") String password) {
        return userService.login(username, password);
    }

    @GetMapping("/signup/{username}/{password}")
    public Boolean signup(@PathVariable("username") String username, @PathVariable("password") String password) {
        return userService.signup(username, password);
    }

    @GetMapping("/sends/{username}")
    public List<Send> getSends(@PathVariable("username") String username) {
        return sendzService.getSends(username);
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable("username") String username) {
        User user = userService.getUser(username);
        return user;
    }

    @PostMapping("/send")
    public void logSend(@RequestBody LinkedHashMap lhmSend) {
        Send send = new Send();
        send.setColor(lhmSend.get("color").toString());
        send.setBurnNumber(lhmSend.get("burnNumber").toString());
        send.setBoulderType(lhmSend.get("boulderType").toString());
        send.setGrade(lhmSend.get("grade").toString());
        send.setGym(lhmSend.get("gym").toString());
        send.setHoldType(lhmSend.get("holdType").toString());
        send.setWallType(lhmSend.get("wallType").toString());
        send.setSessionDate(LocalDate.parse(lhmSend.get("sessionDate").toString()));
        send.setUsername(lhmSend.get("username").toString());

        sendzService.logSend(send);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody LinkedHashMap lhmUser) {
        User user = new User();
        user.setUsername(lhmUser.get("username").toString());
        user.setFirstName(lhmUser.get("firstName").toString());
        user.setLastName(lhmUser.get("lastName").toString());
        user.setImage((Blob) lhmUser.get("image"));

        userService.updateUser(user);
    }
}
