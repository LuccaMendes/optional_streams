package streams;

import optional.Genero;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    static void main() {

        List<Boletim> boletins = getBoletins();
        boletins.forEach(Boletim::calcularResultados);

//        List<Boletim> aprovados = boletins.stream()
//                .filter(b -> b.getDisciplinas()
//                        .stream().allMatch(d -> d.getResultado().equals(Resultado.APROVADO))
//                ).toList();
//        System.out.println(aprovados);

//        boletins.forEach(b -> {
//            b.getDisciplinas().forEach(d -> System.out.println(d.getNome()));
//        });
//
//        Set<Disciplina> comFlatMap = boletins.stream()
//                .flatMap(b -> b.getDisciplinas().stream()).collect(Collectors.toSet());

//        System.out.println("com Flat Map");
//        comFlatMap.forEach(d -> System.out.println(d.getNome()));

        System.out.println();
        System.out.println("****** Agrupado por Aluno *****");

        Map<Pessoa, List<Boletim>> agrupadoPorAluno = boletins.stream()
                .collect(Collectors.groupingBy(Boletim::getPessoa));

        agrupadoPorAluno.forEach(((pessoa, boletims) -> {
            System.out.println("Aluno: " + pessoa.getNome());
            boletims.forEach(b -> System.out.println(b.getDisciplinas()));
            System.out.println();
        }));
    }

    public static List<Boletim> getBoletins(){
        Pessoa ana = new Pessoa("Ana", 18, Genero.FEMININO, "ana@gmail.com");
        Pessoa joao = new Pessoa("João", 20, Genero.MASCULINO, "joao@gmail.com");
        Pessoa douglas = new Pessoa("Douglas", 25, Genero.MASCULINO, "douglas@gmail.com");
        Pessoa rafael = new Pessoa("Rafael", 30, Genero.MASCULINO, "rafael@gmail.com");
        Pessoa lucca = new Pessoa("Lucca", 35, Genero.MASCULINO, "lucca@gmail.com");
        Pessoa isac = new Pessoa("Isac", 40, Genero.MASCULINO, "isac@gmail.com");

        Boletim boletimAna = new Boletim(ana, List.of(
                new Disciplina(DisciplinaEnum.ALGORITMOS, List.of(5.5, 8.5, 9.5), null, 0.0),
                new Disciplina(DisciplinaEnum.CALCULO_1, List.of(6.5, 7.5, 8.5), null, 0.0)));

        Boletim boletimJoao = new Boletim(joao, List.of(
                new Disciplina(DisciplinaEnum.BANCO_DE_DADOS, List.of(5.5, 8.5, 9.5), null, 0.0),
                new Disciplina(DisciplinaEnum.POO, List.of(7.5, 7.5, 9.5), null, 0.0)));

        Boletim boletimDouglas = new Boletim(douglas, List.of(
                new Disciplina(DisciplinaEnum.POO, List.of(5.5, 8.5, 9.5), null, 0.0),
                new Disciplina(DisciplinaEnum.ALGORITMOS, List.of(7.5, 7.5, 9.5), null, 0.0)));

        Boletim boletimRafael = new Boletim(rafael, List.of(
                new Disciplina(DisciplinaEnum.BANCO_DE_DADOS, List.of(5.5, 8.5, 9.5), null, 0.0),
                new Disciplina(DisciplinaEnum.CALCULO_1, List.of(9.5, 4.5, 9.5), null, 0.0)));

        Boletim boletimLucca = new Boletim(lucca, List.of(
                new Disciplina(DisciplinaEnum.ALGORITMOS, List.of(5.5, 8.5, 9.5), null, 0.0),
                new Disciplina(DisciplinaEnum.POO, List.of(6.5, 7.5, 9.5), null, 0.0)));

        Boletim boletimIsac = new Boletim(isac, List.of(
                new Disciplina(DisciplinaEnum.ALGORITMOS, List.of(5.5, 8.5, 9.5), null, 0.0),
                new Disciplina(DisciplinaEnum.BANCO_DE_DADOS, List.of(7.5, 7.5, 7.5), null, 0.0)));

        List<Boletim> boletins = new ArrayList<>(List.of(boletimAna, boletimJoao, boletimDouglas, boletimRafael, boletimLucca, boletimIsac));
        return boletins;
    }
}
