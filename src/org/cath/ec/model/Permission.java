package org.cath.ec.model;

// Generated Sep 25, 2012 5:38:21 PM by Hibernate Tools 3.4.0.CR1

/**
 * Permission generated by hbm2java
 */
public class Permission implements java.io.Serializable {

    private Integer id;
    private String description;
    private String pattern;
    private Boolean isActive;

    public Permission() {
    }

    public Permission(String description, String pattern, Boolean isActive) {
        this.description = description;
        this.pattern = pattern;
        this.isActive = isActive;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPattern() {
        return this.pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
