package guru.springframework.sfgpetclinic.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * JUnit Test for Owner class
 */
public class OwnerTest {

    @Mock
    Owner owner;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPets() {
        Set<Pet> pets = new HashSet<>();
        Pet pet = new Pet();
        pets.add(pet);

        when(owner.getPets()).thenReturn(pets);

        assertEquals(1, owner.getPets().size());
        verify(owner, times(1)).getPets();
    }

    @Test
    public void setAddress() {
        String address = "owner's address";
        when(owner.getAddress()).thenReturn(address);

        assertEquals(address, owner.getAddress());
    }
}