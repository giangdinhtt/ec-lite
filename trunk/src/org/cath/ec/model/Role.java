package org.cath.ec.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Model object that represents a security role.
 */
/*@Entity
@Table(name="roles")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)*/
public class Role extends AbstractModel {

    private Long id;

    private String name;

    private String description;

    private Set<String> permissions;

    protected Role() {
    	super();
    	permissions = new HashSet<String>();
    }

    public Role(String name) {
    	this();
        this.name = name;
    }

/*    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic(optional=false)
    @Column(length=100)
    @Index(name="idx_roles_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic(optional=false)
    @Column(length=255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @CollectionOfElements
    @JoinTable(name="roles_permissions")
    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }*/

}
