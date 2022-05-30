package br.com.siecola.aws_project.templates;

import br.com.siecola.aws_project.applications.entity.Client;

public class ClientTemplatTest {

    private static final String NAME = "JOAO";
    private static final String EMAIL = "JOAO@GMAIL.COM";
    private static final String CPF = "59936686012";
    private static final String ID = "b2371672-879e-4f0e-a051-146048de21b9";


    public static Client getClientTemplat() {
        return new Client()
                .withId(ID)
                .withCpf(CPF)
                .withEmail(EMAIL)
                .withName(NAME);
    }
}
