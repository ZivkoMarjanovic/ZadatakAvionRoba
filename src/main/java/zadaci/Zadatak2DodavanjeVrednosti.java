package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.io.IOException;

/**
 * Created by Živko on 2016-10-01.
 */
public class Zadatak2DodavanjeVrednosti {

    static Dao<Avion, Integer> avionDao;
    static Dao<Roba, Integer> robaDao;

    public static void main(String[] args) {
        ConnectionSource cs = null;

        try {
            cs = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");

            avionDao = DaoManager.createDao(cs, Avion.class);
            robaDao = DaoManager.createDao(cs, Roba.class);





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
