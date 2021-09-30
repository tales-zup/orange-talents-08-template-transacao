package br.com.zup.transacao;

import br.com.zup.cartao.Cartao;
import br.com.zup.cartao.CartaoRepository;
import br.com.zup.estabelecimento.Estabelecimento;
import br.com.zup.estabelecimento.EstabelecimentoRecord;
import br.com.zup.cartao.CartaoRecord;
import br.com.zup.estabelecimento.EstabelecimentoRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoRecord {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoRecord estabelecimento;
    private CartaoRecord cartao;
    private LocalDateTime efetivadaEm;

    public TransacaoRecord() {
    }

    public TransacaoRecord(String id, BigDecimal valor, EstabelecimentoRecord estabelecimento, CartaoRecord cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao toModel(EstabelecimentoRepository er, CartaoRepository cr) {
        Cartao cartao = cr.findById(this.cartao.getId()).orElse(this.cartao.toModel());
        cr.save(cartao);

        Estabelecimento estabelecimento = this.estabelecimento.toModel();
        er.save(estabelecimento);
        return new Transacao(this.id, this.valor, estabelecimento, cartao, efetivadaEm);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoRecord getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoRecord getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
