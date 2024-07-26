package giselletech.dio_java_spring_patterns.service.impl;

import giselletech.dio_java_spring_patterns.model.Cliente;
import giselletech.dio_java_spring_patterns.model.Endereco;
import giselletech.dio_java_spring_patterns.repository.ClienteRepository;
import giselletech.dio_java_spring_patterns.repository.EnderecoRepository;
import giselletech.dio_java_spring_patterns.service.ClienteService;
import giselletech.dio_java_spring_patterns.service.ViaCepServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    /*
    Singleton: injeta os components com @Autowired
    Strategy: implementa métodos definidos na interface
    Facade: Abstrai integrações com subsistemas
     */

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepServicce viaCepServicce;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if(optionalCliente.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    private void salvarClienteComCep(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepServicce.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
