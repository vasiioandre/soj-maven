package com.endava.tmd.soj.maven;

import java.io.IOException;
import java.util.Optional;

import com.endava.tmd.soj.maven.model.Person;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MyApp {

    public static void main(final String[] args) throws IOException {
        if (args.length == 2) {
            greet(args[0], args[1]);
        } else {
            greet();
        }
    }

    private static void greet() throws IOException {
        greet(Optional.empty());
    }

    private static void greet(final String firstName, final String lastName) throws IOException {
        final var person = new Person(firstName, lastName);
        System.out.println("Am construit persoana: " + person);
        greet(Optional.of(person));
    }

    private static void greet(final Optional<Person> personShell) throws IOException {
        final var client = new OkHttpClient();
        final var request = new Request.Builder().url(buildUrl(personShell)).build();
        final var response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    private static String buildUrl(final Optional<Person> personShell) {
        final var urlBuilder = HttpUrl.parse("http://api.icndb.com/jokes/random").newBuilder();
        urlBuilder.addQueryParameter("limitTo", "[nerdy]");
        urlBuilder.addQueryParameter("escape", "javascript");
        personShell.ifPresent(person -> {
            urlBuilder.addQueryParameter("firstName", person.getFirstName());
            urlBuilder.addQueryParameter("lastName", person.getLastName());
        });
        return urlBuilder.build().toString();
    }

}

