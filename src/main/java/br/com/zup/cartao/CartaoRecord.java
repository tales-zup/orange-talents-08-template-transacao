package br.com.zup.cartao;

public class CartaoRecord {

    private String id;
    private String email;

    public CartaoRecord() {
    }

    public CartaoRecord(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }
}
