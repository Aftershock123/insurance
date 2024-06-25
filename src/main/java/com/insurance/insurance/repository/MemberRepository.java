package com.insurance.insurance.repository;

import com.insurance.insurance.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MemberRepository extends JpaRepository<Member,Integer> {

    
}
