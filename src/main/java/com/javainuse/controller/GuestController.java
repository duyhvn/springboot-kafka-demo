package com.javainuse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.exception.ResourceNotFoundException;
import com.javainuse.model.Guest;
import com.javainuse.repository.GuestRepository;


@RestController
public class GuestController {

	@Autowired
	private GuestRepository guestRepository;

	@GetMapping("/guest/{guestId}")
	public List<Guest> getGuestByguestId(@PathVariable Long guestId) {
		return guestRepository.findByGuestId(guestId);
	}

	@GetMapping("/guests")
	public Page<Guest> getQuestions(Pageable pageable) {
		return guestRepository.findAll(pageable);
	}

	@PostMapping("/guest")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Guest createQuestion(@Valid @RequestBody Guest guest) {
		return guestRepository.save(guest);
	}

	@PutMapping("/guest/{guestId}")
	public Guest updateQuestion(@PathVariable Long guestId, @Valid @RequestBody Guest guestRequest) throws ResourceNotFoundException {
		return guestRepository.findById(guestId).map(guest -> {
			guest.setName(guestRequest.getName());
			guest.setEmail(guestRequest.getEmail());
			guest.setEventType(guestRequest.getEventType());
			guest.setNoAttendance(guestRequest.getNoAttendance());
			guest.setMessage(guestRequest.getMessage());
			return guestRepository.save(guest);
		}).orElseThrow(() -> new ResourceNotFoundException("Guest not found with id " + guestId));
	}

	@DeleteMapping("/guest/{guestId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long guestId) throws ResourceNotFoundException {
		return guestRepository.findById(guestId).map(guest -> {
			guestRepository.delete(guest);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Guest not found with id" + guestId));
	}
}
