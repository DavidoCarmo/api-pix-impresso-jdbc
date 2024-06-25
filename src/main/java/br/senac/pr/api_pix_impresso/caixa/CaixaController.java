package br.senac.pr.api_pix_impresso.caixa;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.api_pix_impresso.caixa.dtos.CreateCaixaDto;
import br.senac.pr.api_pix_impresso.caixa.dtos.UpdateCaixaDto;
import br.senac.pr.api_pix_impresso.caixa.dtos.UpdateSaldoCaixaDto;
import br.senac.pr.api_pix_impresso.caixa.impl.CaixaServiceImpl;
import br.senac.pr.api_pix_impresso.shared.models.Caixa;

@RestController
@RequestMapping("/caixas")
public class CaixaController {
  private CaixaServiceImpl caixaService;

  public CaixaController(CaixaServiceImpl caixaService) {
    this.caixaService = caixaService;
  }

  @GetMapping("")
  public List<Caixa> getCaixas() {
    return caixaService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Caixa> getCaixaById(@PathVariable Long id) {
    var caixa = caixaService.findById(id);
    if (caixa == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().body(caixa);
  }

  @PostMapping("")
  public Caixa createCaixa(@RequestBody CreateCaixaDto dto) {
    // DTO - Data Transfer Object
    Caixa caixa = new Caixa(null,
        dto.getLocalizacao(),
        dto.getSaldo());
    // Salvar no banco
    int id = caixaService.save(caixa);
    caixa.setId(Long.valueOf(id));
    // retornar o objeto caixa o id
    return caixa;
  }

  // PATCH - Atualização parcial
  @PatchMapping("/{id}")
  public ResponseEntity<String> updateSaldoCaixa(@RequestBody UpdateSaldoCaixaDto dto,
      @PathVariable Long id) {
    // Atualizar o registro no banco
    // retorna o objeto caixa
    Caixa caixa = caixaService.findById(id);
    if (caixa == null) {
      // atualiza o registro
      return ResponseEntity.notFound().build();
    }
    caixa.setSaldo(dto.getSaldo());
    caixaService.updateSaldoCaixa(caixa);
    return ResponseEntity.ok().build();
  }

  // PUT - Atualização completa
  @PutMapping("/{id}")
  public ResponseEntity<Caixa> updateCaixa(@RequestBody UpdateCaixaDto dto,
      @PathVariable Long id) {
    // Atualizar o registro no banco
    Caixa caixa = caixaService.findById(id);
    if (caixa == null) {
      // atualiza o registro
      return ResponseEntity.notFound().build();
    }

    caixa.setLocalizacao(dto.getLocalizacao());
    caixa.setSaldo(dto.getSaldo());
    caixaService.update(caixa);
    // retorna o objeto caixa
    return ResponseEntity.ok(caixa);
  }

  // DELETE - Exclusão
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCaixa(@PathVariable Long id) {
    caixaService.deleteById(id);
    return ResponseEntity.ok().build();
  }

}
