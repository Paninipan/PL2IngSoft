/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paniscode.pl2ingsoft;

/**
 *
 * @author alvaro
 */
public class TareasPen {
    private String descripcion;
    private String prioridad;
    private String estado;

    public TareasPen(String descripcion, String prioridad, String estado) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

