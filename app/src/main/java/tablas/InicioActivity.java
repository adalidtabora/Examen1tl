package tablas;

import  android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;




import com.example.examen1tl.R;

public class InicioActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_activity);
    }
    public void agregar_jugador_activity(View view){
        Intent jugador = new Intent(this, AgregarJugadorActivity.class);
        startActivity(jugador);
    }


}
