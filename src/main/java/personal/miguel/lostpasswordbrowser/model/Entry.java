/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal.miguel.lostpasswordbrowser.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "EMSA_LOST_PASSWORD")
public class Entry implements Serializable {

    @Id
    @Column(name = "USERID")
    private String userId;

    @Column(name = "URL")
    private String url;

    @Id
    @Column(name = "TICKET")
    private String ticket;

    @Temporal(TemporalType.DATE)
    @Column(name = "TIMESTAMP")
    private Date timestamp;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "USER_UID")
    private String userUID;

    @Column(name = "EMAIL")
    private String email;

    public Entry() {
        ;
    }

    public String getUserId() {
        return userId;
    }

    public String getUrl() {
        return url;
    }

    public String getTicket() {
        return ticket;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public String getUserUID() {
        return userUID;
    }

    public String getEmail() {
        return email;
    }

    public String validateEmail() {
        String isValid = "Invalid";
        if (email.matches("(.*)@(.*).(.*)")) {
            isValid = "Valid";
        }
        return isValid;
    }
}
