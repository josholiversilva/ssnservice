package com.josh.personal.SecretSantaService.repository;

import com.josh.personal.SecretSantaService.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventsRepository extends JpaRepository<Event, Integer> {
    @Query(value = "SELECT * FROM Events WHERE group_name=?1 AND year=?2", nativeQuery = true)
    List<Event> getEventWithGroupAndYear(String group, Integer year);
}
