package eduhejband.io.service;


import eduhejband.io.model.Cliente;
import eduhejband.io.repository.MeuRepositorio;
import org.springframework.stereotype.Service;

@Service
public class MeuServico {


    private MeuRepositorio repositorio;

    public MeuServico( MeuRepositorio repositorio ){
        this.repositorio = repositorio;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repositorio.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){
        //aplica validações
    }
}
