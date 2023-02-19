package ru.simbirsoft.BookGo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.simbirsoft.BookGo.entity.User;
import ru.simbirsoft.BookGo.service.MailSender;
import ru.simbirsoft.BookGo.service.UserServiceImpl;

import java.util.UUID;

@Component
public class RegistrationListener implements
        ApplicationListener<OnRegistrationCompleteEvent> {
    private final UserServiceImpl service;
    private final MailSender mailSender;

    @Autowired
    public RegistrationListener(UserServiceImpl service, MailSender mailSender) {
        this.service = service;
        this.mailSender = mailSender;
    }

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }
    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        service.createVerificationToken(user, token);

        String confirmationUrl
                = event.getAppUrl() + "/registration/activate?token=" + token;

        mailSender.send(user.getEmail(),
                "Registration Confirmation",
                "\r\n" + "http://localhost:8080" + confirmationUrl + ">Confirm mail!");
    }
}
