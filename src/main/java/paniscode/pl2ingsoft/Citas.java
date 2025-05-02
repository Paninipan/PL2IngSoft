/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paniscode.pl2ingsoft;

/**
 *
 * @author alvaro
 */
import java.time.LocalDateTime;
import java.util.List;

public class Citas {
    private LocalDateTime fechaHora;
    private String lugar;
    private List<ContactosPersonal> personasInvolucradas;

    public Citas(LocalDateTime fechaHora, String lugar, List<ContactosPersonal> personasInvolucradas) {
        this.fechaHora = fechaHora;
        this.lugar = lugar;
        this.personasInvolucradas = personasInvolucradas;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public List<ContactosPersonal> getPersonasInvolucradas() {
        return personasInvolucradas;
    }

    public void setPersonasInvolucradas(List<ContactosPersonal> personasInvolucradas) {
        this.personasInvolucradas = personasInvolucradas;
    }
}
