package ru.javabegin.training.fastjava2.javafx.interfaces;

import ru.javabegin.training.fastjava2.javafx.objects.Person;

/**
 * Created by Petrowich on 23.03.2017.
 */
public interface AddressBook {

    //добавить запись
    void add(Person person);

    //внести измененные значения (потвердить измененные данные)
    void update(Person person);

    //удалить запись
    void delete(Person person);
}
