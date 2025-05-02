/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paniscode.pl2ingsoft;

/**
 *
 * @author alvaro
 */
public class ContactosPersonal {
    private String nombre;
    private String telefono;
    private String correoElectronico;
    private String direccionPostal;

    public ContactosPersonal(String nombre, String telefono, String correoElectronico, String direccionPostal) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccionPostal = direccionPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }
    
    public boolean confirmar_correo(String correo){
        if (correo == null || !correo.contains("@")) {
            return false;
        }
        int posicion_arroba = correo.indexOf("@");
        int posicion_pri_punto = correo.indexOf(".");
        int posicion_ult_punto = correo.lastIndexOf(".");
        return posicion_arroba + 1 < posicion_pri_punto && posicion_ult_punto < correo.length() - 1;
        //el arroba antes del punto tiene un carracter de separacion EJ: @dominio.
        //el utlimo punto no esta al final de la cadena EJ:  .fin
    }
    
}

