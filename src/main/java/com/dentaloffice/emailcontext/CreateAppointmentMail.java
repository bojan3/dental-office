package com.dentaloffice.emailcontext;

import java.time.LocalDateTime;

public class CreateAppointmentMail extends EmailContext{
    @Override
    public <T> void init(T context){
        String email = (String) context;
        setTemplateLocation("createAppointment");
        setFrom("potuc3@gmail.com");
        setSubject("Zubarska ordinacija obaveštenje");
        setTo(email);
    }

    public void setInfo(LocalDateTime date){
        put("date", date.toString());
    }
}
