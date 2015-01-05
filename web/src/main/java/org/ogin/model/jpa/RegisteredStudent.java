package org.ogin.model.jpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jabrik on 22/11/2014.
 */
@Entity
@Table(name = "REGISTERED_STUDENTS")
public class RegisteredStudent implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "department", referencedColumnName = "department"),
            @JoinColumn(name = "course", referencedColumnName = "course")
    })
    private Klass course;

    @Column(name = "grade", length = 1)
    private Character grade;

   public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



    public Klass getCourse() {
        return course;
    }

    public void setCourse(Klass course) {
        this.course = course;
    }

    public Character getGrade() {
        return grade;
    }

    public void setGrade(Character grade) {
        this.grade = grade;
    }
}
