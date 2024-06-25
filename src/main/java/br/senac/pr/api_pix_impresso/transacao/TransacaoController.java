package br.senac.pr.api_pix_impresso.transacao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.api_pix_impresso.shared.models.Transacao;
import br.senac.pr.api_pix_impresso.transacao.dtos.CreateTransacaoDto;
import br.senac.pr.api_pix_impresso.transacao.dtos.UpdateValorDto;
import br.senac.pr.api_pix_impresso.transacao.impl.TransacaoServiceImpl;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

  private TransacaoServiceImpl transacaoService;

  public TransacaoController(TransacaoServiceImpl transacaoService) {
    this.transacaoService = transacaoService;
  }

  @GetMapping
  public ResponseEntity<List<Transacao>> getAll() {
    var transacoes = transacaoService.findAll();
    return ResponseEntity.ok(transacoes);
  }

  @PostMapping
  public ResponseEntity<Transacao> save(@RequestBody CreateTransacaoDto dto) {
    var transacao = transacaoService.save(dto);
    return ResponseEntity.ok().body(transacao);
  }

  @PatchMapping("/{id}/updateValor")
  public ResponseEntity<Void> updateValor(@PathVariable Long id,
      UpdateValorDto dto) {
    transacaoService.updateValor(id, dto);
    return ResponseEntity.ok().build();
  }

}
