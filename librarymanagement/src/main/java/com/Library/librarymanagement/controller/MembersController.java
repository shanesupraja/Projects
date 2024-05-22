//package com.Library.librarymanagement.controller;
//
//import com.Library.librarymanagement.Service.MembersService;
//import com.Library.librarymanagement.entity.Members;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//
//public class MembersController
//{
//    @Autowired
//    private MembersService memberService;
//    @PostMapping("/addmembers")
//    public Members addBooks(@RequestBody Members members){
//        return memberService.addmember(members);
//    }
//
//    @PutMapping("/{memberId")
//    public Members updateMembers(@PathVariable long memberId, @RequestBody Members updatedMember)
//    {
//        Members updated = memberService.updateMember(memberId,updatedMember);
//        if(updated != null)
//        {
//            return updated;
//        }
//        else
//        {
//
//            throw new ConfigDataResourceNotFoundException("Member has not been found with the given memberId");
//
//        }
//
//    }
//
//}
package com.Library.librarymanagement.controller;

import com.Library.librarymanagement.Service.MembersService;

import com.Library.librarymanagement.entity.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MembersController {

    @Autowired
    private MembersService membersService;

    @PostMapping("/addmembers")
    public Members addMembers(@RequestBody Members members) {
       // return memberService.addMember(members);
        return membersService.addmember(members);
    }

    @PutMapping("/{memberId}")
    public Members updateMembers(@PathVariable String memberId, @RequestBody Members updatedMember) {
        Members updated = membersService.updateMember(memberId, updatedMember);
        if (updated != null) {
            return updated;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Member has not been found with the given memberId");        }
    }


}

