package br.senac.pr.api_pix_impresso.conta;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.api_pix_impresso.conta.dtos.CreateContaDto;
import br.senac.pr.api_pix_impresso.conta.dtos.DetailContaDto;
import br.senac.pr.api_pix_impresso.conta.dtos.UpdateContaCadastroDto;
import br.senac.pr.api_pix_impresso.conta.dtos.UpdateContaSaldoDto;
import br.senac.pr.api_pix_impresso.conta.impl.ContaServiceImpl;

@RestController
@RequestMapping("/contas")
public class ContaController {

  private ContaServiceImpl contaService;

  public ContaController(ContaServiceImpl contaService) {
    this.contaService = contaService;
  }

  // POST - Cria uma nova conta
  @PostMapping("")
  public ResponseEntity<DetailContaDto> createConta(@RequestBody CreateContaDto dto) {
    // Salvar no banco
    var conta = contaService.save(dto);
    // retornar o objeto conta o id
    return ResponseEntity.ok().body(conta);
  }

  // GET - Lista todas as contas
  @GetMapping("")
  public List<DetailContaDto> getContas() {
    return contaService.findAll();
  }

  // GET - Lista uma conta por ID
  @GetMapping("/{id}")
  public DetailContaDto getContas(@PathVariable("id") Long id) {
    return contaService.findById(id);
  }

  // PATCH - Atualiza parcialmente uma conta
  @PatchMapping("/{id}/updateSaldo")
  public DetailContaDto updateSaldo(@PathVariable("id") Long id,
      @RequestBody UpdateContaSaldoDto dto) {
    DetailContaDto conta = contaService.updateSaldo(id, dto);
    return conta;
  }

  // PATCH - Atualiza parcialmente uma conta
  @PatchMapping("/{id}/updateCadastro")
  public ResponseEntity<DetailContaDto> updateCadastro(@PathVariable("id") Long id,
      @RequestBody UpdateContaCadastroDto dto) {
    DetailContaDto conta = contaService.updateCadastro(id, dto);
    return ResponseEntity.ok().body(conta);
  }
  // PUT - Atualiza uma conta

  // DELETE - Deleta uma conta
}
