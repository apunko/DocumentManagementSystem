package Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="role")
    private String role;

    @Column(name="login")
    private String login;

    @Column(name="passport")
    private String passport;

    @Column(name="experience")
    private float experience;

    @Column(name="position")
    private String position;

    @ManyToOne
    @JoinColumn(name="Department_id")
    private Department department;

    @OneToMany(mappedBy="client", fetch = FetchType.EAGER)
    private Set<Contract> contracts;

    @Column(name="password")
    private String password;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="employees", fetch = FetchType.EAGER)
    private Set<Project> projects;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="employees", fetch = FetchType.EAGER)
    private Set<Work> works;

    public User(){}

    public User(int id, String firstName, String lastName, String role, float experience, String position, int departmentId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.experience = experience;
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Work> getWorks() {
        return works;
    }

    public void setWorks(Set<Work> works) {
        this.works = works;
    }
}