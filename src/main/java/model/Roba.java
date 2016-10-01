package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Živko on 2016-10-01.
 */
@DatabaseTable(tableName = "roba")
public class Roba {

    public static final String POLJE_NAZIV= "naziv";
    public static final String POLJE_OPIS= "opis";
    public static final String POLJE_TEZINA= "tezina";
    public static final String POLJE_VISINA= "visina";
    public static final String POLJE_DUZINA= "duzina";
    public static final String POLJE_SIRINA= "sirina";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName =POLJE_NAZIV, canBeNull = false)
    private String naziv;

    @DatabaseField(columnName =POLJE_OPIS, canBeNull = false)
    private String opis;

    @DatabaseField(columnName =POLJE_TEZINA, canBeNull = false)
    private double tezina;

    @DatabaseField(columnName =POLJE_VISINA, canBeNull = false)
    private double visina;

    @DatabaseField(columnName =POLJE_DUZINA, canBeNull = false)
    private double duzina;

    @DatabaseField(columnName =POLJE_SIRINA, canBeNull = false)
    private double sirina;

    @DatabaseField(foreign = true, canBeNull = false)
    private Avion avion;



    public Roba() {}
    public Roba(String naziv, String opis,double tezina,double visina,double duzina,double sirina) {
        this.opis=opis;
        this.naziv=naziv;
        this.tezina=tezina;
        this.visina=visina;
        this.duzina=duzina;
        this.sirina=sirina;

    }

    public void setId (int id) {this.id = id;}
    public void setNaziv (String naziv) {this.naziv = naziv;}
    public void setOpis (String opis) {this.opis = opis;}
    public void setTezina (double tezina) {this.tezina = tezina;}


    public void setAvion (Avion avion) {this.avion = avion;}



    public int getId () {return id;}
    public String getNaziv () {return naziv;}
    public String getOpis () {return opis;}

    public double getTezina () {return tezina;}
    public Avion getKnjiga () {return avion;}


    @Override
    public String toString() {
        return "Roba ID: "+ id + ", naziv: "+ naziv + ", opis "+ opis+", tezina: "+ tezina + ", visina: "+visina+ ", duzina: "+duzina+ ", sirina: "+ sirina;
    }

}
