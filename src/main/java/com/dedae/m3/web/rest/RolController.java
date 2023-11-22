package com.dedae.m3.web.rest;

import com.dedae.m3.dto.RolDTO;
import com.dedae.m3.services.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/role")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }
    @GetMapping
    public ResponseEntity<List<RolDTO>> listRoles(){
        return  ResponseEntity
                .ok()
                .body(rolService.listRoles());

    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable final Integer id){
        return  ResponseEntity
                .ok()
                .body(rolService.getRolById(id).orElseThrow(IllegalArgumentException::new));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody final RolDTO dto) throws  URISyntaxException{
        if (dto.getId() != null){
            throw new IllegalArgumentException("No hya id");
        }
        rolService.save(dto);

        return ResponseEntity
                .created( null)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        rolService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
