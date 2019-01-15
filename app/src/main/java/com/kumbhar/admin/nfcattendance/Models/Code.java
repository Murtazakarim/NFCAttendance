package com.kumbhar.admin.nfcattendance.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Code {
    @SerializedName("rgba")
    @Expose
    private List<Integer> rgba = null;
    @SerializedName("hex")
    @Expose
    private String hex;

    public Code(List<Integer> rgba, String hex) {
        this.rgba = rgba;
        this.hex = hex;
    }

    public List<Integer> getRgba() {
        return rgba;
    }

    public void setRgba(List<Integer> rgba) {
        this.rgba = rgba;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
