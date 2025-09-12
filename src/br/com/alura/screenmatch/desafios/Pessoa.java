package br.com.alura.screenmatch.desafios;

import com.google.gson.JsonElement;

import java.util.Map;

public record Pessoa(String nome, int idade, String cidade, boolean estudante, Map<String, JsonElement> extras) {
}
