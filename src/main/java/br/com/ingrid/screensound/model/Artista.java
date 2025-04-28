package br.com.ingrid.screensound.model;

import jakarta.persistence.*;

@Entity
@Table(name="Artista")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoArtista tipo;

    private List<Musica> musicas = new ArrayList<>();
}
