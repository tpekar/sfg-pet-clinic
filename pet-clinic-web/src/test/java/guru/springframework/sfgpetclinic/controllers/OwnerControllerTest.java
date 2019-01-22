package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class OwnerControllerTest {

    OwnerController ownerController;

    @Mock
    OwnerService ownerService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController(ownerService);
    }

    @Test
    public void listOwners() {
        assertEquals("owners/index", ownerController.listOwners(model));
        verify(ownerService, times(1)).findAll();

        ArgumentCaptor<Set<Owner>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
        verify(model, times(1)).addAttribute(eq("owners"), argumentCaptor.capture());

    }

    @Test
    public void findOwners() {
        Set<Owner> owners = new HashSet<>();
        Owner owner0 = new Owner();
        owner0.setFirstName("Pete");
        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona");
        owners.add(owner0);
        owners.add(owner1);

        when(ownerService.findAll()).thenReturn(owners);
        assertEquals(owners.size(), ownerService.findAll().size());
    }
}