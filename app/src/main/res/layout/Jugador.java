package Config;
import android.content.ContentValues;
import android.content.Context;


import android.database.sqlite.SQLiteDatabase;

public class Jugador {



        private int id;
        private String nombres;
        private String apellidos;
        private String pais;
        private int edad;
        private String posicion;

        public Jugador() {
        }

        public Jugador(int id, String nombres, String apellidos, String pais, int edad, String posicion) {
            this.id = id;
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.pais = pais;
            this.edad = edad;
            this.posicion = posicion;
        }

        // Getters y setters




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String direccion) {
        this.posicion = direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }


    public long guardarJugador(Context context) {



            SQLiteConnection dbHelper = new SQLiteConnection(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("id", id);
            values.put("nombres", nombres);
            values.put("apellidos", apellidos);
            values.put("pais", pais);
            values.put("edad", edad);
            values.put("posicion", posicion);

            long resultado = db.insert("jugadores", null, values);

            db.close();

            return resultado;
        }

    }









