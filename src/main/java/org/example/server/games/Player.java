package org.example.server.games;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.example.server.dao.GameDAO;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.generator.EventType;
import org.example.server.dao.PlayerDAO;

import java.time.LocalDate;

@Entity
public class Player {
    @Id
    private String name;
    private String pass;
    @CurrentTimestamp(event = EventType.INSERT)
    private LocalDate registrationDate;
    private int maxScore;
    @OneToMany (mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private Game[] games;

    public Player(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public boolean updateMaxScore(int points){
        boolean isUptaded = false;
        if(points>maxScore){
             isUptaded= PlayerDAO.update(this);
        }
        return isUptaded;
    }

    public void addGame(Game game){
        GameDAO.create(game);
    }
}
