package eduhejband.io.domain.entity;

import java.math.BigDecimal;

import javax.persistence.*;
import java.math.BigDecimal;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


//Tratativas com DTO
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @Column(name = "preco_unitario")
    @NotNull(message = "{campo.preco.obrigatorio}")
    private BigDecimal preco;

// JPA com esqueleto
//@Entity
//@Table(name = "produto")
//public class Produto {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "descricao")
//    private String descricao;
//
//    @Column(name = "preco_unitario")
//    private BigDecimal preco;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    public BigDecimal getPreco() {
//        return preco;
//    }
//
//    public void setPreco(BigDecimal preco) {
//        this.preco = preco;
//    }


    //JDBC
//    private Integer id;
//    private String descricao;
//    private BigDecimal preco;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    public BigDecimal getPreco() {
//        return preco;
//    }
//
//    public void setPreco(BigDecimal preco) {
//        this.preco = preco;
//    }
}