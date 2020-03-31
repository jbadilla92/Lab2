package com.example.lab2.AccesoDatos;

import com.example.lab2.LogicaNegocio.Alumno;
import com.example.lab2.LogicaNegocio.Curso;
import com.example.lab2.LogicaNegocio.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 26/03/2018.
 */

public class ModelData {

    private List<Curso> cursoList;
    private List<Alumno> alumnoList;

    public ModelData() {
        cursoList = new ArrayList<>();
        alumnoList = new ArrayList<>();
        prepareAlumnoData();
        prepareCursoData();
    }

    public void prepareCursoData() {
        Curso curso = new Curso("ST", "Soporte", 3, 4);
        cursoList.add(curso);
        curso = new Curso("FD", "Fundamentos", 3, 4);
        cursoList.add(curso);
        curso = new Curso("PG1", "Programacion I", 3, 4);
        cursoList.add(curso);
        curso = new Curso("PG2", "Programacion II", 3, 4);
        cursoList.add(curso);
        curso = new Curso("PG3", "Programacion III", 3, 4);
        cursoList.add(curso);
        curso = new Curso("PG4", "Programacion IV", 3, 4);
        cursoList.add(curso);
        curso = new Curso("EDA", "Estructuras Datos", 3, 4);
        cursoList.add(curso);
        curso = new Curso("EDI", "Estructuras Discretas", 3, 4);
        cursoList.add(curso);

        curso = new Curso("MV", "Moviles", 3, 4);
        cursoList.add(curso);
        curso = new Curso("PP", "Paradigmas", 3, 4);
        cursoList.add(curso);

        curso = new Curso("AQ", "Arquitectura", 3, 4);
        cursoList.add(curso);

        curso = new Curso("RD", "Redes", 3, 4);
        cursoList.add(curso);
        // de adm
        curso = new Curso("FAD", "Fundamentos de Administracion", 3, 4);
        cursoList.add(curso);
        curso = new Curso("C1", "Contabilidad I", 3, 4);
        cursoList.add(curso);
        // de fisica
        curso = new Curso("FF", "Fundamentos de Fisica", 3, 4);
        cursoList.add(curso);
        curso = new Curso("F1", "Fisica I", 3, 4);
        cursoList.add(curso);
        // de matematica
        curso = new Curso("FM", "Fundamentos de Matematica", 3, 4);
        cursoList.add(curso);
        curso = new Curso("HB1", "Historia Basica I", 3, 4);
        cursoList.add(curso);
        // de science fiction
        curso = new Curso("M1", "Matrix 1", 3, 4);
        cursoList.add(curso);
        curso = new Curso("BDR", "Blade Runner 2049", 3, 4);
        cursoList.add(curso);
        // de animation
        curso = new Curso("ZOO", "Zootopia", 3, 4);
        cursoList.add(curso);
        curso = new Curso("VIN", "Vecinos Invasores", 3, 4);
        cursoList.add(curso);
        // de classics
        curso = new Curso("TIT", "Titanic", 3, 4);
        cursoList.add(curso);
        curso = new Curso("DDA", "Donnie Darko", 3, 4);
        cursoList.add(curso);
        // de commedy
        curso = new Curso("WDG", "War Dogs", 3, 4);
        cursoList.add(curso);
        curso = new Curso("ANT", "Ant Man", 3, 4);
        cursoList.add(curso);
        // de Science Fiction & Fantasy
        curso = new Curso("JL", "Justice League", 3, 4);
        cursoList.add(curso);
        curso = new Curso("AVG", "Avengers", 3, 4);
        cursoList.add(curso);
    }

    public void prepareAlumnoData() {
        Alumno alumno = new Alumno("123", "Jose", 321, "@Jose", "23/06/1985", "Ingenieria en sistemas");
        alumnoList.add(alumno);

        alumno = new Alumno("321", "Juan", 213, "@Juan", "24/06/1986", "Administracion de empresas");
        alumnoList.add(alumno);

        alumno = new Alumno("234", "Miguel", 3241, "@Miguel", "25/06/1987", "Relaciones internacionales");
        alumnoList.add(alumno);

        alumno = new Alumno("345", "Manuel", 3251, "@Manuel", "26/06/1988", "Ingenieria industrial");
        alumnoList.add(alumno);

        alumno = new Alumno("456", "Luis", 567, "@Luis", "27/06/1989", "Ingenieria agricola");
        alumnoList.add(alumno);

        alumno = new Alumno("567", "Alberto", 8765, "@Alberto", "28/06/1990", "Ingenieria civil");
        alumnoList.add(alumno);
    }

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    public List<Usuario> getUsuariosList() {
        List<Usuario> users = new ArrayList<>();
        users.add(new Usuario("@admin", "admin", "administrador", "111"));
        users.add(new Usuario("@admin2", "admin", "administrador", "222"));
        users.add(new Usuario("@matric", "matric", "matriculador", "333"));
        users.add(new Usuario("@matric1", "matric", "matriculador", "444"));
        users.add(new Usuario("@matric2", "matric", "matriculador", "555"));
        users.add(new Usuario("@matric3", "matric", "matriculador", "555"));
        return users;
    }
}
