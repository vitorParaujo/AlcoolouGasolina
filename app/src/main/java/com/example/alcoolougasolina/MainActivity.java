package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editPrecoAlcool, editPrecoGasolina;
    TextView textViewResultado;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool   = findViewById(R.id.editTextAlcool);
        editPrecoGasolina = findViewById(R.id.editTextGasolina);
        textViewResultado = findViewById(R.id.textViewResultado);
    }

    public void calcularPreco(View view){
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        boolean camposValidados = validarCampos(precoAlcool,precoGasolina);

        if (!camposValidados){
            Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }else{
            double valorAlccol = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble(precoGasolina);
            double resultado = valorAlccol/valorGasolina;
            if(resultado>= 0.7){
                textViewResultado.setText("Melhor colocar Gasolina");
            }else{
                textViewResultado.setText("Melhor colocar Alcool");
            }
        }


    }

    public boolean validarCampos(String pAlcool, String pGasolina){
        boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }

        if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;

    }
}