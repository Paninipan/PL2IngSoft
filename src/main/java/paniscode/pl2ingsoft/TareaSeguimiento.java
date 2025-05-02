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
import java.util.List;

public class TareaSeguimiento extends TareaPendientes {
    private LocalDate fechaLimite;
    private List<ContactosPersonal> responsables;

    public TareaSeguimiento(String descripcion, String prioridad, String estado,
                            LocalDate fechaLimite, List<ContactosPersonal> responsables) {
        super(descripcion, prioridad, estado);
        this.fechaLimite = fechaLimite;
        this.responsables = responsables;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public List<ContactosPersonal> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<ContactosPersonal  > responsables) {
        this.responsables = responsables;
    }
}

