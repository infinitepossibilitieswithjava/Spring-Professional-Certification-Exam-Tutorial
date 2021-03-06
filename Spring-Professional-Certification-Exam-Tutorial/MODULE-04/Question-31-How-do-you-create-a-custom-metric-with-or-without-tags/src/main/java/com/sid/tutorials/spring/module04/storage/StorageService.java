package com.sid.tutorials.spring.module04.storage;

import java.util.Optional;

public interface StorageService {

    int store(String content);

    Optional<String> fetch(int id);
}
