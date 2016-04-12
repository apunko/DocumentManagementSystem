package JavaFiles.Models;

/**
 * Created by Anton on 4/12/2016.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    public Department(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Department(){

    }

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
    public void setFirstName(String description) {
        this.description = description;
    }
}
