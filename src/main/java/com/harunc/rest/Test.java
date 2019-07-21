package com.harunc.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Harun on 15.07.2019.
 */
@RestController
@RequestMapping("/")
public class Test {

    @RequestMapping(method = RequestMethod.GET, value = "/test",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getOwners() {
        String string="I am only trying ";
        return ResponseEntity.ok(string);
    }
}
