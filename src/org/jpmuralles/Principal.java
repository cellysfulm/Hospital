/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jpmuralles;

import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.layout.AnchorPane;
import org.jpmuralles.controller.MedicoController;
import org.jpmuralles.controller.MenuPrincipalController;
import org.jpmuralles.controller.ProgramadorController;
import org.jpmuralles.db.Conexion;

        

public class Principal extends Application {
    public final String PAQUETE_VISTA = "/org/jpmuralles/view/";
    private Stage escenarioPrincipal;
    private Scene escena;
 
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
     /*try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_Buscar_Medicos(?)}");
            procedimiento.setInt (1, 1);
            ResultSet registro = procedimiento.executeQuery();
            while(registro.next()){
                System.out.println(registro.getInt("codigoMedico"));
                System.out.println(registro.getInt("licenciaMedica"));
        }
        }catch (SQLException e){
            e.printStackTrace();
        }*/
        
        
        this.escenarioPrincipal = escenarioPrincipal;
        escenarioPrincipal.setTitle("Hospital de Infectologia");
        menuPrincipal();
        escenarioPrincipal.show();
    }

    
    
    public void menuPrincipal(){
 

        try{
            MenuPrincipalController menuPrincipal = (MenuPrincipalController)cambiarEscena("HospitalVista.fxml",745,452);
            menuPrincipal.setEscenarioPrincipal(this);
                 
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        
    } 
    
     public void ventanaMedicos(){
        try{
           MedicoController medicoController = (MedicoController)cambiarEscena("MedicosVista.fxml",685,428);
            medicoController.setEscenarioPrincipal(this); 
            
                 
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        
    } 
     public void ventanaGuapol(){
        try{
            ProgramadorController programadorc = (ProgramadorController)cambiarEscena("ProgramadorVista.fxml",600,400);
            programadorc.setEscenarioPrincipal(this); 
            
                 
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        
    } 
     public Initializable cambiarEscena(String fxml, int ancho, int alto) throws Exception{
        Initializable resultado = null;
        FXMLLoader cargadorFXML= new FXMLLoader();
        InputStream archivo = Principal.class.getResourceAsStream(PAQUETE_VISTA+fxml);
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        cargadorFXML.setLocation(Principal.class.getResource(PAQUETE_VISTA+fxml));
        Parent AnchorPane;
        escena =new Scene((AnchorPane)cargadorFXML.load(archivo),ancho,alto);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        resultado = (Initializable)cargadorFXML.getController();
        return resultado;
        
    }
    public static void main(String[] args) {
        launch(args);
    }

    

   
     
    
 }
    

    