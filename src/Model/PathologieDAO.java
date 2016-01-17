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
public class PathologieDAO extends AbstractDAO<Pathologie> {

    public PathologieDAO(Connection conn) {
        super(conn);
        this.tableName = "PATHOLOGIE";
        this.primaryKey = "id";
    }

    @Override
    public boolean create(Pathologie obj) {
        String query = "";
        try {
            Statement state = this.connect.createStatement();

            query = "INSERT INTO " + tableName
                    + " (NOM, DESCRIPTION) "
                    + " VALUES ("
                    + "'" + obj.getName() + "',"
                    + "'" + obj.getDescription() + "'"
                    + ")";
            state.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(PathologieDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(query);
        }
        return true;
    }

    @Override
    public boolean delete(Pathologie obj) {
       String query = "";
        try {
            Statement state = this.connect.createStatement();

            query = "DELETE FROM " + tableName + " WHERE "
                    + primaryKey + " = " + obj.getId();
            state.executeUpdate(query);


        } catch (SQLException ex) {
            Logger.getLogger(PathologieDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(query);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Pathologie obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pathologie findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pathologie> findAll() {
        ArrayList<Pathologie> liste = new ArrayList<Pathologie>();
        Pathologie p;
        String query = "";
        try {
            Statement state = this.connect.createStatement();
            query = "SELECT * FROM " + tableName;
            ResultSet result = state.executeQuery(query);

            while (result.next()) {
                p = new Pathologie();
                p.setName(result.getString("nom"));
                p.setDescription(result.getString("description"));
                p.setId(result.getInt(primaryKey));

                liste.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PathologieDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(query);
        } finally {
            return liste;
        }
    }

}
