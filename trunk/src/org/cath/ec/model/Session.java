package org.cath.ec.model;

// Generated Sep 25, 2012 5:38:21 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Session generated by hbm2java
 */
public class Session extends AbstractModel {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String dow;
    private Date startTime;
    private Date endTime;

    public Session() {
        Date d = new Date();
        startTime = d;
        endTime = d;
    }

    public Session(String name, String dow, Date startTime, Date endTime) {
        this.name = name;
        this.dow = dow;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDow() {
        return this.dow;
    }

    public void setDow(String dow) {
        this.dow = dow;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}