
package org.jpmuralles.controller;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import org.jpmuralles.Principal;

public class ProgramadorController implements Initializable{
   
   @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    private Principal escenarioPrincipal;

  
  
    
    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }
    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    public void menuPrincipal(){
        escenarioPrincipal.menuPrincipal();
    }

   
    
}
