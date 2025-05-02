/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paniscode.pl2ingsoft;

/**
 *
 * @author alvaro
 */
public class ContactoProfesional extends ContactosPersonal {
    private String empresa;
    private String cargo;

    public ContactoProfesional(String nombre, String telefono, String correoElectronico, String direccionPostal,
                               String empresa, String cargo) {
        super(nombre, telefono, correoElectronico, direccionPostal);
        this.empresa = empresa;
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
