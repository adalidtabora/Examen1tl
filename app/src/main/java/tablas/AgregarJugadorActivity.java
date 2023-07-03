package tablas;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.examen1tl.R;

import java.util.ArrayList;
import java.util.List;

import Config.Jugador;
public class AgregarJugadorActivity extends Activity {
    private EditText editTextId;
    private EditText editTextNombre;

    private EditText editTextApellido;
    private EditText editTextEdad;
    private Spinner spinnerPais;
    private Spinner spinnerPosicion;
    private Button buttonGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_jugador);

        editTextId = findViewById(R.id.editTextId);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextEdad = findViewById(R.id.editTextEdad);
        spinnerPais = findViewById(R.id.spinnerPais);
        spinnerPosicion = findViewById(R.id.spinnerPosicion);
        buttonGuardar = findViewById(R.id.buttonGuardar);

        // Configurar el adaptador para el spinner de países
        List<String> paises = new ArrayList<>();
        paises.add("Honduras");
        paises.add("Mexico");
        paises.add("Qatar");
        paises.add("Haiti");
        ArrayAdapter<String> paisAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, paises);
        paisAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPais.setAdapter(paisAdapter);

        // Configurar el adaptador para el spinner de posiciones
        List<String> posiciones = new ArrayList<>();
        posiciones.add("Portero");
        posiciones.add("Central");
        posiciones.add("Mediocampista");
        posiciones.add("Delantero");
        ArrayAdapter<String> posicionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, posiciones);
        posicionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPosicion.setAdapter(posicionAdapter);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores ingresados por el usuario
                int id = Integer.parseInt(editTextId.getText().toString());
                String nombres = editTextNombre.getText().toString();
                String apellidos = editTextApellido.getText().toString();
                int edad = Integer.parseInt(editTextEdad.getText().toString());
                String pais = spinnerPais.getSelectedItem().toString();
                String posicion = spinnerPosicion.getSelectedItem().toString();

                // Crear el objeto Jugador
                Jugador jugador = new Jugador(id, nombres, apellidos, pais, edad, posicion);

                // Guardar el jugador en la base de datos
                long resultado = jugador.guardarJugador(AgregarJugadorActivity.this);

                if (resultado != -1) {
                    Toast.makeText(AgregarJugadorActivity.this, "Jugador guardado correctamente", Toast.LENGTH_SHORT).show();
                    // Reiniciar los campos del formulario
                    editTextId.setText("");
                    editTextNombre.setText("");
                    editTextApellido.setText("");
                    editTextEdad.setText("");
                    spinnerPais.setSelection(0);
                    spinnerPosicion.setSelection(0);
                } else {
                    Toast.makeText(AgregarJugadorActivity.this, "Error al guardar el jugador", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
