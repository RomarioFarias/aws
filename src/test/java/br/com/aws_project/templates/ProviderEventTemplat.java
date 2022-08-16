package br.com.aws_project.templates;

import br.com.aws_project.applications.entity.ProviderEvent;

import java.util.HashMap;

public class ProviderEventTemplat {

    public static final String NAME  = "JOAO";
    public static final String ID = "b2371672-879e-4f0e-a051-146048de21b9";


    public static ProviderEvent getProviderEventTemplat() {
        return  ProviderEvent
                .builder()
                .name(NAME)
                .id(ID)
                .build();

    }

    public static HashMap<String, Object> getRequestHeadersTemplat(){
        var hasMap = new HashMap<String, Object>();
        hasMap.put("Message",  getProviderEventTemplat());
        return hasMap;
    }

}
