package Config;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "futbolista.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_JUGADOR = "CREATE TABLE jugadores (id INTEGER PRIMARY KEY, nombres TEXT, apellidos TEXT, pais TEXT, edad INTEGER, posicion TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_JUGADOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS jugadores");
        onCreate(db);
    }
}
