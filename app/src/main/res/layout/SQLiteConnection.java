package Config;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteConnection extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="Futbolistas" ;

    public SQLiteConnection(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase)
        {
            /* Creacion de objectos de base de datos */
            sqLiteDatabase.execSQL(ConfigDB.CreateTBFutbolistas);  // Creando la tabla de personas en sqlite..
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
        {
            sqLiteDatabase.execSQL(ConfigDB.DropTBFutbolistas);
            onCreate(sqLiteDatabase);
        }
}
