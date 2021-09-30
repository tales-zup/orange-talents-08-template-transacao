package br.com.zup.kafka;

import br.com.zup.cartao.CartaoRepository;
import br.com.zup.estabelecimento.EstabelecimentoRepository;
import br.com.zup.transacao.Transacao;
import br.com.zup.transacao.TransacaoRecord;
import br.com.zup.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConsumer {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "transacoes")
    public void consumir(TransacaoRecord transacaoRecord) {
        Transacao transacao = transacaoRecord.toModel(estabelecimentoRepository, cartaoRepository);
        transacaoRepository.save(transacao);
        System.out.println("Transacao " + transacao.getId() + " gravada com sucesso");
    }

}
