package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {

    private OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        Owner owners_beforeEach = Owner.builder().address("owners adress").build();
        owners_beforeEach.setLastName("Default Owners Last Name");
        ownerServiceMap.save(owners_beforeEach);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        assertEquals((Long) 1L, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 3L;
        Owner owner3 = Owner.builder().address("owner3 adress").build();
        owner3.setId(id);
        Owner savedOwner = ownerServiceMap.save(owner3);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner2 = Owner.builder().address("owner2 adress").build();
        ownerServiceMap.save(owner2);
        assertEquals((Long) 2L, owner2.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(1L));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner4 = Owner.builder().address("owner3 adress").build();
        owner4.setLastName("Smith");
        Owner savedOwner = ownerServiceMap.save(owner4);
        Owner smith = ownerServiceMap.findByLastName("Smith");
        assertNotNull(smith);
        assertEquals("Smith", smith.getLastName());
    }
}