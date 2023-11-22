package com.dedae.m3.web.rest;

import com.dedae.m3.domain.entities.UserDetail;
import com.dedae.m3.dto.UserDTO;
import com.dedae.m3.dto.UserDetailDTO;
import com.dedae.m3.services.UserDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/userdetails")
public class UserDetailController {

    private final UserDetailService userDetailService;

    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;

    }

    @GetMapping
    public ResponseEntity<List<UserDetailDTO>> listUsersDetails(){
        return ResponseEntity
                .ok()
                .body(userDetailService.listUserDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDTO> getUserById(@PathVariable Long id){
        return  ResponseEntity
                .ok()
                .body(userDetailService.getUserDetailById(id).orElseThrow(() -> new IllegalArgumentException("Resource not found exception for the id: " + id)));
    }

    @PostMapping
    public ResponseEntity<UserDetailDTO> create(@RequestBody final UserDetailDTO dto) throws URISyntaxException {
        if (dto.getId() != null){
            throw new IllegalArgumentException(" I new user cannot already have an id.");
        }
        UserDetailDTO userDB = userDetailService.save(dto);

        return ResponseEntity.created(new URI("/v1/userdetails/" + userDB.getId())).body(userDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id){
        userDetailService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
