package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.util.List;

/**
 * Created by Živko on 2016-10-01.
 */
public class Zadatak2DodavanjeVrednosti {

    static Dao<Avion, Integer> avionDao;
    static Dao<Roba, Integer> robaDao;

    public static void main(String[] args) {
        ConnectionSource cs = null;

        try {
            cs = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");

            avionDao = DaoManager.createDao(cs, Avion.class);
            robaDao = DaoManager.createDao(cs, Roba.class);

            Avion a1 = new Avion("Avion 1", 34);
            Avion a2 = new Avion("Avion 2", 21);

            avionDao.create(a1);
            avionDao.create(a2);


            Roba r1 = new Roba("Patike","Duboke patike",1.0, 0.1,0.4,0.05);
            Roba r2 = new Roba("Kosulja","Na dugi rukav",0.4, 0.01,2.4,0.5);
            Roba r3 = new Roba("Voda","Voda za pice",1.4, 0.3,0.04,0.03);
            Roba r4 = new Roba("Ploce","Drvene ploce",3.4, 0.1,3.0,2.3);
            Roba r5 = new Roba("Stolica","Plasticna stolica",2.4, 1.2,0.8,0.5);

            r1.setAvion(a1);
            r2.setAvion(a1);
            r3.setAvion(a1);
            r4.setAvion(a2);
            r5.setAvion(a2);

            robaDao.create(r1);
            robaDao.create(r2);
            robaDao.create(r3);
            robaDao.create(r4);
            robaDao.create(r5);

            List<Avion> avionList = avionDao.queryForAll();
            for (Avion a: avionList) {
                System.out.println(a.toString());
            }
            System.out.println();


            List<Roba> robaList = robaDao.queryForAll();
            for (Roba r: robaList) {
                System.out.println(r.toString());
            }





        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
