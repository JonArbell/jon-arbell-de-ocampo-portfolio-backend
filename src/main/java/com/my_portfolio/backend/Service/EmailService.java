package com.my_portfolio.backend.Service;

import com.my_portfolio.backend.Model.ModelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Value("${spring.mail.username}")
    private String email;

    private final JavaMailSender mailSender;

    public void sendContactEmail(ModelDTO modelDTO) throws MailException {

        var fromUserMessage = new SimpleMailMessage();

        fromUserMessage.setTo(email);
        fromUserMessage.setSubject("Portfolio Inquiry");

        var finalMessage =
                "From : " + modelDTO.getEmail() +"\nFull name : "+ modelDTO.getFullName()+"\n\n"+ modelDTO.getMessage();

        fromUserMessage.setText(finalMessage);

        mailSender.send(fromUserMessage);

        var fromMeMessage = new SimpleMailMessage();

        fromMeMessage.setTo(modelDTO.getEmail());

        fromMeMessage.setText("Hello "+ modelDTO.getFullName()+",\n" +
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
