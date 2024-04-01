package br.edu.infnet.larissa.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.larissa.model.domain.Escola;
import br.edu.infnet.larissa.model.repository.EscolaRepository;
import dto.EscolaDTO;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    public void incluirEscola(Escola escola) {
        escolaRepository.save(escola);
    }

    public Escola obterEscolaPorId(Integer id) {
        return escolaRepository.findById(id).orElse(null);
    }

    public void atualizarEscola(Escola escola) {
        escolaRepository.save(escola);
    }

    public void excluirEscola(Integer id) {
        escolaRepository.deleteById(id);
    }

	public Escola criarEscola(EscolaDTO escolaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public Escola atualizarEscola(Integer id, EscolaDTO escolaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existeEscola(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
}