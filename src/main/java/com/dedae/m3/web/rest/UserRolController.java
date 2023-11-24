package com.dedae.m3.web.rest;

import com.dedae.m3.dto.UserDetailDTO;
import com.dedae.m3.dto.UserRolDTO;
import com.dedae.m3.services.UserRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/userroles")
public class UserRolController {
    private final UserRolService userRolService;

    public UserRolController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }

    @GetMapping
    public ResponseEntity<List<UserRolDTO>> listUserRol(){
        return ResponseEntity
                .ok()
                .body(userRolService.listUserRol());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRolDTO> getUserRolById(@PathVariable Integer id){
        return ResponseEntity
                .ok()
                .body(userRolService.getUserRolById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Resource not found exception for the id: " + id)));
    }

    @PostMapping
    public ResponseEntity<UserRolDTO> create(@RequestBody final UserRolDTO dto) throws URISyntaxException {
        if (dto.getId() != null){
            throw new IllegalArgumentException(" I new user cannot already have an id.");
        }

        UserRolDTO userDB = userRolService.save(dto);

        return ResponseEntity.created(new URI("/v1/userroles/" + userDB.getId())).body(userDB);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id){
        userRolService.delete(id);

        return ResponseEntity.noContent().build();
    }


}
