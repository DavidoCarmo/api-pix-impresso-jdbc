package br.senac.pr.api_pix_impresso.conta.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.senac.pr.api_pix_impresso.conta.ContaService;
import br.senac.pr.api_pix_impresso.conta.JdbcContaRepository;
import br.senac.pr.api_pix_impresso.conta.dtos.CreateContaDto;
import br.senac.pr.api_pix_impresso.conta.dtos.DetailContaDto;
import br.senac.pr.api_pix_impresso.conta.dtos.UpdateContaCadastroDto;
import br.senac.pr.api_pix_impresso.conta.dtos.UpdateContaDto;
import br.senac.pr.api_pix_impresso.conta.dtos.UpdateContaSaldoDto;
import br.senac.pr.api_pix_impresso.conta.mappers.ContaToDetailContaMapper;
import br.senac.pr.api_pix_impresso.conta.mappers.CreateContaToContaMapper;
import br.senac.pr.api_pix_impresso.shared.models.Conta;

@Service
public class ContaServiceImpl implements ContaService {
  private final JdbcContaRepository contaRepository;
  private final CreateContaToContaMapper createContaToContaMapper;
  private final ContaToDetailContaMapper contaToDetailContaMapper;

  public ContaServiceImpl(JdbcContaRepository contaRepository,
      CreateContaToContaMapper createContaToContaMapper,
      ContaToDetailContaMapper contaToDetailContaMapper) {
    this.contaRepository = contaRepository;
    this.createContaToContaMapper = createContaToContaMapper;
    this.contaToDetailContaMapper = contaToDetailContaMapper;
  }

  @Override
  public DetailContaDto save(CreateContaDto dto) {
    Conta conta = createContaToContaMapper.apply(dto);
    int id = contaRepository.save(conta);
    conta.setId(Long.valueOf(id));
    return contaToDetailContaMapper.apply(conta);
  }

  @Override
  public List<DetailContaDto> findAll() {
    return contaRepository.findAll()
        .stream()
        .map(contaToDetailContaMapper)
        .collect(Collectors.toList());
  }

  @Override
  public DetailContaDto findById(Long id) {

    var conta = contaRepository.findById(id).orElse(null);
    if (conta == null) {
      return null;
    }
    return contaToDetailContaMapper.apply(conta);
  }

  @Override
  public DetailContaDto update(UpdateContaDto conta) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void deleteById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }

  public DetailContaDto updateCadastro(Long id,
      UpdateContaCadastroDto dto) {
    // Busca a conta
    Conta conta = contaRepository.findById(id).orElse(null);
    // Valida se a conta existe
    if (conta == null) {
      throw new RuntimeException("Conta não encontrada");
    }

    conta.setNome(dto.getNome());
    conta.setCpf(dto.getCpf());
    conta.setTipoConta(dto.getTipoConta());

    contaRepository.update(conta);

    return contaToDetailContaMapper.apply(conta);
  }

  public DetailContaDto updateSaldo(Long id,
      UpdateContaSaldoDto dto) {
    Conta conta = contaRepository.findById(id).orElse(null);
    if (conta == null) {
      throw new RuntimeException("Conta não encontrada");
    }
    conta.setSaldo(dto.getSaldo());
    contaRepository.update(conta);
    return contaToDetailContaMapper.apply(conta);
  }
}
