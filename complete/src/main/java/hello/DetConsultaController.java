/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author usuario
 */
@Controller    // This means that this class is a Controller
@RequestMapping(path = "/detconsulta")
public class DetConsultaController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private DetConsultaRepository detconsultaRepository;

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewDetConsulta(@RequestParam long idConsulta, @RequestParam String peso,
            @RequestParam String estatura, @RequestParam String tension, @RequestParam String sintoma, @RequestParam long codigoCie,
            @RequestParam String recomendacion) {
        DetConsulta d = new DetConsulta();
        d.setIdConsulta(idConsulta);
        d.setPeso(peso);
        d.setEstatura(estatura);
        d.setTension(tension);
        d.setSintoma(sintoma);
        d.setCodigoCie(codigoCie);
        d.setRecomendacion(recomendacion);
        detconsultaRepository.save(d);
        return "Salvado";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<DetConsulta> getAllDetConsulta() {
        // This returns a JSON or XML with the users
        return detconsultaRepository.findAll();
    }

    @GetMapping(path = "/delete")
    public @ResponseBody
    String deleteConsulta(@RequestParam long idDetConsulta) {

        if (!detconsultaRepository.exists(idDetConsulta)) {
            return "No hay registro";
        } else {
            DetConsulta c = detconsultaRepository.findOne(idDetConsulta);
            detconsultaRepository.delete(c);
            return "Borrado";
        }
    }

    @GetMapping(path = "/update")
    public @ResponseBody
    String updateDetConsulta(@RequestParam long idDetConsulta, @RequestParam long idConsulta, @RequestParam String peso,
            @RequestParam String estatura, @RequestParam String tension, @RequestParam String sintoma, @RequestParam long codigoCie,
            @RequestParam String recomendacion) {
        if (!detconsultaRepository.exists(idDetConsulta)) {
            return "No hay registro";
        } else {
            DetConsulta d = detconsultaRepository.findOne(idDetConsulta);
            d.setIdConsulta(idConsulta);
            d.setPeso(peso);
            d.setEstatura(estatura);
            d.setTension(tension);
            d.setSintoma(sintoma);
            d.setCodigoCie(codigoCie);
            d.setRecomendacion(recomendacion);
            detconsultaRepository.save(d);
            return "Actualizado";
        }
    }

}
