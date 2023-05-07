package eduhejband.io;

import eduhejband.io.domain.entity.Cliente;
import eduhejband.io.domain.entity.Pedido;
import eduhejband.io.domain.repository.Clientes;
import eduhejband.io.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class VendasApplication {

    //Feito com JPA(Esqueletos)
    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos
    ) {
        return args -> {
            System.out.println("Salvando clientes");
            Cliente fulano = new Cliente("Ciclano");
            clientes.save(fulano);

            Pedido p = new Pedido();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

//            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

            pedidos.findByCliente(fulano).forEach(System.out::println);



        };
    }



    //Feito com JPA(Transactional)
//    @Bean
//    public CommandLineRunner init(@Autowired Clientes_Transactional_Cliente clientes){
//        return args -> {
//            System.out.println("Salvando clientes");
//            clientes.salvar(new Cliente("Edu"));
//            clientes.salvar(new Cliente("Outro Cliente"));
//
//            List<Cliente> todosClientes = clientes.obterTodos();
//            todosClientes.forEach(System.out::println);
//
//            System.out.println("Atualizando clientes");
//            todosClientes.forEach(c -> {
//                c.setNome(c.getNome() + " atualizado.");
//                clientes.atualizar(c);
//            });
//
//            todosClientes = clientes.obterTodos();
//            todosClientes.forEach(System.out::println);
//
//            System.out.println("Buscando clientes");
//            clientes.buscarPorNome("Cli").forEach(System.out::println);
//
//            System.out.println("deletando clientes");
//            clientes.obterTodos().forEach(c -> {
//                clientes.deletar(c);
//            });
//
//            todosClientes = clientes.obterTodos();
//            if(todosClientes.isEmpty()){
//                System.out.println("Nenhum cliente encontrado.");
//            }else{
//                todosClientes.forEach(System.out::println);
//            }
//        };
//    }



            //Feito com JDBC
//    @Bean
//    public CommandLineRunner init(@Autowired Clientes clientes){
//        return args -> {
//            System.out.println("Salvando clientes");
//            clientes.salvar(new Cliente("Edu"));
//            clientes.salvar(new Cliente("Outro Cliente"));
//
//            List<Cliente> todosClientes = clientes.obterTodos();
//            todosClientes.forEach(System.out::println);
//
//            System.out.println("Atualizando clientes");
//            todosClientes.forEach(c -> {
//                c.setNome(c.getNome() + " atualizado.");
//                clientes.atualizar(c);
//            });
//
//            todosClientes = clientes.obterTodos();
//            todosClientes.forEach(System.out::println);
//
//            System.out.println("Buscando clientes");
//            clientes.buscarPorNome("Cli").forEach(System.out::println);
//
////            System.out.println("deletando clientes");
////            clientes.obterTodos().forEach(c -> {
////                clientes.deletar(c);
////            });
//
//            todosClientes = clientes.obterTodos();
//            if(todosClientes.isEmpty()){
//                System.out.println("Nenhum cliente encontrado.");
//            }else{
//                todosClientes.forEach(System.out::println);
//            }
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
