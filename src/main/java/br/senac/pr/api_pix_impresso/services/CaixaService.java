package br.senac.pr.api_pix_impresso.services;
import java.util.List;
import org.springframework.stereotype.Service;

import br.senac.pr.api_pix_impresso.models.Caixa;
import br.senac.pr.api_pix_impresso.repositories.JdbcCaixaRepository;

@Service
public class CaixaService {
    private JdbcCaixaRepository caixaRepository;
    public CaixaService(JdbcCaixaRepository caixaRepository){
    this.caixaRepository = caixaRepository;
}

    public int save(Caixa caixa){
        if (caixa == null){
            throw new Error("Dados do caixa ivalido");
        }
        return caixaRepository.save(caixa);
    }

public List<Caixa>findAll(){
    return caixaRepository.findAll();
}
}
