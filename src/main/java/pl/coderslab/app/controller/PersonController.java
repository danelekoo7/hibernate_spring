package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.dao.PersonDao;
import pl.coderslab.app.dao.PersonDetailsDao;
import pl.coderslab.app.entity.Person;
import pl.coderslab.app.entity.PersonDetails;

@Controller
public class PersonController {

    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;


    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @RequestMapping("/addPerson")
    @ResponseBody
    public String addPerson() {

        PersonDetails personDetails = new PersonDetails();

        personDetails.setFirstName("Daniel");
        personDetails.setLastName("jed");
        personDetails.setCity("slask");
        personDetails.setStreet("fiolkowa");
        personDetails.setStreetNumber(77);

        personDetailsDao.savePersonDetails(personDetails);

        Person person = new Person();
        person.setEmail("d@g");
        person.setLogin("daniel");
        person.setPassword("aaa");
        person.setPersonDetails(personDetails);


        personDao.savePerson(person);


        return "Id dodanej osoby to:"
                + person.getId();
    }

}
