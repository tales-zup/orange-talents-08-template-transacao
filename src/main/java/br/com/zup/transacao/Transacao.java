package br.com.zup.transacao;

import br.com.zup.cartao.Cartao;
import br.com.zup.estabelecimento.Estabelecimento;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;

    @NotNull
    private BigDecimal valor;

    @ManyToOne
    private Estabelecimento estabelecimento;

    @ManyToOne
    private Cartao cartao;

    @NotNull
    private LocalDateTime efetivadaEm;

    public Transacao() {
    }

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
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
