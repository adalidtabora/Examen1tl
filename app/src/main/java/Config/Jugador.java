package Config;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
public class Jugador {
    private int id;
    private String nombres;
    private String apellidos;
    private String pais;
    private int edad;
    private String posicion;

    // Constructores, getters y setters

    public Jugador(int id, String nombres, String apellidos, String pais, int edad, String posicion) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.pais = pais;
        this.edad = edad;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public long guardarJugador(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("nombres", nombres);
        values.put("apellidos", apellidos);
        values.put("pais", pais);
        values.put("edad", edad);
        values.put("posicion", posicion);

        long newRowId = db.insert("jugadores", null, values);

        db.close();

        return newRowId;
    }

    public static Jugador obtenerJugadorPorId(Context context, int jugadorId) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                "id",
                "nombres",
                "apellidos",
                "pais",
                "edad",
                "posicion"
        };

        String selection = "id = ?";
        String[] selectionArgs = {String.valueOf(jugadorId)};

        Cursor cursor = db.query(
                "jugadores",
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        Jugador jugador = null;

        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String nombres = cursor.getString(cursor.getColumnIndexOrThrow("nombres"));
            String apellidos = cursor.getString(cursor.getColumnIndexOrThrow("apellidos"));
            String pais = cursor.getString(cursor.getColumnIndexOrThrow("pais"));
            int edad = cursor.getInt(cursor.getColumnIndexOrThrow("edad"));
            String posicion = cursor.getString(cursor.getColumnIndexOrThrow("posicion"));

            jugador = new Jugador(id, nombres, apellidos, pais, edad, posicion);
        }

        cursor.close();
        db.close();

        return jugador;
    }

    // Otros métodos de la clase

    // ...

}
