package view;

import controller.Controlador;
import exceptions.AlumnoExistenteException;
import interfaces.AlumnoListener;
import model.Alumnos;
import model.Carrera;
import model.Fecha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalFrame extends JFrame {
    private EncabezadPanel pnlEncabezado;
    private WorkPanel pnlWork;
    private BusquedaPanel pnlBusqueda;
    private Controlador controlador;
    private AlumnoDialog dlogAlumno;
    public PrincipalFrame() throws HeadlessException {
        super("Control Escolar");
        super.setLayout(new BorderLayout());
        super.setSize(700,500);
        super.setLocationRelativeTo(null);

        dlogAlumno = new AlumnoDialog(this);
        dlogAlumno.addOyente(new AlumnoListener(){
            @Override
            public void aceptarButtonClick(Alumnos alumno) {
                try {
                    controlador.addAlumno(alumno);
                    dlogAlumno.setVisible(false);
                } catch (AlumnoExistenteException e) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this,
                            "La Matricula ha sido Insertada Anteriormente",
                            "Matricula Invalida",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        controlador = new Controlador();
        ponerDatos();

        pnlEncabezado = new EncabezadPanel();
        pnlWork = new WorkPanel(controlador);
        pnlBusqueda = new BusquedaPanel();

        super.setJMenuBar(createMenuBar());

        super.add(pnlEncabezado, BorderLayout.NORTH);
        super.add(pnlWork, BorderLayout.CENTER);
        super.add(pnlBusqueda, BorderLayout.SOUTH);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void ponerDatos() {
        Alumnos a = new Alumnos("a", "viktor", "Acevedo", "Arzola", new Fecha(4,9,2001), Carrera.SISTEMAS);
        Alumnos b = new Alumnos("b");
        Alumnos c = new Alumnos("c");
        Alumnos d = new Alumnos("d");

        try {
            controlador.addAlumno(a);
            controlador.addAlumno(b);
            controlador.addAlumno(c);
            controlador.addAlumno(d);
        } catch (AlumnoExistenteException e) {
            e.printStackTrace();
        }
    }

    private JMenuBar createMenuBar(){
        JMenuBar bar = new JMenuBar();
        JMenu mmArchivo = new JMenu("Archivo");
        JMenuItem miNuevo = new JMenuItem("Nuevo Alumno..");
        miNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlogAlumno.setVisible(true);
            }
        });
        JMenuItem miSalir = new JMenuItem("Salir");
        miSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mmArchivo.add(miNuevo);
        mmArchivo.addSeparator();
        mmArchivo.add(miSalir);

        JMenu mmAyuda = new JMenu("Ayuda");
        JMenuItem miAcercaDe = new JMenuItem("Acerca de..");
        mmAyuda.add(miAcercaDe);

        bar.add(mmArchivo);
        bar.add(mmAyuda);
        return  bar;
    }
}
