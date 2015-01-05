package org.ogin.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Jabrik on 21/11/2014.
 */
@Entity
@Table(name = "MAJOR_STATS")
public class MajorStat implements Serializable{
    @Id
    private Integer id;

    @Column(name = "major")
    private String major;
    @Column(name = "total_credits")
    private Integer totalCredit;
    @Column(name = "total_students")
    private Integer totalStudent;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Integer totalCredit) {
        this.totalCredit = totalCredit;
    }

    public Integer getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(Integer totalStudent) {
        this.totalStudent = totalStudent;
    }
}
