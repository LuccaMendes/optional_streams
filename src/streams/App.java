package streams;

import optional.Genero;

import java.util.List;

public class App {

    static void main() {

        List<Pessoa> pessoas = getPessoas();
        //Expressao lambda
        //pessoas.forEach(p -> System.out.println(p));

        //referencia ao metodo
        //pessoas.forEach(System.out::println);

        List<Pessoa> generoFeminino = pessoas.stream()
                .filter(p -> p.getGenero()
                        .equals(Genero.FEMININO)).toList();
        System.out.println("Todo o objeto: " + generoFeminino);

        List<String> generoFemininoSomenteNome = pessoas.stream()
                .filter(p -> p.getGenero()
                        .equals(Genero.FEMININO) && p.getIdade() > 18)
                        .map(Pessoa::getNome).toList();

        generoFemininoSomenteNome.forEach(System.out::println);

    }
    public static List<Pessoa> getPessoas(){
        return List.of(
                new Pessoa("José", 20, Genero.MASCULINO, "jose@gmail.com"),
                new Pessoa("Diego", 35, Genero.MASCULINO, "diego@gmail.com"),
                new Pessoa("Camila", 24, Genero.FEMININO, "camila@gmail.com"),
                new Pessoa("Maria", 42, Genero.FEMININO, "maria@gmail.com"),
                new Pessoa("Lucca", 19, Genero.MASCULINO, "lucca@gmail.com"));
    }
}
