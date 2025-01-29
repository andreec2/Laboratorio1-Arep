package org.example;

import java.io.IOException;
import java.io.OutputStream;

@FunctionalInterface
public interface RouteHandler {
    void handle(String path, String query, OutputStream out) throws IOException;
}