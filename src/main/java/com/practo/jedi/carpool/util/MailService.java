package com.practo.jedi.carpool.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * Utility class for sending emails.
 * @author prashant
 *
 */
@Component
public class MailService {

  @Autowired
  private JavaMailSender javaMailService;

  /**
   * Send an email.
   * @param to Email address to send email to
   * @param subject Subject of email
   * @param body Body of email
   * @throws MessagingException Id sending fails
   */
  public void send(String to, String subject, String body) throws MessagingException {
    System.out.println(to);
    System.out.println(subject);
    System.out.println(body);
    MimeMessage message = javaMailService.createMimeMessage();
    MimeMessageHelper helper;

    helper = new MimeMessageHelper(message, true); // true indicates
    helper.setSubject(subject);
    helper.setTo(to);
    helper.setText(body, true);
    javaMailService.send(message);
  }
}
