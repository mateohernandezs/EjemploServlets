/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodebogota.fdm.dao;

import com.bancodebogota.fdm.dto.UserDto;

/**
 *
 * @author admin
 */
public interface LoginDao {
    UserDto obtenerUsuario(UserDto userDto);
}
