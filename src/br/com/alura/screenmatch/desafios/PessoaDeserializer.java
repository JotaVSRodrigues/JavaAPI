package br.com.alura.screenmatch.desafios;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PessoaDeserializer implements JsonDeserializer<Pessoa> {
    private static final Set<String> KNOW_KEYS = Set.of("nome", "idade", "cidade", "estudante");

    @Override
    public Pessoa deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject obj = new JsonObject().getAsJsonObject();

        // Campos padrões
        String nome = obj.has("nome") && !obj.get("nome").isJsonNull()
                ? obj.get("nome").getAsString() : null;
        int idade = obj.has("idade") && !obj.get("idade").isJsonNull()
                ? obj.get("idade").getAsInt() : null;
        String cidade = obj.has("cidade") && !obj.get("cidade").isJsonNull()
                ? obj.get("cidade").getAsString() : null;
        boolean estudante = obj.has("estudante") && !obj.get("boolean").isJsonNull()
                ? obj.get("estudante").getAsBoolean() : null;

        // Catch-all para os extras
        Map<String, JsonElement> extras = new LinkedHashMap<>();
        for (Map.Entry<String, JsonElement> e : obj.entrySet()) {
            if (!KNOW_KEYS.contains(e.getKey())) {
                extras.put(e.getKey(), e.getValue());
            }
        }
        return new Pessoa(nome, idade, cidade, estudante, extras);
    }
}
