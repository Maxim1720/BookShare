package ru.simbirsoft.BookGo.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReadListFiler implements ReadFiler{

    //TODO Если останется время требуется продумать считывание файлов (сейчас при обращении каждый раз считывается заново)
    //Метод считывает файл и затем заполняет ArrayList
    public List<String> readFile(String path){
        List<String> list = new ArrayList<>();
        InputStream inputStream = getClass().getResourceAsStream(path);

        if(inputStream != null && !path.isEmpty()){
            try (BufferedReader brDefinitions = new BufferedReader(new InputStreamReader(inputStream))){
                list.addAll(brDefinitions.lines().collect(Collectors.toList()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else throw new IllegalArgumentException("file is not found!");
        return list;
    }

}
