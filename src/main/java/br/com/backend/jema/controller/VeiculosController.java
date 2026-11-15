
package br.com.backend.jema.controller;

import br.com.backend.jema.model.Veiculos;
import br.com.backend.jema.repository.VeiculosRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "*")
public class VeiculosController {

    private final VeiculosRepo veiculosRepo;

    public VeiculosController(VeiculosRepo veiculosRepo) {
        this.veiculosRepo = veiculosRepo;
    }

    @GetMapping
    public List<Veiculos> listarVeiculos() {
        return veiculosRepo.findAll();
    }
}
