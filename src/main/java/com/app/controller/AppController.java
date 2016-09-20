package com.app.controller;


import com.app.entity.App;
import com.app.repository.AppRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;


@Getter
@Setter
@RestController
public class AppController implements IAppController {

    @Autowired
    private AppRepository appRepository;


    @Override
    public ResponseEntity  getApps() {

        List<App> apps = (List<App>) appRepository.findAll();
        if (apps == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(apps);
    }

    @Override
    public ResponseEntity getApp(long id) {
        {
            App app = new App();
            app = appRepository.findOne( id );
            return ResponseEntity.ok(app);
        }
    }

    @Override
    public ResponseEntity addApp(App app) {
        appRepository.save(app);
        if (app == null)
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        return ResponseEntity
                .created(URI.create("/apps/" + appRepository.findOne(app.getId())))
                .body(app);
    }

    @Override
    public ResponseEntity updateApp(long id, App app) {
        return null;
    }

    @Override
    public ResponseEntity deleteApps() {
        return null;
    }

    @Override
    public ResponseEntity deleteApp(long id) {
        return null;
    }
}
