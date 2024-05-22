package com.Library.librarymanagement.Service;

import com.Library.librarymanagement.Repository.MembersRepo;
import com.Library.librarymanagement.entity.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class MembersService
{
    @Autowired
    private MembersRepo memberRepo;

    public Members addmember(Members member){
        return memberRepo.save(member);
    }
    public Members updateMember(String memberId, Members updatedMember)
    {
        Optional<Members> existingMember = memberRepo.findById(memberId);
        if(existingMember.isPresent())
        {
            Members members=existingMember.get();
            members.setName(updatedMember.getName());
            members.setAddress(updatedMember.getAddress());
            members.setPhoneNumber(updatedMember.getPhoneNumber());
            members.setEmail(updatedMember.getEmail());
            return memberRepo.save(members);


        }
        return null;
    }

}
