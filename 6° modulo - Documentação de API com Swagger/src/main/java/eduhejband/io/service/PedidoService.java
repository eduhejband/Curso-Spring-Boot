package eduhejband.io.service;

import eduhejband.io.domain.entity.Pedido;
import eduhejband.io.domain.enums.StatusPedido;
import eduhejband.io.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
