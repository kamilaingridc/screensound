package br.com.ingrid.screensound.main;

import br.com.ingrid.screensound.model.Artista;
import br.com.ingrid.screensound.model.Musica;
import br.com.ingrid.screensound.model.TipoArtista;
import br.com.ingrid.screensound.repository.ArtistaRepository;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private final ArtistaRepository repository;
    private Scanner scanner = new Scanner(System.in);

    public Main(ArtistaRepository repository){
        this.repository = repository;
    }

    public void exibeMenu() {
        var opcao = -1;

        while (opcao!= 9) {
            var menu = """
                    *** Screen Sound Músicas ***                    
                                        
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                                    
                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void pesquisarDadosDoArtista() {
    }

    private void buscarMusicasPorArtista() {
    }

    private void listarMusicas() {
    }

    private void cadastrarMusicas() {
        System.out.println("Cadastrar música de que artista? ");
        var nome = scanner.nextLine();
        Optional<Artista> artista = repository.findByNomeContainingIgnoreCase(nome);
        if (artista.isPresent()) {
            System.out.println("Informe o título da música");
            var nomeMusica = scanner.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            repository.save(artista.get());
        } else {
            System.out.println("Artista não encontrado.");
        }
    }

    private void cadastrarArtistas() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome do artista: ");
            var nome = scanner.nextLine();
            System.out.println("Informe o tipo desse artista: (solo, dupla ou banda)");
            var tipo = scanner.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repository.save(artista);
            System.out.println("Cadastrar novo artista? (S/N)");
        }
    }
}