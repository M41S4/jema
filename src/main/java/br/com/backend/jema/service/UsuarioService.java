
package br.com.backend.jema.service;
import br.com.backend.jema.security.JwtService;
import br.com.backend.jema.dto.CadastroUsuarioDTO;
import br.com.backend.jema.dto.LoginUsuarioDTO;
import br.com.backend.jema.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void cadastrar(CadastroUsuarioDTO dados) {

        if (dados.nome() == null || dados.nome().isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }

        if (dados.email() == null || dados.email().isBlank()) {
            throw new IllegalArgumentException("O e-mail é obrigatório.");
        }

        if (dados.senha() == null || dados.senha().length() < 8) {
            throw new IllegalArgumentException(
                    "A senha deve possuir pelo menos 8 caracteres."
            );
        }

        if (usuarioRepository.existeEmail(dados.email())) {
            throw new IllegalArgumentException(
                    "Este e-mail já está cadastrado."
            );
        }

        String senhaHash = passwordEncoder.encode(dados.senha());

        usuarioRepository.salvar(
                dados.nome().trim(),
                dados.email().trim().toLowerCase(),
                senhaHash
        );
    }

    public String autenticar(LoginUsuarioDTO dados) {

        if (dados.email() == null || dados.email().isBlank()
                || dados.senha() == null || dados.senha().isBlank()) {
            return null;
        }

        String email = dados.email().trim().toLowerCase();

        String senhaHash = usuarioRepository.buscarSenhaPorEmail(email);

        if (senhaHash == null ||
                !passwordEncoder.matches(dados.senha(), senhaHash)) {
            return null;
        }

        return jwtService.gerarToken(email);
    }



}
