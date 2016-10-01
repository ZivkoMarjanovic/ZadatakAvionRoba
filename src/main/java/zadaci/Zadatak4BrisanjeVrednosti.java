package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Živko on 2016-10-01.
 */
public class Zadatak4BrisanjeVrednosti {

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

            List<Roba> robaList1 = robaDao.queryForEq(Roba.POLJE_NAZIV, "Voda");
            final Roba robaZaBrisanje = robaList1.get(0);

            TransactionManager.callInTransaction(cs,
                    new Callable<Void>() {

                        public Void call() throws Exception {
                            robaDao.delete(robaZaBrisanje);

                            return null;
                        }
                    });

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
