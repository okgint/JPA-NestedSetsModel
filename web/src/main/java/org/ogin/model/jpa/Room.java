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
@Table(name = "ROOMS")
public class Room implements Serializable{
    @Id
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "building")
    private String building;

    @Column(name = "room_number")
    private Integer roomNumber;
    @Column(name = "number_seats")
    private Integer numberSeat;
    @Column(name = "description")
    private String description;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(Integer numberSeat) {
        this.numberSeat = numberSeat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
