package eduhejband.io.domain.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Swagger
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")@JsonIgnore
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column
    private Integer quantidade;


}





//Tratativas com DTO
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "item_pedido")
//public class ItemPedido {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "pedido_id")
//    private Pedido pedido;
//
//    @ManyToOne
//    @JoinColumn(name = "produto_id")
//    private Produto produto;
//
//    @Column
//    private Integer quantidade;
//
//
//}



//JPA com esqueleto
//@Entity
//@Table(name = "item_pedido")
//public class ItemPedido {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "pedido_id")
//    private Pedido pedido;
//
//    @ManyToOne
//    @JoinColumn(name = "produto_id")
//    private Produto produto;
//
//    @Column
//    private Integer quantidade;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Pedido getPedido() {
//        return pedido;
//    }
//
//    public void setPedido(Pedido pedido) {
//        this.pedido = pedido;
//    }
//
//    public Produto getProduto() {
//        return produto;
//    }
//
//    public void setProduto(Produto produto) {
//        this.produto = produto;
//    }
//
//    public Integer getQuantidade() {
//        return quantidade;
//    }
//
//    public void setQuantidade(Integer quantidade) {
//        this.quantidade = quantidade;
//
//    }
//}

    //JDBC
//    private Integer id;
//    private Pedido pedido;
//    private Produto produto;
//    private Integer quantidade;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Pedido getPedido() {
//        return pedido;
//    }
//
//    public void setPedido(Pedido pedido) {
//        this.pedido = pedido;
//    }
//
//    public Produto getProduto() {
//        return produto;
//    }
//
//    public void setProduto(Produto produto) {
//        this.produto = produto;
//    }
//
//    public Integer getQuantidade() {
//        return quantidade;
//    }
//
//    public void setQuantidade(Integer quantidade) {
//        this.quantidade = quantidade;
//    }
//}