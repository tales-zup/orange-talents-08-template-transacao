package br.com.zup.estabelecimento;

public class EstabelecimentoRecord {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoRecord() {
    }

    public EstabelecimentoRecord(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}
