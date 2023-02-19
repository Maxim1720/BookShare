package ru.simbirsoft.BookGo.service;

import org.springframework.stereotype.Service;
import ru.simbirsoft.BookGo.dto.UserDTO;

import java.util.List;
import java.util.Random;

@Service
public class NicknameGenerator {
    private static final String MALE_DEF = "/MaleDefinitions";
    private static final String MALE_NOUNS = "/MaleNouns";
    private static final String FEMALE_DEF = "/FemaleDefinitions";
    private static final String FEMALE_NOUNS = "/FemaleNouns";
    private static final String NEUTER_DEF = "/NeuterDefinitions";
    private static final String NEUTER_NOUNS = "/NeuterNouns";

    private List<String> definitionsList;
    private List<String> nounsList;
    private int counter;
    private String name;
    private final ReadFiler filer;
    //private final UserDTO userDTO;
    private final Random random = new Random();

    public NicknameGenerator(ReadFiler filer) {
        this.filer = filer;
    }

    //Метод возвращает случайную комбинацию прилагательного + существительного из List`ов definitionsList и nounsList
    public UserDTO getNickname() {
        if(counter > 2) {
            counter = 0;
        }
        if(counter == 0){
            definitionsList = filer.readFile(MALE_DEF);
            nounsList = filer.readFile(MALE_NOUNS);
        } else if(counter == 1){
            definitionsList = filer.readFile(FEMALE_DEF);
            nounsList = filer.readFile(FEMALE_NOUNS);
        } else {
            definitionsList = filer.readFile(NEUTER_DEF);
            nounsList = filer.readFile(NEUTER_NOUNS);
        }
        counter++;

        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(getRandomElement(definitionsList) + " " + getRandomElement(nounsList));

        definitionsList.clear();
        nounsList.clear();

        return userDTO;
    }

    //Метод возвращает случайный элемент списка
    private String getRandomElement(List<String> list) {
        return list.get(random.nextInt(list.size()));
    }

}
