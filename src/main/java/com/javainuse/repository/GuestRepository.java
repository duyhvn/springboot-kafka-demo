package com.javainuse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.Guest;
 
@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByGuestId(Long empId);
}