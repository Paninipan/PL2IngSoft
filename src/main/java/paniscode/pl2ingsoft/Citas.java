/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paniscode.pl2ingsoft;

/**
 *
 * @author alvaro
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Citas {
    private LocalDateTime fechaHora;
    private String lugar;
    private List<ContactosPersonal> personasInvolucradas;

    public Citas(String fecha, String lugar, List<ContactosPersonal> personasInvolucradas) {
        this.fechaHora = obtener_fecha(fecha);
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
    
    private LocalDateTime obtener_fecha(String fecha){
        try {
                 // Definimos el patrón para el formato "yyyy-MM-dd-HH-mm"
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
                 return LocalDateTime.parse(fecha, formatter); // Intentamos parsear la fecha con la hora
             } catch (DateTimeParseException e) {
                 // Si la fecha no es válida, capturamos la excepción y mostramos un mensaje
                 System.out.println("Fecha y hora no válida: " + fecha);
                 return null; // Si no es válida, devolvemos null
             }
 }
     public boolean esta_en_conflicto(Citas otraCita) {
        return this.fechaHora.equals(otraCita.getFechaHora());
    }
}
