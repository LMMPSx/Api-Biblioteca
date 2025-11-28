package com.senac.api.biblioteca.config;

import com.senac.api.biblioteca.model.LivroModel;
import com.senac.api.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final LivroRepository livroRepository;

    @Override
    public void run(String... args) throws Exception {

        if (livroRepository.count() == 0) {
            LivroModel livro1 = LivroModel.builder()
                    .titulo("O Poder do Hábito")
                    .autor("Charles Duhigg")
                    .isbn("978-8539003887")
                    .anoPublicacao("2012")
                    .disponivel(true)
                    .build();

            LivroModel livro2 = LivroModel.builder()
                    .titulo("Pense e Enriqueça")
                    .autor("Napoleon Hill")
                    .isbn("978-8543101183")
                    .anoPublicacao("1937")
                    .disponivel(true)
                    .build();

            LivroModel livro3 = LivroModel.builder()
                    .titulo("O Senhor dos Anéis: A Sociedade do Anel")
                    .autor("J.R.R. Tolkien")
                    .isbn("978-8595700812")
                    .anoPublicacao("1954")
                    .disponivel(false) // Exemplo: Indisponível
                    .build();

            LivroModel livro4 = LivroModel.builder()
                    .titulo("1984")
                    .autor("George Orwell")
                    .isbn("978-8535914849")
                    .anoPublicacao("1949")
                    .disponivel(true)
                    .build();

            LivroModel livro5 = LivroModel.builder()
                    .titulo("Código Limpo")
                    .autor("Robert C. Martin")
                    .isbn("978-8576056341")
                    .anoPublicacao("2008")
                    .disponivel(true)
                    .build();

            LivroModel livro6 = LivroModel.builder()
                    .titulo("Uma Breve História do Tempo")
                    .autor("Stephen Hawking")
                    .isbn("978-8568600109")
                    .anoPublicacao("1988")
                    .disponivel(true)
                    .build();

            LivroModel livro7 = LivroModel.builder()
                    .titulo("Dom Casmurro")
                    .autor("Machado de Assis")
                    .isbn("978-8572326759")
                    .anoPublicacao("1899")
                    .disponivel(true)
                    .build();

            LivroModel livro8 = LivroModel.builder()
                    .titulo("A Garota do Trem")
                    .autor("Paula Hawkins")
                    .isbn("978-8551000632")
                    .anoPublicacao("2015")
                    .disponivel(false)
                    .build();

            LivroModel livro9 = LivroModel.builder()
                    .titulo("Sapiens: Uma Breve História da Humanidade")
                    .autor("Yuval Noah Harari")
                    .isbn("978-8535926958")
                    .anoPublicacao("2014")
                    .disponivel(true)
                    .build();

            LivroModel livro10 = LivroModel.builder()
                    .titulo("Harry Potter e a Pedra Filosofal")
                    .autor("J.K. Rowling")
                    .isbn("978-8532510783")
                    .anoPublicacao("1997")
                    .disponivel(true)
                    .build();

            // Salva todos os livros de uma vez
            livroRepository.saveAll(Arrays.asList(
                    livro1, livro2, livro3, livro4, livro5,
                    livro6, livro7, livro8, livro9, livro10
            ));
        }
    }

}
