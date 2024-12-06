package com.ufps.seguimientoGraduados.presentation.controller;

import com.ufps.seguimientoGraduados.persistence.entity.UserApp;
import com.ufps.seguimientoGraduados.presentation.dto.LoginDTO;
import com.ufps.seguimientoGraduados.presentation.dto.UserAppDTO;
import com.ufps.seguimientoGraduados.presentation.dto.UserBasicDTO;
import com.ufps.seguimientoGraduados.service.interfaces.UserAppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserAppService userAppService;

    //Usuario recien registrado:
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody @Valid UserBasicDTO newUser){
         userAppService.createUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("1");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO userLogin){
        if(userAppService.loginUser(userLogin) == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("-1");
        Long userId = userAppService.loginUser(userLogin);
        return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(userId));
    }

    @GetMapping("/{userId}/profile")
    public ResponseEntity<UserAppDTO> viewPerfil(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(userAppService.viewProfile(userId));
    }


/*
        @GetMapping("/{correo}")
        public Usuario obtenerUsuario(@PathVariable String correo) {
            return usuarioService.obtenerUsuario(correo);
        }
    }*/

}
