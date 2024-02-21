package com.dikenge.ms.productms.fixture;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.dikenge.ms.productms.dto.ProductDTO;

public class ProductTemplateLoader implements TemplateLoader {

    @Override
    public void load()
    {
        Fixture.of(ProductDTO.class).addTemplate("valid", new Rule(){
            {
                add("name", random("Arroz", "Frango", "Batata", "Carro", "Pc", "ETC"));
                add("price", random(Float.class, range(0.07F, 9965.67F)));
                add("description", random("Esse producto é bem, confia... vais gostar. é tudo original", "Esse veio do alto zambeze, nos lá só coisa boa tó te falar jura"));

            }
        });
    }

}
