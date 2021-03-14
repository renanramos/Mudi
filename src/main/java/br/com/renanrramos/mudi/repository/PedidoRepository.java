package br.com.renanrramos.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.renanrramos.mudi.model.Pedido;
import br.com.renanrramos.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String> {

	List<Pedido> findByStatus(StatusPedido aguardando);

}
