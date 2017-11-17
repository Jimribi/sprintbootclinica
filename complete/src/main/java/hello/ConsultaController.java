package hello;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "/consulta") // This means URL's start with /demo (after Application path)
public class ConsultaController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ConsultaRepository consultaRepository;

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewConsulta(@RequestParam long idEspecialista, @RequestParam long idPaciente,
            @RequestParam Date fecha, @RequestParam long idTipo) {
        Consulta c = new Consulta();
        c.setIdEspecialista(idEspecialista);
        c.setIdTipo(idTipo);
        c.setIdPaciente(idPaciente);
        c.setFecha(fecha);
        consultaRepository.save(c);
        return "Salvado";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Consulta> getAllConsulta() {
        // This returns a JSON or XML with the users
        return consultaRepository.findAll();
    }

    @GetMapping(path = "/delete")
    public @ResponseBody
    String deleteConsulta(@RequestParam long idConsulta) {

        if (!consultaRepository.exists(idConsulta)) {
            return "No hay registro";
        } else {
            Consulta c = consultaRepository.findOne(idConsulta);
            consultaRepository.delete(c);
            return "Borrado";
        }
    }

    @GetMapping(path = "/update")
    public @ResponseBody
    String updateConsulta(@RequestParam long idConsulta, @RequestParam long idEspecialista, @RequestParam long idPaciente,
            @RequestParam Date fecha, @RequestParam long idTipo) {
        if (!consultaRepository.exists(idConsulta)) {
            return "No hay registro";
        } else {
            Consulta c = consultaRepository.findOne(idConsulta);
            c.setIdEspecialista(idEspecialista);
            c.setIdTipo(idTipo);
            c.setIdPaciente(idPaciente);
            c.setFecha(fecha);
            consultaRepository.save(c);
            return "Actualizado";
        }
    }
}
