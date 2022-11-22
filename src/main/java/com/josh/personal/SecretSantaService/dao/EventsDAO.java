package com.josh.personal.SecretSantaService.dao;

import com.josh.personal.SecretSantaService.entities.Event;
import com.josh.personal.SecretSantaService.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsDAO {
    @Autowired
    EventsRepository repository;

    public Event getEventWithGroupAndYear(String group, Integer year) {
        List<Event> events = repository.getEventWithGroupAndYear(group, year);
        if (events.size() == 0) {
            return null;
        }

        return events.get(0);
    }
}
