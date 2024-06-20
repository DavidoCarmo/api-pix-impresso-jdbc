package br.senac.pr.api_pix_impresso.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.senac.pr.api_pix_impresso.dtos.CreateContaDto;
import br.senac.pr.api_pix_impresso.dtos.DetailContaDto;
import br.senac.pr.api_pix_impresso.dtos.UpdateContaCadastroDto;
import br.senac.pr.api_pix_impresso.dtos.UpdateContaDto;
import br.senac.pr.api_pix_impresso.dtos.UpdateContaSaldoDto;
import br.senac.pr.api_pix_impresso.mappers.ContaToDetailContaMapper;
import br.senac.pr.api_pix_impresso.mappers.CreateContaToContaMapper;
import br.senac.pr.api_pix_impresso.models.Conta;
import br.senac.pr.api_pix_impresso.repositories.JdbcContaRepository;
import br.senac.pr.api_pix_impresso.services.ContaService;

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
    return contaToDetailContaMapper.apply(contaRepository.findById(id).orElse(null));
  }

  @Override
  public DetailContaDto update(UpdateContaDto conta) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void deleteById(Long id) {
    contaRepository.deleteById(id);
  }

  public DetailContaDto updateCadastro(Long id,
      UpdateContaCadastroDto dto) {

    Conta conta = contaRepository.findById(id).orElse(null);

    if (conta == null) {
      throw new RuntimeException("Conta não encontrada");
    }

    conta.setNome(dto.getNome());
    conta.setCpf(dto.getCpf());
    conta.setTipoConta(dto.getTipoConta());

    contaRepository.update(conta);

    return contaToDetailContaMapper.apply(conta);
  }
  public DetailContaDto update(Long id,
      UpdateContaDto dto) {

    Conta conta = contaRepository.findById(id).orElse(null);

    if (conta == null) {
      throw new RuntimeException("Conta não encontrada");
    }

    conta.setAgencia(dto.getAgencia());
    conta.setNumeroConta(dto.getNumeroConta());
    conta.setDigitoVerificador(dto.getDigitoVerificador());
    conta.setNome(dto.getNome());
    conta.setCpf(dto.getCpf());
    conta.setTipoConta(dto.getTipoConta());
    conta.setNumeroConta(dto.getNumeroConta());
    conta.setSenha(dto.getSenha());
    conta.setSaldo(dto.getSaldo());

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