package org.ogin.model.jpa;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jabrik on 22/11/2014.
 */
@Entity
@Table(name = "CLASSES")
public class Klass implements Serializable {
    @Id
    @Column(name = "department", columnDefinition = "char(3)")
    private String department;

    @Id
    @Column(name = "course")
    private Integer course;
    @Column(name = "description")
    private String description;
    @Column(name = "max_students")
    private Integer maxStudent;
    @Column(name = "current_students")
    private Integer current_student;
    @Column(name = "num_credits")
    private Integer numCredit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(Integer maxStudent) {
        this.maxStudent = maxStudent;
    }

    public Integer getCurrent_student() {
        return current_student;
    }

    public void setCurrent_student(Integer current_student) {
        this.current_student = current_student;
    }

    public Integer getNumCredit() {
        return numCredit;
    }

    public void setNumCredit(Integer numCredit) {
        this.numCredit = numCredit;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(department);
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Klass))
            return false;
        Klass that = (Klass) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(department, that.department);
        return eb.isEquals();
    }
}
