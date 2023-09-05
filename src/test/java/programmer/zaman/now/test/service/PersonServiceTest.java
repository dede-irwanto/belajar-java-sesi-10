package programmer.zaman.now.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import programmer.zaman.now.test.data.Person;
import programmer.zaman.now.test.repository.PersonRepository;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // menambah behavour ke mock object
        Mockito.when(personRepository.selectById("dede")).thenReturn(new Person("dede", "Dede Irwanto"));

        var person = personService.get("dede");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("dede", person.getId());
        Assertions.assertEquals("Dede Irwanto", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Dede");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Dede", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1)).insert(new Person(person.getId(), "Dede"));
    }
}
