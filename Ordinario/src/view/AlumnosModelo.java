package view;

import controller.Controlador;
import model.Alumnos;

import javax.swing.table.AbstractTableModel;

public class AlumnosModelo extends AbstractTableModel {
    private Controlador control;
    public AlumnosModelo(Controlador controlador) {
        this.control = controlador;
    }

    @Override
    public int getRowCount() {
        return control.getAlumnosCount();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumnos a = control.getAlumno(rowIndex);
        switch (columnIndex){
            case 0:
            return a.getMatricula();
            case 1:
                return a.getNombre();
            case 2:
                return a.getPaterno();
            case 3:
                return a.getMaterno();
            case 4:
                return a.getFechaNacimiento();
            case 5:
                return a.getCarrera();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Matricula";
            case 1:
                return "Nombre";
            case 2:
                return "Apellido Paterno";
            case 3:
                return "Apellido Materno";
            case 4:
                return "Fecha de Nacimiento";
            case 5:
                return "Carrera";
            default:
                throw new AssertionError();
        }
    }
}
