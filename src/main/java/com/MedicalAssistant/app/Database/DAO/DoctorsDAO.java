package com.MedicalAssistant.app.Database.DAO;

import com.MedicalAssistant.app.Database.MySQLConnector;
import com.MedicalAssistant.app.Models.Doctors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DoctorsDAO {

    public static ArrayList<Doctors> all() throws SQLException {
        Connection connection = MySQLConnector.get();
        ArrayList<Doctors> doc = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Doctors;");
        while(rs.next()) {
            doc.add(Doctors.fromResultSet(rs));
        }
        return doc;
    }
}
