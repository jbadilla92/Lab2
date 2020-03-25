package com.example.lab2.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.lab2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class NavDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        this.userPrivileges();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawer.openDrawer(GravityCompat.START);
    }

    private void userPrivileges() {
        //getting logged user
        SharedPreferences prefs = this.getSharedPreferences(getString(R.string.preference_user_key), Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.preference_user_key_default);
        String privilegio = prefs.getString(getString(R.string.preference_user_key), defaultValue);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        MenuItem holder;
        //using privileges to lock data
        switch (privilegio) {
            case "administrador":
                holder = menu.findItem(R.id.nav_ofertaAcademica);
                holder.setEnabled(true);
                holder = menu.findItem(R.id.nav_matricula);
                holder.setEnabled(true);
                holder = menu.findItem(R.id.nav_consultaHistorial);
                holder.setEnabled(true);
                holder = menu.findItem(R.id.nav_curso);
                holder.setEnabled(true);
                holder = menu.findItem(R.id.nav_carrera);
                holder.setEnabled(true);
                holder = menu.findItem(R.id.nav_profesor);
                holder.setEnabled(true);
                holder = menu.findItem(R.id.nav_alumno);
                holder.setEnabled(true);
                holder = menu.findItem(R.id.nav_ciclo);
                holder.setEnabled(true);
                holder = menu.findItem(R.id.nav_seguridad);
                holder.setEnabled(true);
                break;
            case "matriculador":
                holder = menu.findItem(R.id.nav_matricula);
                holder.setEnabled(true);
                break;
            case "profesor":
                holder = menu.findItem(R.id.nav_registroHoras);
                holder.setEnabled(true);
                break;
            case "estudiante":
                holder = menu.findItem(R.id.nav_consultaHistorial);
                holder.setEnabled(true);
                break;
            default:    //if is none
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            this.moveTaskToBack(true);
            //super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //getting logged user
        SharedPreferences prefs = this.getSharedPreferences(getString(R.string.preference_user_key), Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.preference_user_key_default);
        String privilegio = prefs.getString(getString(R.string.preference_user_key), defaultValue);

        if (id == R.id.nav_ofertaAcademica) {
            Toast.makeText(getApplicationContext(), "Oferta Academica", Toast.LENGTH_SHORT).show();
            abrirOfertaAcademica();
        } else if (id == R.id.nav_matricula) {
            Toast.makeText(getApplicationContext(), "Matricula", Toast.LENGTH_SHORT).show();
            abrirAdmAlumno();
        } else if (id == R.id.nav_registroHoras) {
            Toast.makeText(getApplicationContext(), "Registro de Notas", Toast.LENGTH_SHORT).show();
            abrirRegistroNotas();
        } else if (id == R.id.nav_consultaHistorial) {
            Toast.makeText(getApplicationContext(), "Consulta de Historial", Toast.LENGTH_SHORT).show();
            if (privilegio.equals("administrador"))
                abrirAdmHistorial();
            else
                abrirHistorial();
        } else if (id == R.id.nav_alumno) {
            Toast.makeText(getApplicationContext(), "Alumnos", Toast.LENGTH_SHORT).show();
            abrirAdmAlumno();
        } else if (id == R.id.nav_ciclo) {
            Toast.makeText(getApplicationContext(), "Ciclos", Toast.LENGTH_SHORT).show();
            abrirAdmCiclo();
        } else if (id == R.id.nav_curso) {
            Toast.makeText(getApplicationContext(), "Cursos", Toast.LENGTH_SHORT).show();
            abrirAdmCurso();
        } else if (id == R.id.nav_profesor) {
            Toast.makeText(getApplicationContext(), "Profesores", Toast.LENGTH_SHORT).show();
            abrirAdmProfesor();
        } else if (id == R.id.nav_carrera) {
            Toast.makeText(getApplicationContext(), "Carreras", Toast.LENGTH_SHORT).show();
            abrirAdmCarrera();
        } else if (id == R.id.nav_logout) {
            Toast.makeText(getApplicationContext(), "Log Out", Toast.LENGTH_SHORT).show();
            abrirLogin();
        } else if (id == R.id.nav_seguridad) {
            Toast.makeText(getApplicationContext(), "Seguridad", Toast.LENGTH_SHORT).show();
            abrirAdmSeguridad();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void abrirLogin() {
        finish();
        Intent a = new Intent(this, LoginActivity.class);
        startActivity(a);
    }

    public void abrirAdmCarrera() {
        Intent intent = new Intent(this, AdmCarreraActivity.class);
        startActivity(intent);
    }

    public void abrirAdmCurso() {
        Intent intent = new Intent(this, AdmCursoActivity.class);
        startActivity(intent);
    }

    public void abrirAdmProfesor() {
        Intent intent = new Intent(this, AdmProfesorActivity.class);
        startActivity(intent);
    }

    public void abrirAdmAlumno() {
        Intent intent = new Intent(this, AdmAlumnoActivity.class);
        startActivity(intent);
    }

    public void abrirAdmCiclo() {
        Intent intent = new Intent(this, AdmCicloActivity.class);
        startActivity(intent);
    }

    public void abrirOfertaAcademica() {
        Intent intent = new Intent(this, OfertaAcademicaActivity.class);
        startActivity(intent);
    }

    public void abrirAdmSeguridad() {
        Intent intent = new Intent(this, AdmSeguridadActivity.class);
        startActivity(intent);
    }

    public void abrirHistorial() {
        Intent intent = new Intent(this, HistorialActivity.class);
        startActivity(intent);
    }

    public void abrirRegistroNotas() {
        Intent intent = new Intent(this, RegistroNotasActivity.class);
        startActivity(intent);
    }

    public void abrirAdmHistorial() {
        Intent intent = new Intent(this, AdmAlumnoActivity.class);
        intent.putExtra("from", "historial");
        startActivity(intent);
        finish();
    }
}
