package view;

import controller.Controlador;

import javax.swing.*;
import java.awt.*;

public class WorkPanel extends JPanel {
    private JTable tableAlumnos;
    private AlumnosModelo modeloTabla;
    public WorkPanel(Controlador controlador) {
        super.setBackground(Color.GREEN);
        super.setLayout(new BorderLayout());

        modeloTabla = new AlumnosModelo(controlador);
        tableAlumnos = new JTable(modeloTabla);

        super.add(new JScrollPane(tableAlumnos), BorderLayout.CENTER);
    }

    public JTable getTableAlumnos() {
        return tableAlumnos;
    }
}
