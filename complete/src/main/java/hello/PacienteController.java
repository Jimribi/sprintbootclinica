package hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "/paciente") // This means URL's start with /demo (after Application path)
public class PacienteController {
    
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private PacienteRepository pacienteRepository;

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewPaciente(@RequestParam long idPaciente,@RequestParam long idTipoDoc,@RequestParam String nombres,@RequestParam String apellidos,@RequestParam String direccion,@RequestParam long telefono, @RequestParam String sexo) {
        Paciente p = new Paciente();
        p.setIdPaciente(idPaciente);
        p.setIdTipoDoc(idTipoDoc);
        p.setNombres(nombres);
        p.setApellidos(apellidos);
        p.setDireccion(direccion);
        p.setTelefono(telefono);
        p.setSexo(sexo);
        pacienteRepository.save(p);
        return "Salvado";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Paciente> getAllPaciente() {
        // This returns a JSON or XML with the users
        return pacienteRepository.findAll();
    }

    @GetMapping(path = "/delete")
    public @ResponseBody
    String deletePaciente(@RequestParam long idPaciente) {

        if (!pacienteRepository.exists(idPaciente)) {
            return "No hay registro";
        } else {
            Paciente p = pacienteRepository.findOne(idPaciente);
            pacienteRepository.delete(p);
            return "Borrado";
        }
    }

    @GetMapping(path = "/update")
    public @ResponseBody
    String updatePaciente(@RequestParam long idPaciente,@RequestParam long idTipoDoc,@RequestParam String nombres,@RequestParam String apellidos,@RequestParam String direccion,@RequestParam long telefono, @RequestParam String sexo) {
        if (!pacienteRepository.exists(idPaciente)) {
            return "No hay registro";
        } else {
            Paciente p = pacienteRepository.findOne(idPaciente);
            p.setNombres(nombres);
            p.setIdTipoDoc(idTipoDoc);
            p.setApellidos(apellidos);
            p.setDireccion(direccion);
            p.setTelefono(telefono);
            p.setSexo(sexo);
            pacienteRepository.save(p);
            return "Actualizado";
        }
    }
    
}
