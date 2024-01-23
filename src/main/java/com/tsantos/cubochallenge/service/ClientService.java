package com.tsantos.cubochallenge.service;

import com.tsantos.cubochallenge.entity.Client;
import com.tsantos.cubochallenge.entity.dto.request.ClientRequestDTO;
import com.tsantos.cubochallenge.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(ClientRequestDTO clientRequestDTO){

        Client client = new Client();

        client.setFirstName(clientRequestDTO.firstName());
        client.setLastName(clientRequestDTO.lastName());
        client.setParticipation(clientRequestDTO.participation());

        if(client == null){
            throw new NullPointerException();
        }

       return clientRepository.save(client);
    }

    public List<Client> getAllClients(){
        List<Client> allClients = clientRepository.findAll();

        if(allClients == null){
            throw new NullPointerException();
        }

        return allClients;
    }

    public Client updateClient(ClientRequestDTO clientRequestDTO) {
        Optional<Client> optionalClient = clientRepository.findById(clientRequestDTO.id());

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setFirstName(clientRequestDTO.firstName());
            client.setLastName(clientRequestDTO.lastName());
            client.setParticipation(clientRequestDTO.participation());

            return clientRepository.save(client);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
