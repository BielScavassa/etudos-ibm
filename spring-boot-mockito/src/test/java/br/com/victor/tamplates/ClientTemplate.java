package br.com.victor.tamplates;

import br.com.six2six.fixturefactory.Fixture;

import br.com.six2six.fixturefactory.Rule;

import br.com.six2six.fixturefactory.loader.TemplateLoader;

import br.com.victor.model.Client;

public class ClientTemplate implements TemplateLoader {

    @Override
    public void load() {

        Fixture.of(Client.class).addTemplate("client informations valid", new Rule() {
            {
            	add("id", 1L);

                add("name", "gabriel");

                add("lastname", "scavassa");

                add("username", "gabriel.scavassa@asdsa.com");

                add("password", "1a2b3c4d");

                add("cpf", "12345678900");

            }

        }).addTemplate("client information not valid", new Rule() {

            {

                add("name", "gabriel");

                add("lastname", "scavassa");

            }

        });

    }
}
