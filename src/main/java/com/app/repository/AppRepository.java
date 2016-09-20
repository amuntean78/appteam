package com.app.repository;


import com.app.entity.App;
import org.springframework.data.repository.CrudRepository;



public interface AppRepository extends CrudRepository<App, Long> {
}
