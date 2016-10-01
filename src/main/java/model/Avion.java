package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Živko on 2016-10-01.
 */
@DatabaseTable(tableName = "avion")
public class Avion {

    public static final String POLJE_OZNAKA = "oznaka";
    public static final String POLJE_RASPON_KRILA = "rasponKrila";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName =POLJE_OZNAKA, canBeNull = false)
    private String oznaka;

    @DatabaseField(columnName =POLJE_RASPON_KRILA, canBeNull = false)
    private int rasponKrila;

    @ForeignCollectionField(foreignFieldName = "avion")
    ForeignCollection<Roba> robe;


    public  Avion() {}
    public  Avion(String oznaka, int rasponKrila) {
        this.oznaka=oznaka;
        this.rasponKrila=rasponKrila;
    }

    public void setId (int id) {this.id = id;}
    public void setOznaka (String oznaka) {this.oznaka = oznaka;}
    public void setRasponKrila (int rasponKrila) {this.rasponKrila = rasponKrila;}
    public void setRobe (ForeignCollection<Roba> robe) {this.robe = robe;}


    public int getId () {return id;}
    public String getOznaka () {return oznaka;}
    public int getRasponKrila () {return rasponKrila;}

    public ForeignCollection<Roba> getRobe () {return robe;}

    @Override
    public String toString() {
        return "Avion ID: "+ id + ", oznak: "+ oznaka + ", raspon krila: "+ rasponKrila;
    }




}
