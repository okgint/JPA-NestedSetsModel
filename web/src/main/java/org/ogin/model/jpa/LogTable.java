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
@Table(name = "log_table")
public class LogTable implements Serializable {
    @Id
    @Column(name = "code")
    private Integer code;
    @Column(name = "message")
    private String message;
    @Column(name = "info")
    private String info;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
