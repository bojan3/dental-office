package com.dentaloffice.service.impl;

import com.dentaloffice.emailcontext.CancelAppointmentMail;
import com.dentaloffice.emailcontext.CreateAppointmentMail;
import com.dentaloffice.emailcontext.EmailContext;
import com.dentaloffice.model.Appoitment;
import com.dentaloffice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    private void sendMail(EmailContext email) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        Context context = new Context();
        context.setVariables(email.getContext());
        String emailContent = templateEngine.process(email.getTemplateLocation(), context);

        mimeMessageHelper.setTo(email.getTo());
        mimeMessageHelper.setSubject(email.getSubject());
        mimeMessageHelper.setFrom(email.getFrom());
        mimeMessageHelper.setText(emailContent, true);
        emailSender.send(message);
    }

    @Override
    public void sendAppointmentCanceledNotification(Appoitment appointment) throws MessagingException {

        CancelAppointmentMail mail = new CancelAppointmentMail();
        mail.init(appointment.getPatient().getUser().getEmail());
        mail.setTo(appointment.getPatient().getUser().getEmail());
        mail.setInfo(appointment.getStartDateTime());
        this.sendMail(mail);

    }

    @Override
    public void sendAppoitmentCreatedNotification(Appoitment appointment) throws MessagingException {
        CreateAppointmentMail mail = new CreateAppointmentMail();
        mail.init(appointment.getPatient().getUser().getEmail());
        mail.setTo(appointment.getPatient().getUser().getEmail());
        mail.setInfo(appointment.getStartDateTime());
        this.sendMail(mail);

    }

}
