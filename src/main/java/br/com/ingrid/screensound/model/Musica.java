package br.com.ingrid.screensound.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    private Artista artista;

    public Musica(){}

    public Musica(String nomeMusica) {
    }

    @Override
    public String toString() {
        return "Musica='" + titulo + '\'' +
                ", artista=" + artista.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
