package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "/tipoconsulta") // This means URL's start with /demo (after Application path)
public class TipoConsultaController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private TipoConsultaRepository tipoConsultaRepository;

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewTipoConsulta(@RequestParam String DescripTipo) {
        TipoConsulta t = new TipoConsulta();
        t.setDescripTipo(DescripTipo);
        tipoConsultaRepository.save(t);
      
        return "Salvado";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<TipoConsulta> getAllTipoConsulta() {
        // This returns a JSON or XML with the users
        return tipoConsultaRepository.findAll();
    }

    @GetMapping(path = "/delete")
    public @ResponseBody
    String deleteTipoConsulta(@RequestParam long idTipo) {

        if (!tipoConsultaRepository.exists(idTipo)) {
            return "No hay registro";
        } else {
            TipoConsulta t = tipoConsultaRepository.findOne(idTipo);
            tipoConsultaRepository.delete(t);
            return "Borrado";
        }
    }

    @GetMapping(path = "/update")
    public @ResponseBody
    String updateTipoConsulta(@RequestParam long idTipo, @RequestParam String DescripTipo) {
        if (!tipoConsultaRepository.exists(idTipo)) {
            return "No hay registro";
        } else {
            TipoConsulta t = tipoConsultaRepository.findOne(idTipo);
            t.setDescripTipo(DescripTipo);
            tipoConsultaRepository.save(t);
            return "Actualizado";
        }
    }
}
