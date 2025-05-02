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

public class CitaTrabajo extends Citas {
    private List<String> agendaTemas;
    private int duracionEstimadaMinutos;

    public CitaTrabajo(LocalDateTime fechaHora, String lugar, List<ContactosPersonal> personasInvolucradas,
                       List<String> agendaTemas, int duracionEstimadaMinutos) {
        super(fechaHora, lugar, personasInvolucradas);
        this.agendaTemas = agendaTemas;
        this.duracionEstimadaMinutos = duracionEstimadaMinutos;
    }

    public List<String> getAgendaTemas() {
        return agendaTemas;
    }

    public void setAgendaTemas(List<String> agendaTemas) {
        this.agendaTemas = agendaTemas;
    }

    public int getDuracionEstimadaMinutos() {
        return duracionEstimadaMinutos;
    }

    public void setDuracionEstimadaMinutos(int duracionEstimadaMinutos) {
        this.duracionEstimadaMinutos = duracionEstimadaMinutos;
    }
}

