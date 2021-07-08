package by.it_academy.jd2.hw.example.messenger.config;


import by.it_academy.jd2.hw.example.messenger.storage.api.IChatRepository;
import by.it_academy.jd2.hw.example.messenger.storage.api.IUserRepository;
import by.it_academy.jd2.hw.example.messenger.view.AuthView;
import by.it_academy.jd2.hw.example.messenger.view.MessageView;
import by.it_academy.jd2.hw.example.messenger.view.UserView;
import by.it_academy.jd2.hw.example.messenger.view.api.IAuthView;
import by.it_academy.jd2.hw.example.messenger.view.api.IMessageView;
import by.it_academy.jd2.hw.example.messenger.view.api.IUserView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configures Spring Framework dependencies and beans
 * @author Maksim Perekladov
 * @version 2.0
 */
@Configuration
@ComponentScan("by.it_academy.jd2.hw.example.messenger.config")
public class RootConfig {


    @Bean
    public IAuthView authView(IUserView userView){
        return new AuthView(userView);
    }

    @Bean
    public IMessageView messageView(IChatRepository repository){
        return new MessageView(repository);
    }

    @Bean
    public IUserView userView(IUserRepository userRepository, IMessageView messageView){
        return new UserView(userRepository, messageView);
    }
}
