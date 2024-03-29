package br.com.aws_project.templates;

import br.com.aws_project.applications.entity.Provider;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ClientTemplatTest {

    public static final String NAME = "JOAO";
    public static final String EMAIL = "JOAO@GMAIL.COM";
    public static final String CPF = "59936686012";
    public static final String ID = "b2371672-879e-4f0e-a051-146048de21b9";


    public static Provider getClientTemplat() {
        return new Provider()
                .withId(ID)
                .withCpf(CPF)
                .withEmail(EMAIL)
                .withName(NAME);
    }

    public static Optional<Provider> getOptionalClientTemplat() {
        return Optional.of(getClientTemplat());
    }

    public static Set<Provider> listAllProvider(){
        return Set.of(getClientTemplat());
    }
}
