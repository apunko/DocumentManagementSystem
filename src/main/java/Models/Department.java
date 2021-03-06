package Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name="name", unique = true)
    private String name;

    @NotNull
    @Size(min = 15, max = 2000)
    @Column(name="description")
    private String description;

    @OneToMany(mappedBy="department", fetch = FetchType.EAGER)
    private Set<User> employees;

    public Department(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<User> employees) {
        this.employees = employees;
    }
}
