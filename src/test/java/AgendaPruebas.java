/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import paniscode.pl2ingsoft.*;

import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author alvaro
 */
public class AgendaPruebas {
    private Agenda agenda;
    private ContactosPersonal contacto;
    private Citas cita;
    private TareaPendientes tarea;

    /*
    como la clase Agenda implementa todas las clases, se realizaran las pruebas en este documento respecto 
    a todos los metodos creados en las clases del package paniscode.pl2ingsoft
    */
    
    
    
    @BeforeEach
    public void setUp() {
        agenda = new Agenda();

        contacto = new ContactosPersonal("Pedro", "123456", "pedro@mail.com", "Calle 1");
        cita = new Citas("2024-04-02-14-00", "Oficina", List.of(contacto));
        tarea = new TareaPendientes("Revisar código", 3, "Pendiente");
    }

    @Test
    public void testConfirmarCorreoValido() {
        ContactosPersonal c1 = new ContactosPersonal("Juan", "123456789", "juan@dominio.com", "Calle Ficticia ");
        ContactosPersonal c2 = new ContactosPersonal("Juan", "123456789", "juandominio.com", "Calle Ficticia ");
        ContactosPersonal c3 = new ContactosPersonal("Juan", "123456789", "juan@dominio", "Calle Ficticia ");
        ContactosPersonal c4 = new ContactosPersonal("Juan", "123456789", "juan@dominio.", "Calle Ficticia ");
        ContactosPersonal c5 = new ContactosPersonal("Juan", "123456789", "juan.@dominio.com", "Calle Ficticia ");
        ContactosPersonal c6 = new ContactosPersonal("Juan", "123456789", "juan@dominio..com", "Calle Ficticia ");
        ContactosPersonal c7 = new ContactosPersonal("Juan", "123456789", "juan @dominio.com", "Calle Ficticia ");
        ContactosPersonal c8 = new ContactosPersonal("Juan", "123456789", "", "Calle Ficticia ");
        ContactosPersonal c9 = new ContactosPersonal("Juan", "123456789", null, "Calle Ficticia ");

        assertTrue(contacto.confirmar_correo(c1.getCorreoElectronico())); //correo valido
        assertFalse(contacto.confirmar_correo(c2.getCorreoElectronico())); //correo no valido falta @
        assertFalse(contacto.confirmar_correo(c3.getCorreoElectronico())); //correo no valido falta . despues @        
        assertFalse(contacto.confirmar_correo(c4.getCorreoElectronico())); //correo no valido falta algo despues del .       
        assertFalse(contacto.confirmar_correo(c5.getCorreoElectronico())); //correo no valido . antes del @        
        assertTrue(contacto.confirmar_correo(c6.getCorreoElectronico())); //correo valido . bien colocados        
        assertTrue(contacto.confirmar_correo(c7.getCorreoElectronico())); //correo valido, no influye los espacios        
        assertFalse(contacto.confirmar_correo(c8.getCorreoElectronico())); //correo no valido falta @,dominio, . y terminacion
        assertFalse(contacto.confirmar_correo(c9.getCorreoElectronico())); //correo no valido es null

        

    }
    
    @Test
    public void testAgregarYBuscarCitaPorLugar() {
        agenda.agregar_cita(cita);   
        List<Citas> resultados = agenda.buscar_cita_lugar("Oficina"); //busca por cita
        assertEquals(1, resultados.size());//añade
        assertEquals("Oficina", resultados.get(0).getLugar()); //lista con la cita
        
        List<Citas> resultados2 = agenda.buscar_cita_lugar("Sala"); //busca por sala
        assertEquals(0, resultados2.size()); //añade
        assertTrue(resultados2.isEmpty()); //esta vacia la lista
        
    }

    @Test
    public void testEliminarCita() {
        agenda.agregar_cita(cita); //añade cita
        agenda.eliminar_cita(cita); //elimina cita 
        List<Citas> resultados = agenda.buscar_cita_lugar("Oficina"); //busca la cita
        assertTrue(resultados.isEmpty()); //esta vacia la lista
    }

    @Test
    public void testAgregarYBuscarTareaPorEstado() {
        agenda.agregar_tarea(tarea);
        TareaPendientes t1 = new TareaPendientes("Tarea 1", 2 , "Finalizada");
        agenda.agregar_tarea(t1);

        List<TareaPendientes> resultados = agenda.buscar_tarea_estado("Pendiente"); //devulve tarea
        assertEquals(1, resultados.size()); //añade 1
        assertEquals("Pendiente", resultados.get(0).getEstado());
        
        List<TareaPendientes> resultados2 = agenda.buscar_tarea_estado("Terminadas"); //no devuelve nada
        assertEquals(0, resultados2.size());//no añade nada
        assertTrue(resultados2.isEmpty());
        
        List<TareaPendientes> resultados3 = agenda.buscar_tarea_estado("Finalizada"); //devuelve t1
        assertEquals(1, resultados3.size());//añade 1
        assertEquals("Finalizada", resultados3.get(0).getEstado());
    }

    @Test
    public void testOrdenarTareasPorPrioridad() {
        
        //prioridad descendente 1 mayor prioridad que 2 mayor que 3
        
        TareaPendientes t1 = new TareaPendientes("Tarea 1", 2, "Pendiente");
        TareaPendientes t2 = new TareaPendientes("Tarea 2", 1, "Pendiente");

        agenda.agregar_tarea(tarea); // Baja
        agenda.agregar_tarea(t1);    // Media
        agenda.agregar_tarea(t2);    // Alta


        List<TareaPendientes> ordenadas = agenda.ordenar_tareas_prioridad();

        assertEquals(1, ordenadas.get(0).getPrioridad()); //posicion 1 para alta
        assertEquals(2, ordenadas.get(1).getPrioridad()); //posicion 2 para media
        assertEquals(3, ordenadas.get(2).getPrioridad()); //posicion 3 para baja
    }

    @Test
    public void testDetectarConflictoDeCitas() {
        Citas cita1 = new Citas("2025-05-03-14-00", "Oficina", List.of(contacto));
        Citas cita2 = new Citas("2025-05-03-14-00", "Sala", List.of(contacto));
        Citas cita3 = new Citas("2025-05-15-12-00", "Sala", List.of(contacto));


        agenda.agregar_cita(cita1); //añade
        agenda.agregar_cita(cita2); // Debe detectar conflicto (pero no lanza excepción)

        List<Citas> citasEncontradas = agenda.buscar_cita_lugar("Sala");
        assertTrue(citasEncontradas.isEmpty()); // No se añadió la segunda cita
        
        agenda.agregar_cita(cita3); // Debe detectar conflicto (pero no lanza excepción)

        List<Citas> citasEncontradas2 = agenda.buscar_cita_lugar("Sala");
        assertTrue(!citasEncontradas2.isEmpty()); // Se añadió la tercera cita
    }
}
    

