/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
package com.bancodebogota.fdm.ja.web.struts;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
    private MessageStore messageStore;    

    public String execute(){
        messageStore= new MessageStore();
        return SUCCESS;    
    }
    
    public MessageStore getMessageStore(){
        return messageStore;
    }
}
