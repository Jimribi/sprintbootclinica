package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "/cie10")
public class Cie10Controller {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private Cie10Repository cie10Repository;

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewCie10(@RequestParam long CodigoCie,
            @RequestParam String Descripcion, @RequestParam String Sexo) {
        if (cie10Repository.exists(CodigoCie)) {
            return "Registro ya existe";
        } else {
            Cie10 c = new Cie10();
            c.setCodigoCie(CodigoCie);
            c.setDescripcion(Descripcion);
            c.setSexo(Sexo);
            cie10Repository.save(c);
            return "Salvado";
        }

    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Cie10> getAllCie10() {
        // This returns a JSON or XML with the users
        return cie10Repository.findAll();
    }

    @GetMapping(path = "/delete")
    public @ResponseBody
    String deleteCie10(@RequestParam long CodigoCie) {

        if (!cie10Repository.exists(CodigoCie)) {
            return "No hay registro";
        } else {
            Cie10 c = cie10Repository.findOne(CodigoCie);
            cie10Repository.delete(c);
            return "Borrado";
        }
    }

    @GetMapping(path = "/update")
    public @ResponseBody
    String updateCie10(@RequestParam long CodigoCie, @RequestParam String Descripcion,
            @RequestParam String Sexo) {
        if (!cie10Repository.exists(CodigoCie)) {
            return "No hay registro";
        } else {
            Cie10 c = cie10Repository.findOne(CodigoCie);
            c.setDescripcion(Descripcion);
            c.setSexo(Sexo);
            cie10Repository.save(c);
            return "Actualizado";
        }
    }
}
