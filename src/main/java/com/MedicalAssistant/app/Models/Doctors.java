package com.MedicalAssistant.app.Models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctors implements Serializable {
    private int doctor_id;
    private String first_name;
    private String last_name;

    public Doctors() {}

    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public static Doctors fromResultSet(ResultSet rs) throws SQLException {
        Doctors p = new Doctors();
        p.doctor_id = rs.getInt("doctor_id");
        p.first_name = rs.getString("first_name");
        p.last_name = rs.getString("last_name");

        return p;
    }
}
