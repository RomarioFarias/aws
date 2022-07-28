package br.com.aws_project.templates;

import br.com.aws_project.applications.entity.Product;

public class ProductTemplatTest {

    public static final String DESCRIPTION  = "JOAO";
    public static final String PROVIDER_ID = "b2371672-879e-4f0e-a051-146048de21b2";
    public static final String ID = "b2371672-879e-4f0e-a051-146048de21b9";
    public static final Integer AMOUNT = 20;
    public static final Double VALUE = 2.222;


    public static Product getProducTemplat() {
        return new Product()
                .withId(ID)
                .withDescription(DESCRIPTION)
                .withProviderId(PROVIDER_ID)
                .withValue(VALUE)
                .withAmount(AMOUNT);

    }

}
