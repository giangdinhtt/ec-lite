package org.cath.ec.model;

// Generated Sep 19, 2012 12:31:23 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Session generated by hbm2java
 */
public class Session implements java.io.Serializable {

    private Integer id;
    private String name;
    private String dow;
    private Date startTime;
    private Date endTime;
    private Integer yearId;

    public Session() {
    }

    public Session(String name, String dow, Date startTime, Date endTime, Integer yearId) {
        this.name = name;
        this.dow = dow;
        this.startTime = startTime;
        this.endTime = endTime;
        this.yearId = yearId;
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

    public Integer getYearId() {
        return this.yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

}