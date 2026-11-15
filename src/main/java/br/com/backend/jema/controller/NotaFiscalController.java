package br.com.backend.jema.controller;

import br.com.backend.jema.model.NotaFiscal;
import br.com.backend.jema.repository.NotaFiscalRepo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas-fiscais")
@CrossOrigin(origins = "*")
public class NotaFiscalController {

    private final NotaFiscalRepo notaFiscalRepo;

    public NotaFiscalController(NotaFiscalRepo notaFiscalRepo) {
        this.notaFiscalRepo = notaFiscalRepo;
    }

    @GetMapping
    public List<NotaFiscal> listarNotas() {
        return notaFiscalRepo.findAll();
    }
}
