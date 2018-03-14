package kon.rafal.quiz.EmailService;

import org.springframework.stereotype.Service;

@Service
public interface EmailServices {

    public void sendSimpleMessage(String to, String subject, String text);


}
