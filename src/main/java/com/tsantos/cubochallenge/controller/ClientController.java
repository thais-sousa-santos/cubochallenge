package com.tsantos.cubochallenge.controller;

import com.tsantos.cubochallenge.entity.Client;
import com.tsantos.cubochallenge.entity.dto.request.ClientRequestDTO;
import com.tsantos.cubochallenge.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/save")
    public ResponseEntity<Client> saveClient(@RequestBody ClientRequestDTO clientRequestDTO){
      Client result =  clientService.saveClient(clientRequestDTO);

      return ResponseEntity
              .ok()
              .body(result);

    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Client>> listAllClients(){
      List<Client> clientsList = clientService.getAllClients();

      return ResponseEntity
              .ok()
              .body(clientsList);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody @Valid ClientRequestDTO clientRequestDTO){
        Client result = clientService.updateClient(clientRequestDTO);

        return ResponseEntity
                .ok()
                .body(result);
    }

}
