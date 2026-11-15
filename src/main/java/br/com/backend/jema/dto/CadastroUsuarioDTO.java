package br.com.backend.jema.dto;

public record CadastroUsuarioDTO(
        String nome,
        String email,
        String senha
) {
}