package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.larissa.model.domain.Escola;
import br.edu.infnet.larissa.model.service.EscolaService;
import dto.EscolaDTO;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @PostMapping
    public ResponseEntity<?> criarEscola(@RequestBody EscolaDTO escolaDTO) {
        Escola escola = escolaService.criarEscola(escolaDTO);
        return ResponseEntity.ok(escola);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterEscolaPorId(@PathVariable Integer id) {
        Escola escola = escolaService.obterEscolaPorId(id);
        if (escola == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(escola);
    }

    @PutMapping("/escolas/{id}")
    public ResponseEntity<Escola> atualizarEscola(@PathVariable Integer id, @RequestBody EscolaDTO escolaDTO) {
        if (!escolaService.existeEscola(id)) {
            return ResponseEntity.notFound().build();
        }

        Escola escolaAtualizada = escolaService.atualizarEscola(id, escolaDTO);

        return ResponseEntity.ok(escolaAtualizada);
    }
    @DeleteMapping("/escolas/{id}")
    public ResponseEntity<Void> excluirEscola(@PathVariable Integer id) {
        if (!escolaService.existeEscola(id)) {
            return ResponseEntity.notFound().build();
        }

        escolaService.excluirEscola(id);

        return ResponseEntity.noContent().build();
    }
}