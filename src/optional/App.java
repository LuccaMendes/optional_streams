package optional;

import java.nio.channels.FileLockInterruptionException;
import java.util.Optional;

public class App {
    static void main() {

        Pessoa ana = new Pessoa("Ana", 20, Genero.FEMININO, null);

        Optional<String> valorQueExiste = Optional.of(ana.getNome());

        Optional<String> podeSerNullOuNao = Optional.ofNullable(ana.getEmail());

        Optional<String> vazio = Optional.empty();

//        System.out.println(valorQueExiste);
//        System.out.println(podeSerNullOuNao);
//        System.out.println(vazio);

        //No Optional.of o valor é obrigatório!
        //No Optional.ofNullable o valor pode ser nulo ou não!
//        Optional.of(ana.getEmail());

        //if - else vs Optional

        String email = ana.getEmail();
//        String contato;

//        if(email != null){
//            contato = email;
//        }else {
//            contato = "Usuário não possui email!";
//        }

//        contato = Optional.ofNullable(email)
//                .orElse("Ana não possui email!");
//        System.out.println(contato);

//        Optional.ofNullable(email)
//                .ifPresentOrElse(e -> System.out.println("Email enviado para " + e),
//                        () -> System.out.println(ana.getNome() + " não possui email"));

//        if(email == null){
//            throw new IllegalArgumentException("Email não localizado com if - else");
//        }
//
//        Optional.ofNullable(email).orElseThrow(() ->
//                new IllegalArgumentException("Email não localizado com Optional"));
        try {
            validaEmail(email);
        }catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static String validaEmail(String email) {
        return Optional.ofNullable(email).orElseThrow(() ->
                new IllegalArgumentException("Email não localizado com Optional"));
    }

}
