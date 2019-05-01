package com.SolfugaSoft.userservice.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{email}")
    public String getUser(@PathVariable("email") final String email) {

        ResponseEntity<String> userResponse = restTemplate.exchange("http://localhost:8300/rest/db/" + email, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        });

        String user = userResponse.getBody();

        return user;
    }

}
