package com.partner.one.service.models;

import java.io.Serializable;

public class CleanResponse implements Serializable {

    private int senior;
    private int junior;

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
}
