package org.ogin.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Jabrik on 22/11/2014.
 */
@Entity
@Table(name = "temp_table")
public class TempTable implements Serializable {
    @Id
    @Column(name = "num_col")
    private Integer numCol;
    @Column(name = "char_col")
    private String charCol;

    public Integer getNumCol() {
        return numCol;
    }

    public void setNumCol(Integer numCol) {
        this.numCol = numCol;
    }

    public String getCharCol() {
        return charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }
}
