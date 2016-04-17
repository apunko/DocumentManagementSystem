package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payform")
public class PayForm {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="type")
    private String type;

    private PayForm(){}

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
