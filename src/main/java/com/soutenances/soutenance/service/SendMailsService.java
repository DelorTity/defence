package com.soutenances.soutenance.service;

public interface SendMailsService {
     void sendSimpleMessage(String to, String subject, String text);

}