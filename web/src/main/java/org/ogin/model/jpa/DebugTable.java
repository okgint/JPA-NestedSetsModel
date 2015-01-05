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
@Table(name = "debug_table")
public class DebugTable implements Serializable{
    @Id
    @Column(name = "linecount")
    private Integer lineCount;
    @Column(name = "debug_str")
    private String debugStr;

    public Integer getLineCount() {
        return lineCount;
    }

    public void setLineCount(Integer lineCount) {
        this.lineCount = lineCount;
    }

    public String getDebugStr() {
        return debugStr;
    }

    public void setDebugStr(String debugStr) {
        this.debugStr = debugStr;
    }
}
