package br.com.danielfnz.simpleslogin.model;

public class User {

    private String nome;
    private String token;
    private String photo_url;


    public User(String nome, String token, String photo_url) {
        this.nome = nome;
        this.token = token;
        this.photo_url = photo_url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}
