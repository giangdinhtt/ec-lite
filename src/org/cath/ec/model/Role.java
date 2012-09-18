package org.cath.ec.model;

// Generated Sep 19, 2012 12:31:23 AM by Hibernate Tools 3.4.0.CR1

/**
 * Role generated by hbm2java
 */
public class Role implements java.io.Serializable {

    private Integer id;
    private String name;
    private String description;
    private Boolean isActive;

    public Role() {
    }

    public Role(String name, String description, Boolean isActive) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}