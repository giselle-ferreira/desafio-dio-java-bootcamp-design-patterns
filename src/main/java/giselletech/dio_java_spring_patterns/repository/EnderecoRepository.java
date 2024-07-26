package giselletech.dio_java_spring_patterns.repository;

import giselletech.dio_java_spring_patterns.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String>{
}


