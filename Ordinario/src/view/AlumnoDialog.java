package view;

import interfaces.AlumnoListener;
import model.Alumnos;
import model.Carrera;
import model.Fecha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlumnoDialog extends JDialog {
    private JPanel pnlWork;
    private JPanel pnlBotones;

    private JButton btnAceptar;
    private JButton btnCancelar;

    private AlumnoListener oyente;
    public AlumnoDialog(Frame owner) {
        super(owner, "",true);
        super.setSize(400,400);
        super.setLocationRelativeTo(owner);
        super.setLayout(new BorderLayout());

        pnlWork = new JPanel();
        pnlBotones = new JPanel();
        pnlBotones.setBackground(Color.RED);
        pnlBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alumnos dataAlumno = new Alumnos("1234","Pepe", "Aguilar", "Acevedo", new Fecha(5,5,2005), Carrera.PSICOLOGIA);
                oyente.aceptarButtonClick(dataAlumno);
            }
        });

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlumnoDialog.this.setVisible(false);
            }
        });
        pnlBotones.add(btnAceptar);
        pnlBotones.add(btnCancelar);

        super.add(pnlBotones, BorderLayout.SOUTH);
        super.add(pnlWork, BorderLayout.CENTER);

        super.setVisible(false);
    }

    public void addOyente(AlumnoListener oyente) {
        this.oyente = oyente;
    }
}
