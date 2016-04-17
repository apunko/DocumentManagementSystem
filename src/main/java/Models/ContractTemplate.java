package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="template")
public class ContractTemplate {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    private ContractTemplate(){}

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
