package com.insurance.insurance.controller;
 
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.insurance.insurance.model.Member;
import com.insurance.insurance.repository.MemberRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;


@RestController

public class MemberController {
    @Autowired
    MemberRepository memberrepository;

    @GetMapping("/members")
    public List<Member>getAllMember (){
     List<Member> member = memberrepository.findAll();
        return member;
    }

    @GetMapping("/members/{id}")    
    public Member getMember(@PathVariable int id){
        Member member = memberrepository.findById(id).get();
        return member;
    }
    
    @PostMapping("/members/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createMember(@RequestBody Member member) {
        memberrepository.save(member);
    }
    
    @PutMapping("/members/update/{id}")
    public Member updateMember(@PathVariable int id,@RequestBody Member updatemember) throws Exception{
       Member member = memberrepository.findById(id).get();
       if(member == null){
        throw new Exception("member not found");
       }
       member.setFirst_Name(updatemember.getFirst_Name());
       member.setLast_Name(updatemember.getLast_Name());
       member.setAddress(updatemember.getAddress());
       member.setTell(updatemember.getTell());
       Member updatemembers = memberrepository.save(member);
    return updatemembers;
    }

    @DeleteMapping("/members/delete/{id}")
    public Member deleteMember(@PathVariable int id) throws Exception{
        Member member = memberrepository.findById(id).get();
        if(member == null){
         throw new Exception("member not found");
        }
        
       memberrepository.deleteById(id);
        return member;

     }
}
