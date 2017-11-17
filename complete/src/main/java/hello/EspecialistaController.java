/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "/especialista") // This means URL's start with /demo (after Application path)
public class EspecialistaController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private EspecialistaRepository especialistaRepository;

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewEspecialista(@RequestParam long idEspecialista, @RequestParam long idTipoDoc, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam String direccion,
            @RequestParam long telefono, @RequestParam long idEspecialidad) {
        if (especialistaRepository.exists(idEspecialista)) {
            return "Registro ya existe";
        } else {
            Especialista e = new Especialista();
            e.setIdEspecialista(idEspecialista);
            e.setIdTipoDoc(idTipoDoc);
            e.setNombres(nombres);
            e.setApellidos(apellidos);
            e.setDireccion(direccion);
            e.setTelefono(telefono);
            e.setIdEspecialidad(idEspecialidad);
            especialistaRepository.save(e);
            return "Salvado";
        }
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Especialista> getAllEspecialistas() {
        // This returns a JSON or XML with the users
        return especialistaRepository.findAll();
    }

    @GetMapping(path = "/delete")
    public @ResponseBody
    String deleteEspecialista(@RequestParam long idEspecialista) {

        if (!especialistaRepository.exists(idEspecialista)) {
            return "No hay registro";
        } else {
            Especialista e = especialistaRepository.findOne(idEspecialista);
            especialistaRepository.delete(e);
            return "Borrado";
        }
    }

    @GetMapping(path = "/update")
    public @ResponseBody
    String updateEspecialista(@RequestParam long idEspecialista, @RequestParam long idTipoDoc, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam String direccion,
            @RequestParam long telefono, @RequestParam long idEspecialidad) {
        if (!especialistaRepository.exists(idEspecialidad)) {
            return "No hay registro";
        } else {
            Especialista e = especialistaRepository.findOne(idEspecialista);
            e.setIdEspecialista(idEspecialista);
            e.setIdTipoDoc(idTipoDoc);
            e.setNombres(nombres);
            e.setApellidos(apellidos);
            e.setDireccion(direccion);
            e.setTelefono(telefono);
            e.setIdEspecialidad(idEspecialidad);
            especialistaRepository.save(e);
            return "Actualizado";
        }
    }

}