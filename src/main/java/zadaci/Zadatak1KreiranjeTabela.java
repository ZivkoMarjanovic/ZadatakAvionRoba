package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

import java.io.IOException;

/**
 * Created by Živko on 2016-10-01.
 */
public class Zadatak1KreiranjeTabela {



    public static void main(String[] args) {
        ConnectionSource cs = null;

        try {
            cs = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");


            TableUtils.dropTable(cs, Roba.class, true);
            TableUtils.dropTable(cs, Avion.class, true);


            TableUtils.createTable(cs, Avion.class);
            TableUtils.createTable(cs, Roba.class);



        }catch (Exception e){e.printStackTrace();}
        finally {
            try {
                cs.close();
            }catch (IOException e1){e1.printStackTrace();}
        }


    }
}
