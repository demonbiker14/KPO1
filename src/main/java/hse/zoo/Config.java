package hse.zoo;

import org.springframework.context.annotation.Bean;

public class Config {

    @Bean
    public Clinics clinics() {
        return new Clinics();
    }

    @Bean
    public Zoo zoo(Clinics clinics) {
        return new Zoo(clinics);
    }

    @Bean
    public CommandParser commandParser(Zoo zoo) {
        return new CommandParser(zoo);
    }
}
