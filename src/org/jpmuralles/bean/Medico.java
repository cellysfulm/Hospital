/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jpmuralles.bean;

import java.sql.Date;

/**
 *
 * @author programacion
 */
public class Medico {
    private int codigoMedico;
    private int LicenciaMedica;
    private String nombres;
    private String apellidos;
    private Date horaEntrada;
    private Date horaSalida;
    private String idGenero ;
    
    
            

    public Medico(){

    }

    public Medico(int codigoMedico,int licenciaMedica, String nombres, String apellidos, Date horaEntrada, Date horaSalida, String idGenero) {
        this.codigoMedico = codigoMedico;
        this.LicenciaMedica = licenciaMedica;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.idGenero = idGenero;
    }

    public int getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(int codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public int getLicenciaMedica() {
        return LicenciaMedica;
    }

    public void setLicenciaMedica(int LicenciaMedica) {
        this.LicenciaMedica = LicenciaMedica;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getGenero() {
        return idGenero;
    }

    public void setGenero(String idGenero) {
        this.idGenero = idGenero;
    }

    @Override
    public String toString() {
        return "" + codigoMedico ;
    }
    
}
