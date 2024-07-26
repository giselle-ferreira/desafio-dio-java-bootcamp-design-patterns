package giselletech.dio_java_spring_patterns.repository;

import giselletech.dio_java_spring_patterns.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
