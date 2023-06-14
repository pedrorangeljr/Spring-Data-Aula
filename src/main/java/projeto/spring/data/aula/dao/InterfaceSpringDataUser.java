package projeto.spring.data.aula.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projeto.spring.data.aula.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long>{
	
	
	@Query(value = "select p from UsuarioSpringData p where p.nome like %?1%") // contem parte de um String
	public List<UsuarioSpringData> buscarPorNome(String nome);
	
	@Query(value= "select p from UsuarioSpringData p where p.nome = :paramnome") // == ao Parametro 
	public UsuarioSpringData buscaPorNomeParam(@Param("paramnome") String paramnome);

}
