package giselletech.dio_java_spring_patterns.service;

import giselletech.dio_java_spring_patterns.model.Cliente;

/**
 * Padrão strategy
 */

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
