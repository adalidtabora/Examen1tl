package Config;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConfigDB  {
    // Configuracion de los parametros de la base de datos local en sqlite
    // Nombre de la base de datos
    public static final String namebd = "DBTLeng";

    // Tablas de las bases de datos
    public static final String tblfutbolistas = "FUTBOLISTAS";

    // Campos de la tabla futbolistas
    public static final String id = "ID";
    public static final String nombres = "Nombres";
    public static final String apellidos = "Apellidos";
    public static final String pais = "Pais";
    public static final String posicion = "Posicion";
    public static final String edad = "Edad";

    // Creacion de objetos DDL - CREATE - DROP - ALTER
    public static final String CreateTBFutbolistas = "CREATE TABLE FUTBOLISTAS (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Nombres TEXT, Apellidos TEXT, Pais TEXT, Posicion TEXT, Edad INTEGER)";

    public static final String DropTBFutbolistas = "DROP TABLE IF EXISTS FUTBOLISTAS";

    // Creacion de objetos DML para poder seleccionar informacion de la base de datos
    public static final String SelectTBFutbolistas = "SELECT * FROM " + ConfigDB.tblfutbolistas;

    public static final String Empty = "";

    public ConfigDB(Context context) {

    }


    public SQLiteDatabase getWritableDatabase() {
        return null;
    }
}
