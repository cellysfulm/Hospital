
package org.jpmuralles.controller;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import org.jpmuralles.Principal;
import org.jpmuralles.bean.Medico;
import org.jpmuralles.db.Conexion;
import eu.schudt.javafx.controls.calendar.DatePicker;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javafx.event.EventType;
import org.jpmuralles.bean.Genero;




public class MedicoController implements Initializable{
    private enum operaciones{Nuevo,Guardar,Editar,Actualizar,Cancelar,Eliminar,Ninguno}
    private operaciones tipoOperaciones=operaciones.Ninguno;
    private ObservableList <Medico>listarMedicos;
    private ObservableList <Genero>listarGeneros;
    
    private Principal escenarioPrincipal;
    @FXML private ComboBox cmbcodigomedico;
    @FXML private TextField txtlicenciamedica;
    @FXML private TextField txtnombres;
    @FXML private TextField txtapellidos;
    @FXML private ComboBox cmbgenero;
    @FXML private Button btnagregar;
    @FXML private Button btneditar;
    @FXML private Button btneliminar;
    @FXML private Button btnreporte;
    @FXML private GridPane grphoraentrada;
    @FXML private GridPane grphorasalida;
    @FXML private TableView tblmedicos;
    @FXML private TableColumn colcodigomedico;
    @FXML private TableColumn collicenciamedica;
    @FXML private TableColumn colnombres;
    @FXML private TableColumn colapellidos;
    @FXML private TableColumn colhoraentrada;
    @FXML private TableColumn colhorasalida;
    @FXML private TableColumn colgenero;
     private DatePicker dtpentrada;
     private DatePicker dtpdsalida;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarDatos();
        cmbcodigomedico.setItems(getMedicos());
        cmbgenero.setItems(getGenero());
        dtpentrada = new DatePicker(Locale.ENGLISH);
        dtpentrada.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        dtpentrada.getCalendarView().todayButtonTextProperty().set("Today");
        grphoraentrada.add(dtpentrada,0,0);
        
        dtpdsalida = new DatePicker(Locale.ENGLISH);
        dtpdsalida.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        dtpdsalida.getCalendarView().todayButtonTextProperty().set("Today");
        grphorasalida.add(dtpdsalida,0,0);
    }
    public void cargarDatos(){
       tblmedicos.setItems(getMedicos());
        colcodigomedico.setCellValueFactory(new PropertyValueFactory <Medico,Integer> ("codigoMedico"));
       collicenciamedica.setCellValueFactory(new PropertyValueFactory <Medico,Integer> ("licenciaMedica"));
        colnombres.setCellValueFactory(new PropertyValueFactory <Medico,String> ("nombres"));
        colapellidos.setCellValueFactory(new PropertyValueFactory <Medico,String> ("apellidos"));
        colhoraentrada.setCellValueFactory(new PropertyValueFactory <Medico,Date> ("horaEntrada"));
        colhorasalida.setCellValueFactory(new PropertyValueFactory <Medico,Date> ("horaSalida"));
        colgenero.setCellValueFactory(new PropertyValueFactory <Genero,String> ("idGenero"));
    }
       public ObservableList<Medico> getMedicos(){
       ArrayList <Medico> lista = new ArrayList<Medico>();
        try{PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_MostrarMedicos}");
            ResultSet resultado = procedimiento.executeQuery();
            while(resultado.next()){
                lista.add(new Medico(resultado.getInt("codigoMedico"),resultado.getInt("licenciaMedica"),resultado.getString("nombres"),resultado.getString("apellidos"), resultado.getDate("horaEntrada"),resultado.getDate("horaSalida"), resultado.getString("idGenero")));
            }
                }catch(SQLException e){
                   e.printStackTrace(); 
                }
        return listarMedicos = FXCollections.observableList(lista);
       }
       
       public ObservableList<Genero> getGenero(){
       ArrayList <Genero> lista = new ArrayList<Genero>();
        try{PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_MostrarGenero}");
            ResultSet resultado = procedimiento.executeQuery();
            while(resultado.next()){
                lista.add(new Genero(resultado.getString("idGenero")));
            }
                }catch(SQLException e){
                   e.printStackTrace(); 
                }
        return listarGeneros = FXCollections.observableList(lista);
       }
        
    
     public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    public void MenuPrincipal(){
        escenarioPrincipal.menuPrincipal();
       
    }
    public void buscarMedico(int codigoMedico){
    Medico resultado = null;
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_buscarMedicos}");
            procedimiento.setInt(1, codigoMedico);
            ResultSet registro = procedimiento.executeQuery();

                while(registro.next()){
                resultado =  new Medico(registro.getInt("codigoMedico"),
                        registro.getInt("licenciaMedica"),
                        registro.getString("nombres"),
                        registro.getString("apellidos"),
                        registro.getDate("horaEntrada"),
                        registro.getDate("horaSalida"),
                        registro.getString("idGenero"));
                        
                }
         }catch(SQLException e){
         e.printStackTrace();
         }
    }
     public void buscarGenero(String idGenero){
    Medico resultado = null;
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{call sp_buscarGeneros}");
            procedimiento.setString(1, idGenero);
            ResultSet registro = procedimiento.executeQuery();

                while(registro.next()){
                registro.getString("idGenero");
                        
                        
                }
         }catch(SQLException e){
         e.printStackTrace();
         }
    }
    
    public void sleccionar(){
        txtlicenciamedica.setText(""+((Medico) tblmedicos.getSelectionModel().getSelectedItem()).getLicenciaMedica());
        txtnombres.setText (((Medico) tblmedicos.getSelectionModel().getSelectedItem()).getNombres());
        txtapellidos.setText (((Medico) tblmedicos.getSelectionModel().getSelectedItem()).getNombres());
        dtpentrada.selectedDateProperty().set(((Medico) tblmedicos.getSelectionModel().getSelectedItem()).getHoraEntrada());
        dtpdsalida.selectedDateProperty().set(((Medico)tblmedicos.getSelectionModel().getSelectedItem()).getHoraSalida());
        // aqui va el genero igual que el codigo
        
    }
    public void activar(){
        cmbcodigomedico.setDisable(false);
        txtlicenciamedica.setDisable(false);
        txtnombres.setDisable(false);
        txtapellidos.setDisable(false);
        dtpentrada.setDisable(false);
        dtpdsalida.setDisable(false);
        cmbgenero.setEditable(false);
        
        cmbcodigomedico.setEditable(true);
        txtlicenciamedica.setEditable(true);
        txtnombres.setEditable(true);
        txtapellidos.setEditable(true);
        cmbgenero.setEditable(true);
        
    }
    public void limpiar(){
    txtlicenciamedica.setText("");
    txtnombres.setText("");
    txtapellidos.setText("");
    
    }
    public void ingresar(){
        Medico registro = new Medico();
        registro.setLicenciaMedica(Integer.parseInt(txtlicenciamedica.getText()));        
        registro.setNombres(txtnombres.getText());
        registro.setApellidos(txtapellidos.getText());
        registro.setHoraEntrada((java.sql.Date) dtpentrada.getSelectedDate());
        registro.setHoraSalida((java.sql.Date) dtpdsalida.getSelectedDate());
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("(call sp_AgregarMedicos(?,?,?,?,?,?))");
            procedimiento.setInt(1,registro.getLicenciaMedica());
            procedimiento.setString(2,registro.getNombres());
            procedimiento.setString(3, registro.getApellidos());
            procedimiento.setDate(4,new java.sql.Date( registro.getHoraEntrada().getTime()));
            procedimiento.setDate(5,new java.sql.Date( registro.getHoraSalida().getTime()));
            procedimiento.setString(6,registro.getGenero());
            procedimiento.execute();
            listarMedicos.add(registro);
                
             }catch(SQLException e ){
                     e.printStackTrace();
             }                             
    }
    public void desactivar(){
    cmbcodigomedico.setDisable(false);
        txtlicenciamedica.setDisable(false);
        txtnombres.setDisable(false);
        txtapellidos.setDisable(false);
        dtpentrada.setDisable(false);
        dtpdsalida.setDisable(false);
        
        cmbcodigomedico.setEditable(true);
        txtlicenciamedica.setEditable(true);
        txtnombres.setEditable(true);
        txtapellidos.setEditable(true);
        cmbgenero.setEditable(true);
        
    }
    public void nuevo() throws SQLException{
        switch(tipoOperaciones){
            case Ninguno:
                activar();
                limpiar();
                btnagregar.setText("Guardar");
                btneliminar.setText("Limpiar");
                btneditar.setDisable(true);
                btnreporte.setDisable(true);
                tipoOperaciones = operaciones.Guardar;
            break;
            case Guardar:
                ingresar();
                desactivar();
                btnagregar.setText("Guardar");
                btneliminar.setText("Limpiar");
                btneditar.setDisable(false);
                btnreporte.setDisable(false);
                tipoOperaciones = operaciones.Ninguno;
                cargarDatos();
                
                
                
        }
    }
    
    
    public void edit(){
        switch(tipoOperaciones){
            case Ninguno:
                if(tblmedicos.getSelectionModel().getSelectedItem() != null){
                    btneditar.setText("Actualizar");
                    btnreporte.setText("Cancelar");
                    tipoOperaciones = operaciones.Actualizar;
                    btnagregar.setDisable(true);
                    btneliminar.setDisable(true);
                    activar();
                }
            break;
            
            case Actualizar:
                 actualizar();
                 btneditar.setText("Editar");
                 btnreporte.setText("Reporte");
                 tipoOperaciones = operaciones.Ninguno;
                 btnagregar.setDisable(false);
                 btneliminar.setDisable(false);
                desactivar();
                cargarDatos();
             break;
             
        }
    
    
    }
    public void actualizar(){
        try{
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("{(call sp_EditarMedicos(?,?,?,?,?,?,?))}");
            Medico registro = (Medico) tblmedicos.getSelectionModel().getSelectedItem();
            registro.setCodigoMedico(Integer.parseInt(cmbcodigomedico.getSelectionModel().getSelectedItem().toString()));
            registro.setLicenciaMedica(Integer.parseInt(txtlicenciamedica.getText()));
            registro.setNombres(txtnombres.getText());
            registro.setApellidos(txtapellidos.getText());
            registro.setHoraEntrada((Date) dtpentrada.getSelectedDate());
            registro.setHoraSalida((Date) dtpdsalida.getSelectedDate());
            registro.setGenero(cmbgenero.getSelectionModel().getSelectedItem().toString());
            
            procedimiento.setInt(1,registro.getCodigoMedico());
            procedimiento.setInt(2,registro.getLicenciaMedica());
            procedimiento.setString(3,registro.getNombres());
            procedimiento.setString(4,registro.getApellidos());
            procedimiento.setDate(5, new java.sql.Date(registro.getHoraEntrada().getDate()));
            procedimiento.setDate(5, new java.sql.Date(registro.getHoraSalida().getDate()));
            procedimiento.setString(7, registro.getGenero());
            procedimiento.execute();
        
        }catch(SQLException e){
            e.printStackTrace();
        
        }
    
    }
    
}
