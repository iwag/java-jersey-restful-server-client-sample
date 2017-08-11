package io.github.iwag.jerseystarter.main;


import io.github.iwag.jerseystarter.managers.APIManager;

public class Main {

    public static void main(String[] args) throws java.lang.Exception {
        System.out.println("GET " + APIManager.getUser().toString());
        return ;
    }
}
