package com.dentaloffice.emailcontext;

import java.time.LocalDateTime;

public class CancelAppointmentMail extends EmailContext{

    @Override
    public <T> void init(T context){
        String email = (String) context;
        setTemplateLocation("cancelAppointment");
        setFrom("potuc3@gmail.com");
        setSubject("Zubarska ordinacija obaveštenje");
        setTo(email);
    }

    public void setInfo(LocalDateTime date){
        put("date", date.toString());
    }

}
