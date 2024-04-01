package br.edu.infnet.larissa.model.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.infnet.larissa.model.domain.Escola;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EscolaServiceTest {

    @Autowired
    private EscolaService escolaService;

    @Test
    public void testIncluirEscola() {
        Escola escola = new Escola();
        escola.setNome("Escola Teste");
        escolaService.incluirEscola(escola);
        assertNotNull(escola.getId()); 
    }

    @Test
    public void testObterEscolaPorId() {
        Escola escola = new Escola();
        escola.setNome("Escola Teste");
        escolaService.incluirEscola(escola);
        assertNotNull(escola.getId()); 

        Escola escolaObtida = escolaService.obterEscolaPorId(escola.getId());
        assertNotNull(escolaObtida); 
        assertEquals(escola.getNome(), escolaObtida.getNome());
    }

    @Test
    public void testAtualizarEscola() {
        Escola escola = new Escola();
        escola.setNome("Escola Teste");
        escolaService.incluirEscola(escola);
        assertNotNull(escola.getId()); 

        escola.setNome("Nova Escola");
        escolaService.atualizarEscola(escola);

        Escola escolaAtualizada = escolaService.obterEscolaPorId(escola.getId());
        assertEquals("Nova Escola", escolaAtualizada.getNome());
    }

    @Test
    public void testExcluirEscola() {
        Escola escola = new Escola();
        escola.setNome("Escola Teste");
        escolaService.incluirEscola(escola);
        assertNotNull(escola.getId()); 

        escolaService.excluirEscola(escola.getId());

        Escola escolaExcluida = escolaService.obterEscolaPorId(escola.getId());
        assertNull(escolaExcluida);
    }
    @Test
    public void testIncluirEscolaComEndereco() {
        Escola escola = new Escola();
        escola.setNome("Escola Teste");
        escola.setEndereco("Endereço da Escola Teste");
        
        escolaService.incluirEscola(escola);
        

        Escola escolaInserida = escolaService.obterEscolaPorId(escola.getId());
        assertNotNull(escolaInserida);
        assertEquals(escola.getNome(), escolaInserida.getNome());
        extracted(escola, escolaInserida);
    }

	private void extracted(Escola escola, Escola escolaInserida) {
		assertEquals(escola.getEndereco(), escolaInserida.getEndereco());
	} 
	@Test
	public void testObterEscolaPorIdCorretamente() {
	    Escola escola = new Escola();
	    escola.setNome("Escola Teste");
	    escola.setEndereco("Endereço da Escola Teste");
	    escolaService.incluirEscola(escola);
	    
	    Escola escolaObtida = escolaService.obterEscolaPorId(escola.getId());
	    
	    assertNotNull(escolaObtida);
	    assertEquals(escola.getNome(), escolaObtida.getNome());
	    assertEquals(escola.getEndereco(), escolaObtida.getEndereco());
	}
}