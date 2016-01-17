/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jérôme
 */
public abstract class AbstractDAO<T> {
    
    /**
     * ressource de connexion au SGBD
     */
    protected Connection connect = null;
    /**
     * nom de la table correspondant à l'entité paramétrable
     */
    protected String tableName;
    /**
     * nom de la clé primaire de la table correspondant à l'entité paramétrable
     */
    protected String primaryKey;
    /**
     * nom de la clé primaire composée de la table correspondant à l'entité
     * paramétrable
     */
    protected String[] primariesKeys;

    /**
     * Constructeur initialisant la connexion au SGBD 
     * (reçu depuis la classe statique ManageDB)
     * @param conn 
     */
    public AbstractDAO(Connection conn) {
        connect = conn;
    }

    /**
     * Méthode de création en BDD
     *
     * @param obj objet de type entité paramétrable
     * @return boolean
     */
    public abstract boolean create(T obj);

    /**
     * Méthode pour effacer en BDD
     *
     * @param obj objet de type entité paramétrable
     * @return boolean
     */
    public abstract boolean delete(T obj);

    /**
     * Méthode de mise à jour en BDD
     *
     * @param obj objet de type entité paramétrable
     * @return boolean
     */
    public abstract boolean update(T obj);

    /**
     * Méthode de recherche d'un obj de type entité paramétrable à partir de son identifiant
     * lance un exception à destination de l'interface lorsqu'aucun résultat n'est trouvé
     *
     * @param id valeur de la clé primaire de type int 
     * @return T objet de type entité paramétrable
     */
    public abstract T findById(int id);

    /**
     * Méthode pour lire toute la base
     */
    public abstract ArrayList<T> findAll();
}
