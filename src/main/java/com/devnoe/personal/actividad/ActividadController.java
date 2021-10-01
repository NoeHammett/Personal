package com.devnoe.personal.actividad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/actividad", produces = "application/json")
public class ActividadController {

    private final ActividadService actividadService;

    @Autowired
    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @GetMapping(path = "/getActividad")
    public List<Actividad> getActividad (){
        return actividadService.getActividad();
    }

    @GetMapping(path ="/getActividad/{actividadId}")
    public Actividad getActividadById(@PathVariable("actividadId") Long actividadId){
        return actividadService.getActividadById(actividadId);
    }

    @GetMapping(path = "/getActividadByPerson/{person_id}")
    public List<Actividad> getActividadByPerson(@PathVariable("person_id") Long person_id){
        return actividadService.getActividadByPerson(person_id);
    }

    @PostMapping(path ="/addActividad")
    public String addActividad(@RequestBody Actividad actividad){
        actividadService.addActividad(actividad);
        return "Actividad Agregada Correctamente";
    }

    @DeleteMapping(path="/deleteActividad/{actividadId}")
    public String deleteActividadById(@PathVariable("actividadId") Long actividadId){
        actividadService.deleteActividadById(actividadId);
        return "Actividad Eliminada Correctamente";
    }

    @PutMapping(path="/updateActividad/{actividadId}")
    public String updateActividadById(@RequestBody Actividad actividad,
                                     @PathVariable("actividadId") Long actividadId){
        actividadService.updateActividadById(actividad,actividadId);
        return "Actividad Actualizada Correctamente";
    }


}
