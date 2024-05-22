package com.Library.librarymanagement.controller;

import com.Library.librarymanagement.Service.MembersService;
import com.Library.librarymanagement.entity.Members;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MembersControllerTest {
    @Mock
    MembersService membersService;
    @InjectMocks
    MembersController membersController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addMembers()
    {
        Members member = new Members();
        when(membersService.addmember(member)).thenReturn(member);
        Members result = membersController.addMembers(member);
        assertEquals(member,result);
    }
    @Test
    void testUpdateMembers_SuccessfulUpdate() {
        // Given
        String memberId = "1";
        Members updatedMember = new Members();
        updatedMember.setMemberId("1");
        updatedMember.setName("Jane Doe");
        updatedMember.setAddress("456 Elm St");
        updatedMember.setPhoneNumber(1234);
        updatedMember.setEmail("jane@example.com");

        when(membersService.updateMember(memberId, updatedMember)).thenReturn(updatedMember);

        // When
        Members result = membersController.updateMembers(memberId, updatedMember);

        // Then
        assertNotNull(result);
        assertEquals("Jane Doe", result.getName());
        assertEquals("456 Elm St", result.getAddress());
        assertEquals(1234, result.getPhoneNumber());
        assertEquals("jane@example.com", result.getEmail());
    }

    @Test
    void testUpdateMembers_MemberNotFound() {
        // Given
        String memberId = "1";
        Members updatedMember = new Members();
        updatedMember.setMemberId("1");
        updatedMember.setName("Jane Doe");
        updatedMember.setAddress("456 Elm St");
        updatedMember.setPhoneNumber(7890);
        updatedMember.setEmail("jane@example.com");

        when(membersService.updateMember(memberId, updatedMember)).thenReturn(null);


        assertThrows(ResponseStatusException.class, () -> membersController.updateMembers(memberId, updatedMember));
    }


}