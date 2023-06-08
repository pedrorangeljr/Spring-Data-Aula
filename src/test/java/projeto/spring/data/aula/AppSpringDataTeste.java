package projeto.spring.data.aula;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTeste {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;

	@Test
	public void testeInsert() {
		
		UsuarioSpringData usuarioSpringData =  new UsuarioSpringData();
		
		usuarioSpringData.setEmail("teste4@hotmail.com");
		usuarioSpringData.setIdade(45);
		usuarioSpringData.setLogin("teste4");
		usuarioSpringData.setSenha("teste4");
		usuarioSpringData.setNome("Teste4");
		
		interfaceSpringDataUser.save(usuarioSpringData);
	}
}
