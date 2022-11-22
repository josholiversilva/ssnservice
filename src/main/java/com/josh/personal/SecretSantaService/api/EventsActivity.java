package com.josh.personal.SecretSantaService.api;

import com.josh.personal.SecretSantaService.dao.EventsDAO;
import com.josh.personal.SecretSantaService.entities.Event;
import com.josh.personal.SecretSantaService.entities.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/events")
@RestController
public class EventsActivity {
    @Autowired
    EventsDAO eventsDAO;

    @CrossOrigin
    @GetMapping(path = {"{group}/{year}"})
    public Event getEvent(@PathVariable("group") String group,
                          @PathVariable("year") Integer year) {
        System.out.println("group = " + group + " & year = " + year);
        return eventsDAO.getEventWithGroupAndYear(group, year);
    }
}
