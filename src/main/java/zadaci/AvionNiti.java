package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Živko on 2016-10-01.
 */
public class AvionNiti extends Thread{

    static boolean dozvoljenoPoletanje=true;
    private Avion avion;


    public AvionNiti () {}
    public AvionNiti (Avion avion) {
        this.avion=avion;
    }

    @Override
    public void run(){

        System.out.println("Pocinje provera za avion: " + this.avion.getId());
        Random random= new Random();
        try {
            int cekaj= (int) random.nextDouble()*2000;
            this.sleep(cekaj);

            System.out.println("Spreman za poletanje Avion: "+ this.avion.getId());
        }catch (InterruptedException e) {e.printStackTrace();}

        while (pocinjePoletanje()== false){
            try {

                this.sleep(2000);

                System.out.println("Trazim ponovo do uzletim Avion: "+ this.avion.getId());
            }catch (InterruptedException e) {e.printStackTrace();}

        }


    }

    public synchronized boolean pocinjePoletanje(){

        if (dozvoljenoPoletanje) {
            dozvoljenoPoletanje=false;
            System.out.println("Avion: " + this.avion.getId()+ " izlazi na pistu i polece.");
            try {

                this.sleep(2000);

                System.out.println("Avion: " + this.avion.getId()+ " je poleteo.");
            }catch (InterruptedException e) {e.printStackTrace();}

            dozvoljenoPoletanje=true;

            return true;

        }
        else {System.out.println("Avion: " + this.avion.getId()+ " - pista je zauzeta.");
        return false;}


        }

    static Dao<Avion, Integer> avionDao;


    public static void main(String[] args) {
        ConnectionSource cs = null;

        try {
            cs = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");

            avionDao= DaoManager.createDao(cs, Avion.class);

            Avion a1 = avionDao.queryForId(1);
            Avion a2 = avionDao.queryForId(2);

            AvionNiti an1 = new AvionNiti(a1);
            AvionNiti an2 = new AvionNiti(a2);

            an1.start();
            an2.start();

            an1.join();
            an2.join();

            System.out.println("SVI AVIONI SU POLETELI");







        }catch (Exception e){e.printStackTrace();}
        finally {
            try {
                cs.close();
            }catch (IOException e1){e1.printStackTrace();}
        }


    }


}
