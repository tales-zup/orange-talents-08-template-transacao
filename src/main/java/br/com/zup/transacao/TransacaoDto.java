package br.com.zup.transacao;

import br.com.zup.estabelecimento.Estabelecimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private Estabelecimento estabelecimento;

    public TransacaoDto(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.estabelecimento = transacao.getEstabelecimento();

    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }
}