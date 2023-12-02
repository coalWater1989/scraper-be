package com.charbz.sendzbe.service;

import com.charbz.sendzbe.entity.*;
import com.charbz.sendzbe.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SendzService {
    private final BoulderTypeRepository boulderTypeRepository;
    private final BurnRepository burnRepository;
    private final ColorRepository colorRepository;
    private final GradeRepository gradeRepository;
    private final GymRepository gymRepository;
    private final HoldTypeRepository holdTypeRepository;
    private final SendRepository sendRepository;
    private final WallTypeRepository wallTypeRepository;

    public List<BoulderType> getBoulderTypes() {
        return (List<BoulderType>) boulderTypeRepository.findAll();
    }

    public List<Burn> getBurns() {
        List<Burn> burns = (List<Burn>) burnRepository.findAll();
        burns.sort(Comparator.comparing(o -> o.getSortId()));

        return burns;
    }

    public List<Color> getColors() {
        return (List<Color>) colorRepository.findAll();
    }

    public List<Grade> getGrades() {
        List<Grade> grades = (List<Grade>) gradeRepository.findAll();
        grades.sort(Comparator.comparing(o -> o.getSortId()));

        return grades;
    }

    public List<Gym> getGyms() {
        return (List<Gym>) gymRepository.findAll();
    }

    public List<HoldType> getHoldTypes() {
        return (List<HoldType>) holdTypeRepository.findAll();
    }

    public List<WallType> getWallTypes() {
        return (List<WallType>) wallTypeRepository.findAll();
    }

    public List<Send> getSends(String username) {
        return (List<Send>) sendRepository.findAllByUsername(username);
    }

    public void logSend(Send send) {
        sendRepository.save(send);
    }
}
