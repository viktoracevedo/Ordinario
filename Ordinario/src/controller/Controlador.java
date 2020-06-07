package controller;

import exceptions.AlumnoExistenteException;
import exceptions.AlumnoInnexistenteException;
import model.Alumnos;

import java.util.ArrayList;

public class Controlador {
    private ArrayList<Alumnos> listaAlumnos;

    public Controlador() {

        listaAlumnos = new ArrayList<>();
    }

    public void addAlumno(Alumnos alumno) throws AlumnoExistenteException{
        if(listaAlumnos.contains(alumno)){
            throw new AlumnoExistenteException();
        }
        listaAlumnos.add(alumno);
    }

    public ArrayList<Alumnos> getListaAlumnos() {
        return listaAlumnos;
    }

    public Alumnos getAlumno(String matricula) throws AlumnoInnexistenteException{
        int index = listaAlumnos.indexOf(new Alumnos(matricula));
        if(index < 0){
            throw new AlumnoInnexistenteException();
        }
            return listaAlumnos.get(index);
    }

    public int getAlumnosCount(){
        return listaAlumnos.size();
    }

    public Alumnos getAlumno(int index){
        return listaAlumnos.get(index);
    }

//    public static void main(String[] args) {
//        Controlador control = new Controlador();
//        Alumnos a = new Alumnos("a");
//        Alumnos b = new Alumnos("b");
//        Alumnos c = new Alumnos("c");
//        c.setNombre("karimnot");
//        try {
//            control.addAlumno(a);
//            control.addAlumno(b);
//            control.addAlumno(c);
//            System.out.println("final");
//            Alumnos tmp = control.getAlumno("c");
//            System.out.println(c.getNombre());
//        } catch (AlumnoExistenteException | AlumnoInnexistenteException ex) {
//            ex.printStackTrace();
//        }
//    }
}
