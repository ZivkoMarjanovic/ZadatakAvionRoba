package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Živko on 2016-10-01.
 */
@DatabaseTable(tableName = "roba")
public class Roba {


    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, canBeNull = false)
    private Avion avion;
}
