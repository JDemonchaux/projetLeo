/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jerome
 */
public class ManageDB {

    /**
     * ressource de connexion à la base de donnée
     */
    public static Connection conn;
    //Definition statique des elements de connexion
    /**
     * URL du serveur de base de donnée
     */
    private static String DB_URL = "jdbc:derby://localhost:1527/therapiePSM;create=true";
    /**
     * nom de l'utilisateur de la base de donnée
     */
    private static String DB_USER = "adm";
    /**
     * mot de passe de l'utilisateur de la base de données
     */
    private static String DB_PSW = "adm";
    /**
     * nom de la base de donnée
     */
    private static String DB_NAME = "therapiePSM";

    /**
     * Gestion de la connexion à la base de donnée
     */
    public static void openDataBase() {
        try {
            //Instanciation du Driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver O.K.");
            //Etablissement de la connexion au SGBD
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);
            System.out.println("Connexion effective !");
            //Connexion à la BDD
            Statement state = conn.createStatement();
            //state.executeQuery("USE " + DB_NAME + ";");
            state.close();

        } catch (Exception ex) {
            Logger.getLogger(ManageDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * libération de la connexion à la base de donnée
     */
    public static void closeDataBase() {
        try {
            //fermenture de la connexion au SGBD
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManageDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
