package com.decagon.fintech_demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.decagon.fintech_demo.entities.Hit;
import com.decagon.fintech_demo.repositories.HitRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HitRepositoryIntegrationTest {
 
	
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private HitRepository hitRepository;
 
    @Test
    public void findByNumber() {
        // given
        Hit card = new Hit();
        card.setCardNumber("123456");
        card.setCount(1);
        entityManager.persist(card);
        entityManager.flush();
     
        
        Hit found = hitRepository.findByCardNumber(card.getCardNumber()).get();
     
        // then
        assertThat(found.getCardNumber())
          .isEqualTo(found.getCardNumber());
    }
 
    
}