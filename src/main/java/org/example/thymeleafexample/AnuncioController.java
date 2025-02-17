package org.example.thymeleafexample;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/anuncios")
public class AnuncioController {

    private List<Anuncio> anuncios = new ArrayList<>();

    // Método para mostrar los anuncios en la página principal con temática de rol
    @GetMapping("/")
    public String listarAnuncios(Model model, HttpSession session) {
        if (session.getAttribute("firstVisit") == null) {
            model.addAttribute("bienvenida", "¡Bienvenido, valiente aventurero! Que tus misiones sean gloriosas.");
            session.setAttribute("firstVisit", true);
        }
        model.addAttribute("anuncios", anuncios);
        return "index";
    }

    // Método para mostrar el detalle completo de un anuncio
    @GetMapping("/ver/{nombre}")
    public String verAnuncio(@PathVariable("nombre") String nombre, Model model) {
        for (Anuncio anuncio : anuncios) {
            if (anuncio.getNombre().equals(nombre)) {
                model.addAttribute("anuncio", anuncio);
                return "detalle";
            }
        }
        return "redirect:/anuncios/";
    }

    // Método para mostrar el formulario de crear anuncio
    @GetMapping("/crear")
    public String crearAnuncioForm(Model model, HttpSession session) {
        model.addAttribute("anuncio", new Anuncio((String) session.getAttribute("usuario"), "", "", ""));
        model.addAttribute("tipos", new String[]{"Misión", "Evento", "Mercado", "Noticia"});
        return "crear";
    }

    // Método para guardar el nuevo anuncio
    @PostMapping("/crear")
    public String crearAnuncio(@ModelAttribute("anuncio") Anuncio anuncio, HttpSession session) {
        // Se guarda el nombre del usuario para usarlo en futuras creaciones
        session.setAttribute("usuario", anuncio.getNombre());
        anuncios.add(anuncio);
        return "redirect:/anuncios/confirmacion";
    }

    // Método para mostrar la confirmación de inserción de anuncio
    @GetMapping("/confirmacion")
    public String confirmacion() {
        return "confirmacion";
    }

    // Método para marcar un anuncio como completado
    @PostMapping("/completar/{nombre}")
    public String completarAnuncio(@PathVariable("nombre") String nombre) {
        for (Anuncio anuncio : anuncios) {
            if (anuncio.getNombre().equals(nombre)) {
                anuncio.setCompletado(true); // Marcar el anuncio como completado
                break;
            }
        }
        return "redirect:/anuncios/";
    }
}
