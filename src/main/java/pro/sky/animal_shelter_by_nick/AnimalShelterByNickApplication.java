package pro.sky.animal_shelter_by_nick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AnimalShelterByNickApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalShelterByNickApplication.class, args);
    }

}
