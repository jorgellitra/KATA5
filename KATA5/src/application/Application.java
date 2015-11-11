package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        Connection conec = DriverManager.getConnection("jdbc:sqlite:BDMails.db");
        Statement state = conec.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM PEOPLE");
        String nameFile = "";
        BufferedReader reader = new BufferedReader(new FileReader ( new File ( nameFile)));
        String mail;
        while((mail = reader.readLine())!= null){
            String query = "INSERT INTO MAIL (MAIL) VALUES ('" + mail + "')";
            state.executeQuery(query);
        }
        rs.close();
        state.close();
        conec.close();
    }
    
}
