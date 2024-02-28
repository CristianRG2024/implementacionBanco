/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package implementacionbanco;

import Modelo.Cajero;
import cola.Cola;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.web.WebView;
import modelo.Clientes;


/**
 *
 * @author CRISTIANR
 */
public class FXMLDocumentController implements Initializable {

    private Timer simulationTimer;
    private Cola<Clientes> cola;
    private Cajero cajero1;
    private Cajero cajero2;
    private Cajero cajero3;
    private Cajero cajero4;
    private Cajero cajero5;
    private Cajero cajero6;
    @FXML
    private Label label;
    
    @FXML 
    private WebView tabla11;
    @FXML
    private Button button;
    @FXML
    private WebView tabla1;
    @FXML
    private WebView tabla2;
    @FXML
    private ProgressIndicator timer1;
    @FXML
    private ProgressIndicator timer2;
    @FXML
    private ProgressIndicator timer3;
    @FXML
    private ProgressIndicator timer4;
    @FXML
    private ProgressIndicator timer6;
    @FXML
    private ProgressIndicator timer5;
    @FXML
    private Button button1;
    @FXML
    private Button button2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cola = new Cola<>();
        simulationTimer = new Timer();
        cajero1 = new Cajero(3000, 7000);
        cajero2 = new Cajero(3000, 7000);
        cajero3 = new Cajero(3000, 7000);
        cajero4 = new Cajero(3000, 7000);
        cajero5 = new Cajero(3000, 7000);
        cajero6 = new Cajero(3000, 7000);

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        simulationTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Clientes nuevoCliente = generarClienteAleatorio();
                cola.encolar(nuevoCliente);

                ActualizarInterfazGrafica();
            }
        }, 0, 5000);

    }

    @FXML
    private void cerrar(ActionEvent event) {
        simulationTimer.cancel();
    }
    @FXML
   private void ActualizarInterfazGrafica() {
    Platform.runLater(() -> {
        tabla1.getEngine().loadContent(cola.toString());

        actualizarCajero(timer1, cajero1);
        actualizarCajero(timer2, cajero2);
        actualizarCajero(timer3, cajero3);
        actualizarCajero(timer4, cajero4);
        actualizarCajero(timer5, cajero5);
        actualizarCajero(timer6, cajero6);
    });
}
   @FXML
    private void actualizarCajero(ProgressIndicator timer, Cajero cajero) {
        if (cajero.estaOcupado()) {
            timer.setVisible(true);
            timer.setProgress(cajero.getTiempoAcumulado() / cajero.getTiempoTransaccion());
        } else {
            timer.setVisible(false);
        }
    }
    @FXML
    private Clientes generarClienteAleatorio() {
        Random random = new Random();

        int edad = random.nextInt(43) + 17;
        int tiempo = random.nextInt(1000) + 0;

        return new Clientes(Integer.toString(edad), Integer.toString(tiempo));
    }

}