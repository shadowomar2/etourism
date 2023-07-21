package com.example.demo.repository;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.events.EventsComments;
 
public interface EventsCommentsRepository extends JpaRepository<EventsComments, Long> {
	List<EventsComments> findByEvents_id(long event_id);
}
