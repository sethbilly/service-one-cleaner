package com.partner.one.service.models;

import java.io.Serializable;
import java.util.List;

public class CleanRequest implements Serializable {

    //array of rooms
    private List<Integer> rooms;
    //cleaning capacity of senior cleaner
    private int senior;
    //cleaning capacity of junior cleaner
    private int junior;

    public List<Integer> getRooms() {
        return rooms;
    }

    public void setRooms(List<Integer> rooms) {
        this.rooms = rooms;
    }

    public int getSenior() {
        return senior;
    }

    public void setSenior(int senior) {
        this.senior = senior;
    }

    public int getJunior() {
        return junior;
    }

    public void setJunior(int junior) {
        this.junior = junior;
    }

    @Override
    public String toString() {
        return "CleanRequest{" +
                "rooms=" + rooms +
                ", senior=" + senior +
                ", junior=" + junior +
                '}';
    }
}
