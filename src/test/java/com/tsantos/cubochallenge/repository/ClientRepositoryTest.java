package com.tsantos.cubochallenge.repository;

import com.tsantos.cubochallenge.entity.Client;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

@DataJpaTest
class ClientRepositoryTest {

    @InjectMocks
    private final ClientRepository clientRepository;

    private Client client;

    ClientRepositoryTest(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @BeforeEach
    public void setClientConfiguration(){
        this.client = new Client("Thais",
                "Santos",
                new BigDecimal(20.00)
        );
    }

    @Test
    @DisplayName("Should save client")
    void saveClient(){
        Client savedClient = clientRepository.save(client);

        Assertions.assertNotNull(savedClient);
        Assertions.assertEquals(savedClient, client);
        Assertions.assertNotNull(savedClient.getId());
    }
}