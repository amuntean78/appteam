package com.app.controller;

import com.app.entity.State;
import com.app.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class StateController implements IStateController {


    @Autowired
    private StateRepository stateRepository;
    private List<State> states;


    @Override
    public ResponseEntity getStates() {

        List<State> states = (List<State>) stateRepository.findAll();
        if (states == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(states);
    }

    @Override
    public ResponseEntity getState(long id) {
        return null;
    }

    @Override
    public ResponseEntity addState(@RequestBody State state) {
        stateRepository.save(state);
        if (state == null)
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        return ResponseEntity
                .created(URI.create("/states/" + stateRepository.findOne(state.getId())))
                .body(state);
    }

    @Override
    public ResponseEntity updateState(long id, State state) {
        return null;
    }

    @Override
    public ResponseEntity deleteStates() {
        return null;
    }

    @Override
    public ResponseEntity deleteState(long id) {
        return null;
    }
}
