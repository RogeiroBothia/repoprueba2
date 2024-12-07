package com.ufps.seguimientoGraduados.service.interfaces;

import com.ufps.seguimientoGraduados.presentation.dto.LoginDTO;
import com.ufps.seguimientoGraduados.presentation.dto.UserAppDTO;
import com.ufps.seguimientoGraduados.presentation.dto.UserBasicDTO;

import java.util.List;

public interface UserAppService {
    List<UserAppDTO> getAllActiveUsers();

    void activeUser(Long userId);

    void deleteUser(Long userId);

    void updateCodigo(Long userId, UserBasicDTO codigoUser);

    void createUser (UserBasicDTO userDTO);

    List<UserAppDTO> userNoAprobados();

    Long loginUser(LoginDTO userDto);

    UserAppDTO viewProfile(Long userId);

    void updateUser(Long userId, UserAppDTO userUpdate);
}
