package org.example.server.games;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.generator.EventType;

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

    public boolean updateMaxScore(int points){
        if(points>maxScore){
            PlayerDAO.update(this);
        }
    }

    public void addGame(Game game){

    }
}
