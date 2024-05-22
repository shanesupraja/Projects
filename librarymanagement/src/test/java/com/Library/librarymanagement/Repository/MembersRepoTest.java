package com.Library.librarymanagement.Repository;

import com.Library.librarymanagement.entity.Members;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class MembersRepoTest {
    @Mock
    MembersRepo membersRepo;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById() {
    }
    @Test
    void findById_ExistingMember() {
        // Mock data
        String memberId = "1";
        Members member = new Members();
        member.setMemberId(memberId);

        // Stubbing the repository method
        when(membersRepo.findById(memberId)).thenReturn(Optional.of(member));

        // Call the method being tested
        Optional<Members> result = membersRepo.findById(memberId);

        // Verify the result
        assertEquals(member, result.get());
    }

    @Test
    void findById_NonExistingMember() {
        // Mock data
        String memberId = "2";

        // Stubbing the repository method
        when(membersRepo.findById(memberId)).thenReturn(Optional.empty());

        // Call the method being tested
        Optional<Members> result = membersRepo.findById(memberId);

        // Verify the result
        assertEquals(Optional.empty(), result);
    }
}