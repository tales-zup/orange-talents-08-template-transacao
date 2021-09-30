package br.com.zup.transacao;

import br.com.zup.cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findTop10ByCartaoOrderByIdDesc(Cartao cartao);

}
