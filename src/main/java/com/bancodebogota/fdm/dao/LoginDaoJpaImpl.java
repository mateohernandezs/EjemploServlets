/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodebogota.fdm.dao;

import com.bancodebogota.fdm.dto.UserDto;
import com.bancodebogota.fdm.entity.UserEntity;
import javax.persistence.EntityManager;
import org.modelmapper.ModelMapper;



/**
 *
 * @author admin
 */
public class LoginDaoJpaImpl implements LoginDao{

   private final EntityManager entityManager;

    public LoginDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public UserDto obtenerUsuario(UserDto userDto) {
        try {
            UserEntity user = (UserEntity) entityManager.createQuery(
                    "SELECT c FROM UserEntity c WHERE c.login = :login and c.password = :psw")
                    .setParameter("login", userDto.getLogin())
                    .setParameter("psw", userDto.getPassword())
                    .getSingleResult();

            return getDTO(user);
        } catch (javax.persistence.NoResultException ex) {
            return null;
        }

    }

    private UserDto getDTO(UserEntity user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto dto = modelMapper.map(user, UserDto.class);
        return dto;
    }
}