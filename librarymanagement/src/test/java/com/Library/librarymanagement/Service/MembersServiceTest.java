package com.Library.librarymanagement.Service;

import com.Library.librarymanagement.Repository.MembersRepo;
import com.Library.librarymanagement.entity.Members;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MembersServiceTest {
    @Mock
    MembersRepo membersRepo;
    @InjectMocks
    MembersService membersService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addmember()
    {
        Members member = new Members();
        member.setMemberId(UUID.randomUUID().toString());
        member.setName("Hello");
        member.setEmail("abc@gmail");
        member.setAddress("kukat");
        member.setPhoneNumber(9008990);
        when(membersRepo.save(member)).thenReturn(member);
        Members result = membersService.addmember(member);
        assertEquals(member,result);

    }


    @Test
    void testUpdateMember() {

        Members existingMember = new Members();
        existingMember.setMemberId(UUID.randomUUID().toString());
        existingMember.setName("John Doe");
        existingMember.setAddress("123 Main St");
        existingMember.setPhoneNumber(1234567890);
        existingMember.setEmail("john@example.com");

        Members updatedMember = new Members();
        updatedMember.setMemberId(existingMember.getMemberId());
        updatedMember.setName("Jane Doe");
        updatedMember.setAddress("456 Elm St");
        updatedMember.setPhoneNumber(12345);
        updatedMember.setEmail("jane@example.com");

        when(membersRepo.findById(existingMember.getMemberId())).thenReturn(Optional.of(existingMember));
        when(membersRepo.save(existingMember)).thenReturn(existingMember);

        // When
        Members result = membersService.updateMember(existingMember.getMemberId(), updatedMember);

        // Then
        assertNotNull(result);
        assertEquals("Jane Doe", result.getName());
        assertEquals("456 Elm St", result.getAddress());

        assertEquals("jane@example.com", result.getEmail());
    }



    @Test
    void testUpdateMember_ExistingMember() {
        // Mock data
        Members existingMember = new Members();
        existingMember.setMemberId("1");
        existingMember.setName("John Doe");
        existingMember.setAddress("123 Main St");
        existingMember.setPhoneNumber(1234567890);
        existingMember.setEmail("john.doe@example.com");

        Members updatedMember = new Members();
        updatedMember.setMemberId("1");
        updatedMember.setName("Jane Doe");
        updatedMember.setAddress("456 Elm St");
        updatedMember.setPhoneNumber(987654210);
        updatedMember.setEmail("jane.doe@example.com");

        when(membersRepo.findById("1")).thenReturn(Optional.of(existingMember));
        when(membersRepo.save(existingMember)).thenReturn(existingMember);

        // Call the method
        Members result = membersService.updateMember(existingMember.getMemberId(), updatedMember);

        // Assertions
        assertNotNull(result);
        assertEquals("Jane Doe", result.getName());
        assertEquals("456 Elm St", result.getAddress());
        assertEquals(987654210,result.getPhoneNumber());
    }

    @Test
    void testUpdateMember_NonExistingMember() {
        // Mock data
        Members existingMember = null;

        Members updatedMember = new Members();
        updatedMember.setMemberId("1");
        updatedMember.setName("Jane Doe");
        updatedMember.setAddress("456 Elm St");
        updatedMember.setPhoneNumber(987643210);
        updatedMember.setEmail("jane.doe@example.com");

        when(membersRepo.findById("1")).thenReturn(Optional.empty());
        // Call the method
        Members result = membersService.updateMember("1", updatedMember);

        // Assertions
        assertNull(result);
    }



    }