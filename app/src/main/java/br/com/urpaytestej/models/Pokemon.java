package br.com.urpaytestej.models;

public class Pokemon {
    private String name; // Requisição para nome

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url; // Requisição para endereço
}
