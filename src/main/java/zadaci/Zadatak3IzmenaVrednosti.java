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
public class Zadatak3IzmenaVrednosti {

    static Dao<Avion, Integer> avionDao;
    static Dao<Roba, Integer> robaDao;

    public static void main(String[] args) {
        ConnectionSource cs = null;

        try {
            cs = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");

            avionDao= DaoManager.createDao(cs, Avion.class);
            robaDao= DaoManager.createDao(cs, Roba.class);

            List<Roba> robaList = robaDao.queryForAll();
            for (Roba r: robaList) {
                System.out.println(r.toString());
            }

            List<Roba> robaList1 = robaDao.queryForEq(Roba.POLJE_OPIS, "Plasticna stolica");
            Roba robaZaIzmenu = robaList1.get(0);
            robaZaIzmenu.setOpis("Drvena stolica");
            robaDao.update(robaZaIzmenu);

            robaList = robaDao.queryForAll();
            for (Roba r: robaList) {
                System.out.println(r.toString());
            }







        }catch (Exception e){e.printStackTrace();}
        finally {
            try {
                cs.close();
            }catch (IOException e1){e1.printStackTrace();}
        }


    }
}
