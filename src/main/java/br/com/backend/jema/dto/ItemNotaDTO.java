
package br.com.backend.jema.dto;

import lombok.Data;

@Data
public class ItemNotaDTO {

    private Long idNotaFiscal;
    private String numeroNotaFiscal;

    private Long idProduto;
    private String nomeProduto;
    private String skuProduto;

    private Integer quantidade;

    private float pesoUnitario;
    private float altura;
    private float largura;
    private float comprimento;
}
