package br.senac.pr.api_pix_impresso.saque;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.api_pix_impresso.caixa.impl.CaixaServiceImpl;
import br.senac.pr.api_pix_impresso.conta.impl.ContaServiceImpl;
import br.senac.pr.api_pix_impresso.saque.dtos.ComprovanteSaqueDto;
import br.senac.pr.api_pix_impresso.saque.dtos.SaqueDto;
import br.senac.pr.api_pix_impresso.shared.models.Caixa;
import br.senac.pr.api_pix_impresso.shared.models.Conta;
import br.senac.pr.api_pix_impresso.transacao.dtos.CreateTransacaoDto;
import br.senac.pr.api_pix_impresso.transacao.impl.TransacaoServiceImpl;

@RestController
@RequestMapping("/saques")
public class SaqueController {

  private final ContaServiceImpl contaService;
  private final CaixaServiceImpl caixaService;
  private final TransacaoServiceImpl transacaoService;

  public SaqueController(
      ContaServiceImpl contaService,
      CaixaServiceImpl caixaService,
      TransacaoServiceImpl transacaoService) {
    this.contaService = contaService;
    this.caixaService = caixaService;
    this.transacaoService = transacaoService;
  }

  // Efetuar um saque de um conta e um caixa eletrônico
  @PostMapping
  public ResponseEntity<ComprovanteSaqueDto> saque(@RequestBody SaqueDto dto) {
    // buscar um caixa pelo id e valido se ele tem saldo
    Caixa caixa = caixaService.temSaldo(dto.caixaId(), dto.valor());

    // debitar da conta o valor
    Conta conta = contaService.efetuarDebito(dto.numeroCartao(),
        dto.senha(),
        dto.valor());

    // debitar do caixa o valor
    caixaService.efetuarDebito(caixa, dto.valor());

    // gerar a transação
    var transacaoDto = new CreateTransacaoDto(dto.caixaId(),
        conta.getId(),
        "D",
        dto.valor());

    var transacao = transacaoService.save(transacaoDto);

    // criar um comprovante de saque
    var comprovante = new ComprovanteSaqueDto(
        transacao.getId().toString(),
        conta.getId(),
        caixa.getId(),
        transacao.getDataHora(),
        dto.valor());

    // retornar o comprovante baseado na transacao
    return ResponseEntity.ok().body(comprovante);
  }
}
