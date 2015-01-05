package org.ogin.model.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jabrik on 22/11/2014.
 */
@Entity
@Table(name = "RS_AUDIT")
public class RsAudit implements Serializable{
    @Id
    @Column(name = "change_type")
    private Character changeType;
    @Column(name = "changed_by")
    private String changedBy;

    @Column(name = "timestamp")
    @Temporal(TemporalType.DATE)
    private Date timestamp;

    @Column(name = "old_student_id")
    private Integer oldStudentId;
    @Column(name = "old_department")
    private String oldDepartment;
    @Column(name = "old_course")
    private Integer oldCourse;
    @Column(name = "old_grade")
    private Character oldGrade;
    @Column(name = "new_student_id")
    private Integer newStudentId;
    @Column(name = "new_department")
    private String newDepartment;
    @Column(name = "new_course")
    private Integer newCourse;
    @Column(name = "new_grade")
    private Character newGrade;

    public Character getChangeType() {
        return changeType;
    }

    public void setChangeType(Character changeType) {
        this.changeType = changeType;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getOldStudentId() {
        return oldStudentId;
    }

    public void setOldStudentId(Integer oldStudentId) {
        this.oldStudentId = oldStudentId;
    }

    public String getOldDepartment() {
        return oldDepartment;
    }

    public void setOldDepartment(String oldDepartment) {
        this.oldDepartment = oldDepartment;
    }

    public Integer getOldCourse() {
        return oldCourse;
    }

    public void setOldCourse(Integer oldCourse) {
        this.oldCourse = oldCourse;
    }

    public Character getOldGrade() {
        return oldGrade;
    }

    public void setOldGrade(Character oldGrade) {
        this.oldGrade = oldGrade;
    }

    public Integer getNewStudentId() {
        return newStudentId;
    }

    public void setNewStudentId(Integer newStudentId) {
        this.newStudentId = newStudentId;
    }

    public String getNewDepartment() {
        return newDepartment;
    }

    public void setNewDepartment(String newDepartment) {
        this.newDepartment = newDepartment;
    }

    public Integer getNewCourse() {
        return newCourse;
    }

    public void setNewCourse(Integer newCourse) {
        this.newCourse = newCourse;
    }

    public Character getNewGrade() {
        return newGrade;
    }

    public void setNewGrade(Character newGrade) {
        this.newGrade = newGrade;
    }
}
