package com.example.myapplication;

/*

Author: ING. CARLOS OTERO RAMÍREZ

 */

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String guardar = "";
    int num, unidades, decenas;

    private EditText editText1;
    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Nombre del Número");

        editText1 = findViewById(R.id.AM1_id2);
        button1 = findViewById(R.id.AM1_id3);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.AM1_id4);
        button2.setOnClickListener(this);
    }

    public void dialogoAlerta(String titulo, String mensaje){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(mensaje)
                .setTitle(titulo)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int posicion) {
                        dialog.cancel();
                    }
                });
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.AM1_id3:
                if(editText1.getText().toString().isEmpty()){
                    dialogoAlerta("Mensaje de Error", "El Campo de Texto esta Vacio");
                } else if(editText1.getText().toString().length() > 2) {
                    dialogoAlerta("Mensaje de Error", "Solo Puede Ingresar un Número de dos Digitos");
                    editText1.setText("");
                } else {
                    num = Integer.parseInt(editText1.getText().toString());
                    unidades = num%10;
                    decenas = num/10;

                    switch(decenas){
                        case 0:
                            guardar="";
                            break;
                        case 1:
                            guardar="Diez y ";
                            break;
                        case 2:
                            guardar="Veinte y ";
                            break;
                        case 3:
                            guardar="Treinta y ";
                            break;
                        case 4:
                            guardar="Cuarenta y ";
                            break;
                        case 5:
                            guardar="Ciencuenta y ";
                            break;
                        case 6:
                            guardar="Sesenta y ";
                            break;
                        case 7:
                            guardar="Setenta y ";
                            break;
                        case 8:
                            guardar="Ochenta y ";
                            break;
                        case 9:
                            guardar="Noventa y ";
                            break;
                    }

                    switch(unidades){
                        case 0:
                            guardar+="";
                            break;
                        case 1:
                            guardar+="Uno";
                            break;
                        case 2:
                            guardar+="Dos";
                            break;
                        case 3:
                            guardar+="Tres";
                            break;
                        case 4:
                            guardar+="Cuatro";
                            break;
                        case 5:
                            guardar+="Cinco";
                            break;
                        case 6:
                            guardar+="Seis";
                            break;
                        case 7:
                            guardar+="Siete";
                            break;
                        case 8:
                            guardar+="Ocho";
                            break;
                        case 9:
                            guardar+="Nueve";
                            break;
                    }
                    dialogoAlerta("Mensaje de Información", guardar);
                }
                break;
            case R.id.AM1_id4:
                System.exit(0);
                break;
        }
    }
}