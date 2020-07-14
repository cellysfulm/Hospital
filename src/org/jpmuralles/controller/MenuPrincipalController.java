package org.jpmuralles.controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.jpmuralles.Principal;


public class MenuPrincipalController implements Initializable {
     private Principal escenarioPrincipal;
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    
    public void ventanaMedico(){
       escenarioPrincipal.ventanaMedicos();
   }
    public void ventanaGuapo(){
        escenarioPrincipal.ventanaGuapol();
    }
    
   public void Salir(){
     
       System.exit(0);
   }
   
    
}
