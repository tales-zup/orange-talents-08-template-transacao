package br.com.zup.transacao;

public class CartaoDto {

    private String id;
    private String email;

    public CartaoDto(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}