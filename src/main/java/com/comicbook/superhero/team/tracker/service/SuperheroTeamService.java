package com.comicbook.superhero.team.tracker.service;

import com.comicbook.superhero.team.tracker.dto.SuperHero;

import java.util.List;

public interface SuperheroTeamService {
    /**
     * This method will return all the existing justice league
     *
     * @return a list of {@link SuperHero}
     */
    List<SuperHero> getJusticeLeague();

    List<SuperHero> avengersAssemble();
}
