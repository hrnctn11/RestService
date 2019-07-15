package com.harunc.rest;

import com.google.gson.Gson;
import com.harunc.domain.service.UserService;
import com.harunc.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Harun on 15.07.2019.
 */
@RestController
@RequestMapping("/rest/users")
public class UsersRestController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET, value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE
          )
    public ResponseEntity<List<Users>> getOwners() {
        List<Users> owners = service.findAll();
        return ResponseEntity.ok(owners);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public ResponseEntity<?> update( @RequestBody String body) {
        try {
            Gson gson = new Gson();

            Users user =gson.fromJson(body, Users.class);

            service.update(user);
           return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    public ResponseEntity<?> insert( @RequestBody String body) {
        try {
            Gson gson = new Gson();

            Users user =gson.fromJson(body, Users.class);

            service.create(user);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/remove")
    public ResponseEntity<?> remove( @RequestBody String body) {
        try {
            Gson gson = new Gson();

            Users user =gson.fromJson(body, Users.class);

            service.remove(user);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeById(@PathVariable("id") Integer id) {
        try {
            service.remove(id);
        }  catch (Exception ex) {
            throw new InternalError(ex);
        }
    }

}
