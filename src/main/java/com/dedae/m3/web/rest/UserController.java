package com.dedae.m3.web.rest;


import com.dedae.m3.dto.UserDTO;
import com.dedae.m3.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listUsers(@RequestParam(required = false, defaultValue = "false") boolean detailed){

        if(detailed){
            return ResponseEntity.ok().body(userService.listUserDetailed());
        } else {
            return ResponseEntity.ok().body(userService.listUsers());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id){
        return  ResponseEntity
                .ok()
                .body(userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("Resource not found exception for the id: " + id)));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody final UserDTO dto) throws URISyntaxException{
        if (dto.getId() != null){
            throw new IllegalArgumentException(" I new user cannot already have an id.");
        }
        UserDTO userDB = userService.save(dto);

        return ResponseEntity.created(new URI("/v1/students/" + userDB.getId())).body(userDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id){
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
