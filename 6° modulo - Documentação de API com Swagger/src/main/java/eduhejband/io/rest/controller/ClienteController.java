package eduhejband.io.rest.controller;


import eduhejband.io.domain.entity.Cliente;
import eduhejband.io.domain.repository.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private Clientes clientes;

    public ClienteController( Clientes clientes ) {
        this.clientes = clientes;
    }

    @GetMapping("{id}")
    public Cliente getClienteById( @PathVariable Integer id ){
        return clientes
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save( @RequestBody @Valid Cliente cliente ){
        return clientes.save(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        clientes.findById(id)
                .map( cliente -> {
                    clientes.delete(cliente );
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado") );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody @Valid Cliente cliente ){
        clientes
                .findById(id)
                .map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado") );
    }

    @GetMapping
    public List<Cliente> find( Cliente filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return clientes.findAll(example);
    }







    //Requisições CRUD
//    private Clientes clientes;
//
//    public ClienteController( Clientes clientes ) {
//        this.clientes = clientes;
//    }
//
//    @GetMapping("/api/clientes/{id}")
//    @ResponseBody
//    public ResponseEntity getClienteById( @PathVariable Integer id ){
//        Optional<Cliente> cliente = clientes.findById(id);
//
//        if(cliente.isPresent()){
//            return ResponseEntity.ok( cliente.get() );
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping("/api/clientes")
//    @ResponseBody
//    public ResponseEntity save( @RequestBody Cliente cliente ){
//        Cliente clienteSalvo = clientes.save(cliente);
//        return ResponseEntity.ok(clienteSalvo);
//    }
//
//    @DeleteMapping("/api/clientes/{id}")
//    @ResponseBody
//    public ResponseEntity delete( @PathVariable Integer id ){
//        Optional<Cliente> cliente = clientes.findById(id);
//
//        if(cliente.isPresent()){
//            clientes.delete( cliente.get() );
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//
//    @PutMapping("/api/clientes/{id}")
//    @ResponseBody
//    public ResponseEntity update( @PathVariable Integer id,
//                                  @RequestBody Cliente cliente ){
//        return clientes
//                .findById(id)
//                .map( clienteExistente -> {
//                    cliente.setId(clienteExistente.getId());
//                    clientes.save(cliente);
//                    return ResponseEntity.noContent().build();
//                }).orElseGet( () -> ResponseEntity.notFound().build() );
//    }
//
//    @GetMapping("/api/clientes")
//    public ResponseEntity find( Cliente filtro ){
//        ExampleMatcher matcher = ExampleMatcher
//                .matching()
//                .withIgnoreCase()
//                .withStringMatcher(
//                        ExampleMatcher.StringMatcher.CONTAINING );
//
//        Example example = Example.of(filtro, matcher);
//        List<Cliente> lista = clientes.findAll(example);
//        return ResponseEntity.ok(lista);
//    }

}