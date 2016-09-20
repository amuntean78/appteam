package com.app.controller;

import com.app.entity.State;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;


@RequestMapping(value = "/states")
public interface IStateController
{

    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    ResponseEntity getStates();

    @RequestMapping(value = "/{id}",method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    ResponseEntity getState(long id);

    @RequestMapping(value ="", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    ResponseEntity addState(State state);

    @RequestMapping(value = "/{id}", method= RequestMethod.PUT, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    ResponseEntity updateState(long id, State state);

    @RequestMapping(method = RequestMethod.DELETE)
    ResponseEntity deleteStates();

    @RequestMapping(value = "/{id}",method= RequestMethod.DELETE)
    ResponseEntity deleteState(long id);
}