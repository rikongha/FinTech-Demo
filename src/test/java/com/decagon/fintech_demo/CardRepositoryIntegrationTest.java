package com.decagon.fintech_demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.decagon.fintech_demo.entities.Card;
import com.decagon.fintech_demo.repositories.CardRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CardRepositoryIntegrationTest {
 
	
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private CardRepository cardRepository;
 
    @Test
    public void findByNumber() {
        // given
        Card card = new Card();
        card.setNumber("123456");
        card.setBank("UBS");
        card.setScheme("Visa");
        entityManager.persist(card);
        entityManager.flush();
     
        
        Card found = cardRepository.findByNumber(card.getNumber()).get();
     
        // then
        assertThat(found.getNumber())
          .isEqualTo(found.getNumber());
    }
 
    
    @Test
    public void save() {
        // given
        Card card = new Card();
        card.setNumber("123456");
        card.setBank("UBS");
        card.setScheme("Visa");
     
        
        Card found = cardRepository.save(card);
     
        // then
        assertThat(found.getNumber())
          .isEqualTo(found.getNumber());
    }
}