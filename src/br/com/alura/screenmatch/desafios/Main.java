package br.com.alura.screenmatch.desafios;

import com.google.gson.*;

public class Main {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
        Gson gson = gsonBuilder.create();

        String pessoaJson = "{"
                + "\"Nome\": \"João\","
                + "\"Idade\": 18,"
//                + "\"Cidade\": \"São Paulo\","
                + "\"Estudante\": true"
                + "}";
        try {
            Pessoa pessoa = gson.fromJson(pessoaJson, Pessoa.class);
            System.out.println(pessoa);
        } catch (JsonIOException e){
            e.printStackTrace();
            System.out.println("Exception in JsonIO: " + e.getMessage());
        } catch (JsonSyntaxException e){
            e.printStackTrace();
            System.out.println("Exception in Json Syntax");
        }

        // campo do livro
        ConnectionHTTP connection = new ConnectionHTTP();
        String url = connection.encodeURL("https://openlibrary.org/search.json?q=", "the lord of the rings");
        String bookResponse = connection.connect(url);

        Livro livro = gson.fromJson(bookResponse, Livro.class);
    }
}
