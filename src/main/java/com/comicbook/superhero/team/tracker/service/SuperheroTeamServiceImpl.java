package com.comicbook.superhero.team.tracker.service;

import com.comicbook.superhero.team.tracker.dto.SuperHero;
import com.comicbook.superhero.team.tracker.enums.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * This class provides the functionality for the superhero team tracker.
 *
 * @author dinuka
 */
@Service
public class SuperheroTeamServiceImpl implements SuperheroTeamService {

    private static Logger log = LoggerFactory.getLogger(SuperheroTeamService.class);

    @Override
    public List<SuperHero> getJusticeLeague() {
        log.info("Received a request to get all the justice league members");
        return populateJusticeLeague();
    }

    private List<SuperHero> populateJusticeLeague() {
        SuperHero superMan = new SuperHero("Clark Kent", Arrays.asList("Flight", "Super human strength",
                "X-ray vision"), "Metropolis", Publisher.DC.getName());
        SuperHero flash = new SuperHero("Barry Allen", Arrays.asList("Super speed",
                "Tapping into the speed force", "Time travel"), "Central city", Publisher.DC.getName());
        SuperHero batman = new SuperHero("Bruce Wayne", Arrays.asList("Super rich", "Cool Gadgets"),
                "Gotham", Publisher.DC.getName());
        return Arrays.asList(superMan, flash, batman);
    }

    public List<SuperHero> avengersAssemble() {
        return null;
    }
}
