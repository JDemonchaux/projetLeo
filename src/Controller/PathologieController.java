/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Huile;
import Model.HuileDAO;
import Model.ManageDB;
import Model.Pathologie;
import Model.PathologieDAO;
import java.util.ArrayList;

/**
 *
 * @author Jerome
 */
public class PathologieController {

    private ArrayList<Pathologie> listPathologie;

    public PathologieController() {
        listPathologie = new ArrayList<>();
        listPathologie = this.getAllPathologies();
    }

    public void addPathologie(Pathologie pathologie) {
        ManageDB.openDataBase();
        PathologieDAO dao = new PathologieDAO(ManageDB.conn);
        dao.create(pathologie);
        ManageDB.closeDataBase();
    }

    public void removePathologie(Pathologie pathologie) {

    }

    public ArrayList<Pathologie> getListPathologie() {
        return listPathologie;
    }

    public void setListPathologie(ArrayList<Pathologie> listPathologie) {
        this.listPathologie = listPathologie;
    }

    public ArrayList<Pathologie> getAllPathologies() {
        ManageDB.openDataBase();
        PathologieDAO dao = new PathologieDAO(ManageDB.conn);
        this.listPathologie.clear();
        this.listPathologie = dao.findAll();

        return this.listPathologie;
    }

    public void deletePathologie(Pathologie p) {
        ManageDB.openDataBase();
        PathologieDAO dao = new PathologieDAO(ManageDB.conn);

        for (Pathologie pa : this.listPathologie) {
            System.out.println(pa);
            if (pa.getName() == p.getName()) {
                dao.delete(pa);
            }
        }

    }

    public void modifPathologie(Pathologie p) {
        ManageDB.openDataBase();
        PathologieDAO dao = new PathologieDAO(ManageDB.conn);

        dao.update(p);
    }

    public void addHuile(Huile h) {
        ManageDB.openDataBase();
        HuileDAO dao = new HuileDAO(ManageDB.conn);
        dao.create(h);
        ManageDB.closeDataBase();
    }
    
    public void updateHuile(Huile h) {
        ManageDB.openDataBase();
        HuileDAO dao = new HuileDAO(ManageDB.conn);
        dao.update(h);
        ManageDB.closeDataBase();
    }
    
    public void deleteHuile(Huile h) {
        ManageDB.openDataBase();
        HuileDAO dao = new HuileDAO(ManageDB.conn);
        dao.delete(h);
        ManageDB.closeDataBase();
    }

}
