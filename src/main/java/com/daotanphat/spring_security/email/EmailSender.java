package com.daotanphat.spring_security.email;

public interface EmailSender {
    void send(String to, String email, String body);
}
