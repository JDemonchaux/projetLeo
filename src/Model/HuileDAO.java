/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Jerome
 */
public class HuileDAO extends AbstractDAO<Huile> {

    public HuileDAO(Connection conn) {
        super(conn);
        this.tableName = "HUILE";
        this.primaryKey = "id";
    }

    @Override
    public boolean create(Huile obj) {
        String query = "";
        try {
            Statement state = this.connect.createStatement();

            query = "INSERT INTO " + tableName
                    + " (NOM, DESCRIPTION) "
                    + " VALUES ("
                    + "'" + obj.getNom()+ "',"
                    + "'" + obj.getDescription() + "'"
                    + ")";
            state.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(HuileDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(query);
        }
        return true;
    }

    @Override
    public boolean delete(Huile obj) {
       String query = "";
        try {
            Statement state = this.connect.createStatement();

            query = "DELETE FROM " + tableName + " WHERE "
                    + primaryKey + " = " + obj.getId();
            state.executeUpdate(query);


        } catch (SQLException ex) {
            Logger.getLogger(HuileDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(query);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Huile obj) {
         String query = "";
        try {
            Statement state = this.connect.createStatement();

            query = "UPDATE " + tableName + " SET "
                    + " NOM = '" + obj.getNom()+ "', "
                    + " DESCRIPTION = '" + obj.getDescription() + "' "
                    + " WHERE " + primaryKey + " = " + obj.getId();
            state.executeUpdate(query);


        } catch (SQLException ex) {
            Logger.getLogger(HuileDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(query);
            return false;
        }
        return true;
    }

    @Override
    public Huile findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Huile> findAll() {
        ArrayList<Huile> liste = new ArrayList<Huile>();
        Huile p;
        String query = "";
        try {
            Statement state = this.connect.createStatement();
            query = "SELECT * FROM " + tableName;
            ResultSet result = state.executeQuery(query);

            while (result.next()) {
                p = new Huile();
                p.setNom(result.getString("nom"));
                p.setDescription(result.getString("description"));
                p.setId(result.getInt(primaryKey));

                liste.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HuileDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(query);
        } finally {
            return liste;
        }
    }

}
