package br.com.aws_project.templates;

import br.com.aws_project.applications.entity.Client;
import java.util.Optional;

public class ClientTemplatTest {

    public static final String NAME = "JOAO";
    public static final String EMAIL = "JOAO@GMAIL.COM";
    public static final String CPF = "59936686012";
    public static final String ID = "b2371672-879e-4f0e-a051-146048de21b9";


    public static Client getClientTemplat() {
        return new Client()
                .withId(ID)
                .withCpf(CPF)
                .withEmail(EMAIL)
                .withName(NAME);
    }

    public static Optional<Client> getOptionalClientTemplat() {
        return Optional.of(getClientTemplat());
    }
}
