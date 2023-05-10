package eduhejband.io.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

//Tratativas com DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "cliente" )
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @JsonIgnore
    @OneToMany( mappedBy = "cliente" , fetch = FetchType.LAZY )
    private Set<Pedido> pedidos;

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

//JPA com esqueleto
//@Entity
//@Table( name = "cliente" )
//public class Cliente {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "nome", length = 100)
//    private String nome;
//
//    @Column(name = "cpf", length = 11)
//    private String cpf;
//
//    @JsonIgnore
//    @OneToMany( mappedBy = "cliente" , fetch = FetchType.LAZY )
//    private Set<Pedido> pedidos;
//
//    public Cliente() {
//    }
//
//    public Set<Pedido> getPedidos() {
//        return pedidos;
//    }
//
//    public void setPedidos(Set<Pedido> pedidos) {
//        this.pedidos = pedidos;
//    }
//
//    public Cliente(Integer id, String nome) {
//        this.id = id;
//        this.nome = nome;
//    }
//
//    public Cliente(String nome) {
//        this.nome = nome;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getCpf() {
//        return cpf;
//    }
//
//    public void setCpf(String cpf) {
//        this.cpf = cpf;
//    }
//
//    @Override
//    public String toString() {
//        return "Cliente{" +
//                "id=" + id +
//                ", nome='" + nome + '\'' +
//                '}';
//    }



//JPA sem esqueleto
//    @Entity
//    @Table( name = "cliente" )
//    public class Cliente {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.AUTO)
//        @Column(name = "id")
//        private Integer id;
//
//        @Column(name = "nome", length = 100)
//        private String nome;
//
//        public Cliente() {
//        }
//
//        public Cliente(Integer id, String nome) {
//            this.id = id;
//            this.nome = nome;
//        }
//
//        public Cliente(String nome) {
//            this.nome = nome;
//        }
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public String getNome() {
//            return nome;
//        }
//
//        public void setNome(String nome) {
//            this.nome = nome;
//        }
//
//        @Override
//        public String toString() {
//            return "Cliente{" +
//                    "id=" + id +
//                    ", nome='" + nome + '\'' +
//                    '}';
//        }


    //JDBC
//    private Integer id;
//    private String nome;
//
//    public Cliente() {
//    }
//
//    public Cliente(Integer id, String nome) {
//        this.id = id;
//        this.nome = nome;
//    }
//
//    public Cliente(String nome) {
//        this.nome = nome;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    @Override
//    public String toString() {
//        return "Cliente{" +
//                "id=" + id +
//                ", nome='" + nome + '\'' +
//                '}';
//    }
}