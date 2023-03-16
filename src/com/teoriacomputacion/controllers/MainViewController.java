package com.teoriacomputacion.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.teoriacomputacion.model.OperarCadenas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainViewController implements Initializable{

    @FXML
    private Text lblCad1;

    @FXML
    private Text lblCad2;

    @FXML
    private ComboBox<String> cmbOperaciones;

    @FXML
    private TextField txtCadena1;

    @FXML
    private TextField txtCadena2;

    @FXML
    private TextArea txtResultado;

    @FXML
    private Button btnOperar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private ListView myListView;

    private static OperarCadenas model;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        model = new OperarCadenas();
        cmbOperaciones.setPromptText("Seleccione una Operación:");
        cmbOperaciones.getItems().addAll("Concatenar", "Potenciar", "Longitud", "Reflexion", "Prefijos", "Sufijos");
        myListView.setVisible(false);

        cmbOperaciones.setOnAction((event) -> {
            if(cmbOperaciones.getValue().equals("Concatenar")) {

                myListView.setVisible(false);
                lblCad2.setVisible(true);
                lblCad1.setText("Cadena 1:");
                lblCad2.setText("Cadena 2:");
                txtCadena2.setVisible(true);

            }else if(cmbOperaciones.getValue().equals("Longitud") || cmbOperaciones.getValue().equals("Reflexion")){
                
                txtCadena2.setText("");
                myListView.setVisible(false);
                txtCadena2.setVisible(false);
                lblCad1.setText("Cadena:");
                lblCad2.setVisible(false);

            }else if(cmbOperaciones.getValue().equals("Potenciar")){
                
                txtCadena2.setText("");
                myListView.setVisible(false);
                txtCadena2.setVisible(true);
                lblCad2.setVisible(true);
                lblCad1.setText("Cadena:");
                lblCad2.setText("Ingrese #:");

            }else{
                
                txtCadena2.setText("");
                myListView.setVisible(true);
                txtCadena2.setVisible(false);
                lblCad1.setText("Cadena:");
                lblCad2.setVisible(false);
                txtResultado.setEditable(false); 
            }
        }); 
        
    }

    @FXML
    void handleButtonOperar(ActionEvent event) {
        try {
            if (cmbOperaciones.getValue().equals("Concatenar") && !txtCadena1.getText().isEmpty() && !txtCadena2.getText().isEmpty()) {
                
                txtResultado.setText("");
                myListView.getItems().clear();
                txtResultado.setText(model.concatenar(txtCadena1.getText(), txtCadena2.getText()));

            } else if(cmbOperaciones.getValue().equals("Potenciar") && !txtCadena1.getText().isEmpty() && !txtCadena2.getText().isEmpty()) {
                
                txtResultado.setText("");
                myListView.getItems().clear();
                txtResultado.setText(model.potenciar(txtCadena1.getText(), Integer.parseInt(txtCadena2.getText())));

            } else if (cmbOperaciones.getValue().equals("Longitud") && !txtCadena1.getText().isEmpty()) {
                
                txtResultado.setText("");
                myListView.getItems().clear();
                txtResultado.setText(model.longitud(txtCadena1.getText()));

            } else if (cmbOperaciones.getValue().equals("Reflexion") && !txtCadena1.getText().isEmpty()) {
                
                txtResultado.setText("");
                myListView.getItems().clear();
                txtResultado.setText(model.reflexion(txtCadena1.getText()));

            } else if (cmbOperaciones.getValue().equals("Prefijos") && !txtCadena1.getText().isEmpty()) {
                
                txtResultado.setText("");
                txtResultado.setText("------------------------------->>>");
                myListView.getItems().clear();
                myListView.getItems().addAll(model.prefijo(txtCadena1.getText()));

            } else if (cmbOperaciones.getValue().equals("Sufijos") && !txtCadena1.getText().isEmpty()) {
                
                txtResultado.setText("");
                txtResultado.setText("------------------------------->>>");
                myListView.getItems().clear();
                myListView.getItems().addAll(model.sufijo(txtCadena1.getText()));
                myListView.set

            } else {
                JOptionPane.showMessageDialog(null, "Rellene los campos", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha Ocurrido un error " + e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void handleButtonLimpiar(ActionEvent event) {
        txtCadena1.setText("");
        txtCadena2.setText("");
        txtResultado.setText("");
        myListView.getItems().clear();
    }
}
