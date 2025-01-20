package com.my_portfolio.backend.Service;

import com.my_portfolio.backend.Model.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Value("${spring.mail.username}")
    private String email;

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactEmail(EmailModel emailModel) throws MailException {

        var fromUserMessage = new SimpleMailMessage();

        fromUserMessage.setTo(email);
        fromUserMessage.setSubject("Portfolio Inquiry");
        fromUserMessage.setText(emailModel.getMessage());

        mailSender.send(fromUserMessage);

        var fromMeMessage = new SimpleMailMessage();

        fromMeMessage.setTo(emailModel.getEmail());

        fromMeMessage.setText("Hello "+emailModel.getFullName()+",\n" +
                "\n" +
                "Thank you for contacting me! I’ve received your message and will get back to you within 1–2 working days.\n" +
                "\n" +
                "If your request is urgent or requires immediate attention, please feel free to mention it in your email, and I’ll do my best to prioritize it.\n" +
                "\n" +
                "Looking forward to connecting with you!\n" +
                "\n" +
                "Best regards,\n" +
                "Jon Arbell De Ocampo");
        fromMeMessage.setSubject("Thank You for Reaching Out");

        mailSender.send(fromMeMessage);
    }
}
