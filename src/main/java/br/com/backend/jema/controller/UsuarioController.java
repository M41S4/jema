
package br.com.backend.jema.controller;

import br.com.backend.jema.dto.CadastroUsuarioDTO;
import br.com.backend.jema.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.backend.jema.dto.LoginUsuarioDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(
            @RequestBody CadastroUsuarioDTO dados) {

        try {
            usuarioService.cadastrar(dados);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(Map.of(
                            "mensagem",
                            "Usuário cadastrado com sucesso!"
                    ));

        } catch (IllegalArgumentException e) {

            return ResponseEntity
                    .badRequest()
                    .body(Map.of("erro", e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUsuarioDTO dados) {

        String token = usuarioService.autenticar(dados);

        if (token == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("erro", "E-mail ou senha inválidos."));
        }

        return ResponseEntity.ok(
                Map.of(
                        "mensagem", "Login realizado com sucesso!",
                        "token", token,
                        "tipo", "Bearer"
                )
        );
    }
}
