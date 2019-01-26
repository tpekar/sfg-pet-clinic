package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class OwnerRepositoryIT {

    @Autowired
    OwnerRepository ownerRepository;

    @Test
    public void findByLastName() {
        Owner owner = ownerRepository.findByLastName("");
        assertEquals("", owner.getLastName());
    }
}