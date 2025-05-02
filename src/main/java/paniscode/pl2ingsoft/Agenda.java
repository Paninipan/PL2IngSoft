/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paniscode.pl2ingsoft;


import java.util.*;

public class Agenda {
    private List<ContactosPersonal> contactosPersonales;
    private List<Citas> citas;
    private List<TareaPendientes> tareasPendientes;

    // Constructor
    public Agenda() {
        this.contactosPersonales = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.tareasPendientes = new ArrayList<>();
    }

    // Métodos para agregar elementos a la agenda
    public void agregar_contacto(ContactosPersonal contacto) {
        contactosPersonales.add(contacto);
    }

    public void agregar_cita(Citas cita) {
        for (Citas existingCita : citas) {
            if (existingCita.esta_en_conflicto(cita)) {
                System.out.println("Conflicto detectado con la cita: " + existingCita.getFechaHora());
                return;
            }
        }
        citas.add(cita);
    }

    public void agregar_tarea(TareaPendientes tarea) {
        tareasPendientes.add(tarea);
    }

    // Métodos para eliminar elementos de la agenda
    public void eliminar_contacto(ContactosPersonal contacto) {
        contactosPersonales.remove(contacto);
    }

    public void eliminar_cita(Citas cita) {
        citas.remove(cita);
    }

    public void eliminar_tarea(TareaPendientes tarea) {
        tareasPendientes.remove(tarea);
    }

    // Método para buscar un contacto por nombre
    public ContactosPersonal buscar_contacto(String nombre) {
        for (ContactosPersonal contacto : contactosPersonales) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null; // No se encontró
    }

    // Método para buscar una cita por lugar
    public List<Citas> buscar_cita_lugar(String lugar) {
        List<Citas> citasEncontradas = new ArrayList<>();
        for (Citas cita : citas) {
            if (cita.getLugar().equalsIgnoreCase(lugar)) {
                citasEncontradas.add(cita);
            }
        }
        return citasEncontradas;
    }

    // Método para buscar tareas por estado
    public List<TareaPendientes> buscar_tarea_estado(String estado) {
        List<TareaPendientes> tareasEncontradas = new ArrayList<>();
        for (TareaPendientes tarea : tareasPendientes) {
            if (tarea.getEstado().equalsIgnoreCase(estado)) {
                tareasEncontradas.add(tarea);
            }
        }
        return tareasEncontradas;
    }

    // Método para listar tareas pendientes ordenadas por prioridad
    public List<TareaPendientes> ordenar_tareas_prioridad() {
        tareasPendientes.sort(Comparator.comparing(TareaPendientes::getPrioridad));
        return tareasPendientes;
    }
}
