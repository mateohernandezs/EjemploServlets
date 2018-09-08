/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodebogota.fdm.controller;

import com.bancodebogota.fdm.dao.LoginDao;
import com.bancodebogota.fdm.dao.LoginDaoImpl;
import com.bancodebogota.fdm.dao.LoginDaoJpaImpl;
import com.bancodebogota.fdm.dto.UserDto;

import com.opensymphony.xwork2.ActionSupport;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;
//import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author admin
 */
public class LoginAction extends ActionSupport implements ServletContextAware {

    private UserDto userDto;
    private ServletContext ctx;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public String login() {

        UserDto userDB = LoginDaoImpl.obtenerUsuario(userDto.getLogin(), userDto.getPassword());

        if (userDB!=null) {
            return SUCCESS + "Tiles";
        } else {
            return ERROR;
        }
    }
    
    public String executeJpa() {
        //userDto = new UserDto();
        LoginDao loginDao = new LoginDaoJpaImpl(getEM());
        UserDto us = loginDao.obtenerUsuario(userDto);
        if (us == null) {
            return ERROR;
        } else {
            this.userDto = us;
            return SUCCESS + "Tiles";
        }
    }
    

    public void validate() {
        if (userDto != null) {
            if (userDto.getLogin().length() == 0) {
                addFieldError("userDto.login", "Name isrequired.");
            }
            if (userDto.getPassword().length() == 0) {
                addFieldError("userDto.password", "Password is required.");
            }
        }
    }
    
    @Override
    public void setServletContext(ServletContext sc) {
        this.ctx = sc;
    }

    private EntityManager getEM() {
        EntityManagerFactory emf = (EntityManagerFactory) ctx.getAttribute("EntityManagerFactory");
        return emf.createEntityManager();
    }

    

}
