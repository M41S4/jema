
package br.com.backend.jema.controller;

import br.com.backend.jema.dto.ItemNotaDTO;
import br.com.backend.jema.model.ItemNota;
import br.com.backend.jema.repository.ItemNotaRepo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens-nota")
@CrossOrigin(origins = "*")
public class ItemNotaController {

    private final ItemNotaRepo itemNotaRepo;

    public ItemNotaController(ItemNotaRepo itemNotaRepo) {
        this.itemNotaRepo = itemNotaRepo;
    }

    @GetMapping
    public List<ItemNotaDTO> listarItens() {

        List<ItemNota> itens =
                itemNotaRepo.buscarItensComNotaEProduto();

        return itens.stream().map(item -> {

            ItemNotaDTO dto = new ItemNotaDTO();

            dto.setIdNotaFiscal(item.getNotaFiscal().getId());
            dto.setNumeroNotaFiscal(item.getNotaFiscal().getNumero_nf());

            dto.setIdProduto(item.getProduto().getId());
            dto.setNomeProduto(item.getProduto().getNome_produto());
            dto.setSkuProduto(item.getProduto().getSku_produto());

            dto.setQuantidade(item.getQuantidade());

            dto.setPesoUnitario(item.getProduto().getPeso());
            dto.setAltura(item.getProduto().getAltura());
            dto.setLargura(item.getProduto().getLargura());
            dto.setComprimento(item.getProduto().getComprimento());

            return dto;

        }).toList();
    }
}
