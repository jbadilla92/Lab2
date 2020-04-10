package com.example.lab2.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2.LogicaNegocio.Alumno;
import com.example.lab2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AddUpdAlumnoActivity extends AppCompatActivity {
    private FloatingActionButton fBtn;
    private boolean editable = true;
    private EditText nomFld;
    private EditText cedFld;
    private EditText emailFld;
    private EditText telFld;
    private EditText fechaFld;
    private EditText carreraFld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_upd_alumno);
        editable = true;

        // button check
        fBtn = findViewById(R.id.addUpdAlumnoBtn);

        //cleaning stuff
        nomFld = findViewById(R.id.nombreAddUpdAlum);
        cedFld = findViewById(R.id.cedulaAddUpdAlum);
        emailFld = findViewById(R.id.emailAddUpdAlum);
        telFld=findViewById(R.id.telefonoAddUpdAlum);
        fechaFld=findViewById(R.id.fechaAddUpdAlum);;
        carreraFld=findViewById(R.id.carreraAddUpdAlum);;
        nomFld.setText("");
        cedFld.setText("");
        emailFld.setText("");
        telFld.setText("");
        fechaFld.setText("");
        carreraFld.setText("");

        //receiving data from admAlumnoActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            editable = extras.getBoolean("editable");
            if (editable) {   // is editing some row
                Alumno aux = (Alumno) getIntent().getSerializableExtra("alumno");
                cedFld.setText(aux.getCedula());
                cedFld.setEnabled(false);
                nomFld.setText(aux.getNombre());
                emailFld.setText(aux.getEmail());
                telFld.setText(Integer.toString(aux.getTelefono()));
                fechaFld.setText(aux.getFechaNacimiento());
                carreraFld.setText(aux.getCarrera());
                //edit action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editAlumno();
                    }
                });
            } else {         // is adding new Carrera object
                //add new action
                fBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addAlumno();
                    }
                });
            }
        }
    }

    public void addAlumno() {
        if (validateForm()) {
            //do something
            Alumno prof = new Alumno(cedFld.getText().toString(), nomFld.getText().toString(),
                    Integer.parseInt(telFld.getText().toString()),
                    emailFld.getText().toString(),
                    fechaFld.getText().toString(),
                    carreraFld.getText().toString());
            Intent intent = new Intent(getBaseContext(), AdmAlumnoActivity.class);
            //sending Alumno data
            intent.putExtra("addalumno", prof);
            startActivity(intent);
            finish(); //prevent go back
        }
    }

    public void editAlumno() {
        if (validateForm()) {
            Alumno prof = new Alumno(cedFld.getText().toString(), nomFld.getText().toString(),
                    Integer.parseInt(telFld.getText().toString()),
                    emailFld.getText().toString(),
                    fechaFld.getText().toString(),
                    carreraFld.getText().toString());
            Intent intent = new Intent(getBaseContext(), AdmAlumnoActivity.class);
            //sending Alumno data
            intent.putExtra("editalumno", prof);
            startActivity(intent);
            finish(); //prevent go back
        }
    }

    public boolean validateForm() {
        int error = 0;
        if (TextUtils.isEmpty(this.nomFld.getText())) {
            nomFld.setError("Nombre requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.cedFld.getText())) {
            cedFld.setError("Cedula requerida");
            error++;
        }
        if (TextUtils.isEmpty(this.emailFld.getText())) {
            emailFld.setError("Email requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.telFld.getText())) {
            telFld.setError("Telefono requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.fechaFld.getText())) {
            fechaFld.setError("Fecha requerido");
            error++;
        }
        if (TextUtils.isEmpty(this.carreraFld.getText())) {
            carreraFld.setError("Carrera requerido");
            error++;
        }
        if (error > 0) {
            Toast.makeText(getApplicationContext(), "Algunos errores", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
