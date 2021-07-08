package by.it_academy.jd2.hw.example.messenger.config;

import by.it_academy.jd2.hw.example.messenger.controller.SecurityFilterSpring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/**
 * Spring controllers config
 * @author Maksim Perekladov
 * @version 2.0
 */
@Configuration
@ComponentScan("by.it_academy.jd2.hw.example.messenger.controller")
public class WebConfig implements WebMvcConfigurer {

}
