package com.ibm.springcloud.templates;

import com.ibm.springcloud.model.Cliente;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ClientTemplate implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Cliente.class).addTemplate("cliente valido", new Rule() {
			{
				add("nome", "Teste");
				add("endereco", "Av Teste");

			}
		});

	}

}
