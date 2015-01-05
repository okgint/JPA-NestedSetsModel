package org.ogin.model.jpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jabrik on 21/11/2014.
 */
@Entity
@Table(name = "Students")
public class Student implements Serializable {
    @Id
    @SequenceGenerator(name = "StudentSequence", sequenceName = "student_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StudentSequence")
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "major")
    private String major;
    @Column(name = "current_credits")
    private Double currentCredits;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Number getCurrentCredits() {
        return currentCredits;
    }

    public void setCurrentCredits(Double currentCredits) {
        this.currentCredits = currentCredits;
    }
}
