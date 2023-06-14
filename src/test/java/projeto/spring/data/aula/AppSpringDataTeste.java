package projeto.spring.data.aula;

import java.util.List;
import java.util.Optional;

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
	public void testeInsert() { // salva Usuario
		
		UsuarioSpringData usuarioSpringData =  new UsuarioSpringData();
		
		usuarioSpringData.setEmail("teste4@hotmail.com");
		usuarioSpringData.setIdade(45);
		usuarioSpringData.setLogin("teste4");
		usuarioSpringData.setSenha("teste4");
		usuarioSpringData.setNome("Teste4");
		
		interfaceSpringDataUser.save(usuarioSpringData);
		
		//System.out.println("Quantidade de usuarios: " + interfaceSpringDataUser.count());
	}
	
	@Test
	public void testeConsultar() { // Consulta apenas um usuario.
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(3L);
		
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getSenha());
		System.out.println(usuarioSpringData.get().getNome());
	}
	
	@Test
	public void testeConsultaTodos() {  // Lista todos na tela
		
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getNome());
			System.out.println("---------------------------------------");
		}
	}
	
	@Test
	public void testeUpdate() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(4L);
		
		UsuarioSpringData data = usuarioSpringData.get();
		
		data.setNome("Patricia Candido");
		
		interfaceSpringDataUser.save(data);
	}
	
	@Test
	public void testeDelete() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(4L);
		
		interfaceSpringDataUser.delete(usuarioSpringData.get());
	}
	
	@Test
	public void testeConsultaNome() {
		
		List<UsuarioSpringData> list = interfaceSpringDataUser.buscarPorNome("teste");
		
for (UsuarioSpringData usuarioSpringData : list) {
			
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getNome());
			System.out.println("---------------------------------------");
		}
	}
}
