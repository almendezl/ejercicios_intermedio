/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mundo.Ciudad;
import mundo.Interpol;

/**
 *
 * @author jorge
 */
public class InterfazInterpol extends JFrame {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Clase principal del mundo
     */
    private Interpol interpol;

    /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;

    /**
     * Panel con la imagen
     */
    private PanelImagen panelImagen;

    /**
     * Panel con el juego
     */
    private PanelJuego panelJuego;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Ventana principal de la aplicación. Construye los componentes gráficos y los coloca<br>
     */
    public InterfazInterpol() {
        // Crea la clase principal
        interpol = new Interpol();
        setTitle("Interpol");
        // Construye la forma
        getContentPane().setLayout(new BorderLayout());
        setSize(772,699);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Creación de los paneles aquí
        panelExtension = new PanelExtension(this);
        add(panelExtension, BorderLayout.SOUTH);
        panelImagen = new PanelImagen();
        add(panelImagen, BorderLayout.NORTH);
        panelJuego = new PanelJuego(this);
        add(panelJuego, BorderLayout.CENTER);
        iniciarJuego();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Muestra el dialogo para seleccionar un archivo del juego.
     */
    public void iniciarJuego() {
        try {
            // Seleccionar el archivo
            JFileChooser fc = new JFileChooser("./data/");
            fc.setDialogTitle("Seleccionar Juego");
            int resultado = fc.showOpenDialog(this);
            if(resultado == JFileChooser.APPROVE_OPTION) {
                File seleccionado = fc.getSelectedFile();
                Properties propiedades = new Properties();
                propiedades.load(new FileInputStream(seleccionado));
                // Se crea el modelo
                interpol.cargarJuego(propiedades);
                mostrarCaso();
                panelJuego.actualizar();
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el archivo: " + 
                    e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Muestra el dialogo con las pistas.
     */
    public void mostrarPistas() {
        DialogoPistas dialogo = new DialogoPistas(this, 
                interpol.darNombresLugaresCiudadActual());
        dialogo.setVisible(true);
    }

    /**
     * Muestra el dialogo de las posibles ciudades a las cuales se puede viajar.
     */
    public void mostrarViajes() {
        DialogoDestinos dialogo = new DialogoDestinos(this, 
                interpol.darNombresPosiblesDestinos());
        dialogo.setVisible(true);
    }

    /**
     * Retorna el caso en el que se esta trabajando actualmente
     * @return La descripción del caso
     */
    public String mostrarCaso() {
        return interpol.darCaso();
    }

    /**
     * Retorna la ciudad actual del mundo.
     * @return Diferente de null.
     */
    public Ciudad darCiudadActual() {
        return interpol.darCiudadActual();
    }

    /**
     * Retorna los días faltantes en el juego.
     * @return Entero mayor o igual a cero.
     */
    public int darDiasFaltantes() {
        return interpol.darDiasFaltantes();
    }

    /**
     * Muestra la pista de un lugar dado.
     * @param nombreLugar Nombre del lugar donde se quiere mostrar la pista.
     */
    public void mostrarPista(String nombreLugar) {
        JOptionPane.showMessageDialog(this, interpol.darPistaLugar(nombreLugar), 
                "Pista de " + nombreLugar, JOptionPane.INFORMATION_MESSAGE);
        panelJuego.actualizarDiasFaltantes();
        verificarTerminacionJuego();
    }

    /**
     * Cambia la ciudad que se quiere mostrar.
     * @param nombreCiudad Diferente de null.
     */
    public void viajar(String nombreCiudad) {
        interpol.viajar(nombreCiudad);
        panelJuego.actualizar();
        verificarTerminacionJuego();
    }

    /**
     * Muestra la interfaz de acuerdo al estado del mundo
     */
    private void verificarTerminacionJuego() {
        if(!interpol.ordenCapturaGenerada() && interpol.sospechosoEncontrado()) {
            JOptionPane.showMessageDialog(this, "Encontró al sospechoso. \nPero "
                    + "no puede ser arrestado por la falta de la orden de captura.", 
                    "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
            panelJuego.ocultarBotones();
            mostrarDialogoArbol();
        }
        else if(interpol.ordenCapturaGenerada() && interpol.sospechosoEncontrado()) {
            JOptionPane.showMessageDialog(this, "Sospechoso atrapado", 
                    "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
            panelJuego.ocultarBotones();
            mostrarDialogoArbol();
        }
        else if(interpol.darDiasFaltantes() <= 0 || interpol.ciudadActualEsHoja()) {
            JOptionPane.showMessageDialog(this, "El sospechoso se escapó", 
                    "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
            panelJuego.ocultarBotones();
            mostrarDialogoArbol();
        }
    }

    /**
     * Muestra el diálogo del árbol final
     */
    private void mostrarDialogoArbol() {
        DialogoMostrarArbol dialogo = new DialogoMostrarArbol(this, interpol);
        dialogo.setVisible(true);
    }

    /**
     * Muestra el diálogo del recorrido en inorden sobre el dialogo dado
     * @param padre Diálogo que es padre del nuevo dialogo
     */
    public void mostrarRecorridoInorden(DialogoMostrarArbol padre) {
        DialogoRecorrido dialogo = new DialogoRecorrido(padre, interpol.darInorden(), 
                "Recorrido Inorden");
        dialogo.setVisible(true);
    }

    /**
     * Muestra el diálogo del recorrido en preorden sobre el dialogo dado
     * @param padre Diálogo que es padre del nuevo dialogo
     */
    public void mostrarRecorridoPreorden(DialogoMostrarArbol padre) {
        DialogoRecorrido dialogo = new DialogoRecorrido(padre, interpol.darPreorden(), 
                "Recorrido Preorden");
        dialogo.setVisible(true);
    }

    /**
     * Muestra el diálogo del recorrido en postorden sobre el dialogo dado
     * @param padre Diálogo que es padre del nuevo dialogo
     */
    public void mostrarRecorridoPostorden(DialogoMostrarArbol padre) {
        DialogoRecorrido dialogo = new DialogoRecorrido(padre, interpol.darPostorden(), 
                "Recorrido Postorden");
        dialogo.setVisible(true);
    }

    /**
     * Muestra el diálogo de la altura del árbol sobre el dialogo dado
     * @param padre Diálogo que es padre del nuevo dialogo
     */
    public void mostrarAltura(DialogoMostrarArbol padre) {
        int altura = interpol.darAltura();
        JOptionPane.showMessageDialog(padre, "La altura del árbol es: " + altura, 
                "Altura del Árbol", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra el diálogo del peso del árbol sobre el dialogo dado
     * @param padre Diálogo que es padre del nuevo dialogo
     */
    public void mostrarPeso(DialogoMostrarArbol padre) {
        int peso = interpol.darPeso();
        JOptionPane.showMessageDialog(padre, "El peso del árbol es: " + peso, 
                "Peso del Árbol", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra el diálogo que indica los sospechosos
     */
    public void mostrarDialogoExpedirOrdenCaptura() {
        DialogoSospechoso dialogo = new DialogoSospechoso(this, 
                interpol.darSospechosos());
        dialogo.setVisible(true);
    }

    /**
     * Genera una orden de captura dado uno de los sospechosos
     * @param i Posición del sospechoso en la lista
     */
    public void generarOrdenCaptura(int i) {
        if(interpol.generarOrdenCaptura(i)) {
            JOptionPane.showMessageDialog(this, "Orden de captura generada. "
                    + "Ahora tiene que atrapar al sospechoso", "Orden de Captura", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            panelJuego.ocultarBotones();
            mostrarDialogoArbol();
            JOptionPane.showMessageDialog(this, "El sospechoso seleccionado no "
                    + "es correcto", "Orden de Captura", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1() {
        System.out.println(getSize());
        String resultado = interpol.metodo1();
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", 
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2() {
        String resultado = interpol.metodo2();
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", 
                JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Argumentos de lanzamiento
     */
    public static void main(String[] args) {
        InterfazInterpol interfaz = new InterfazInterpol();
        interfaz.setVisible(true);
    }

}
