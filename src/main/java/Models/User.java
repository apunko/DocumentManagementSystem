package Models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Length(min=2, max=15, message="First Name should be between 2 - 15 symbols")
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Length(min=2, max=15, message="Last Name should be between 2 - 15 symbols")
    @Column(name="last_name")
    private String lastName;

    private String fullName;

    @Pattern(regexp=".+@.+\\..+", message="Wrong email")
    @Column(name="email")
    private String email;

    @Column(name="role")
    private String role;

    @NotNull
    @Length(min=2, max=15, message="Login should be between 2 - 15 symbols")
    @Column(name="login")
    private String login;

    @Column(name="passport")
    private String passport;

    @Column(name="experience")
    private float experience;

    @NotNull
    @Length(min=2, max=15, message="Position should be between 2 - 15 symbols")
    @Column(name="position")
    private String position;

    @NotNull(message = "Field is required")
    @ManyToOne
    @JoinColumn(name="Department_id")
    private Department department;

    @OneToMany(mappedBy="client", fetch = FetchType.EAGER)
    private Set<Contract> contracts;


    @NotNull(message="Please select a password")
    @Length(min=5, max=32, message="Password should be between 5 - 30 symbols")
    @Column(name="password")
    private String password;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="employees", fetch = FetchType.EAGER)
    private Set<Project> projects;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="employees", fetch = FetchType.EAGER)
    private Set<Work> works;

    public User(){}

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

    public String getFullName() {
        return firstName + " " + lastName;
    }
}