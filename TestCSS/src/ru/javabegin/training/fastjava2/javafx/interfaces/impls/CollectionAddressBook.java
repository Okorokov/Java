package ru.javabegin.training.fastjava2.javafx.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.javabegin.training.fastjava2.javafx.objects.Person;
import ru.javabegin.training.fastjava2.javafx.interfaces.AddressBook;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Petrowich on 23.03.2017.
 */
public class CollectionAddressBook implements AddressBook{

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }
    public void print(){
        int number=0;
        System.out.println();
        for(Person person:personList){
            number++;
            System.out.println(number+") fio = "+person.getFio()+"; phone = "+ person.getPhone());
        }
    }
    public void fillTestData(){
        personList.add(new Person("Иван","+798056565654"));
        personList.add(new Person("Саша","+790515198488"));
        personList.add(new Person("Маша","+780115195195"));
        personList.add(new Person("Даша","+750984094005"));
        personList.add(new Person("Оля","+765051611601"));
        personList.add(new Person("Коля","+75156105016"));
    }
}
