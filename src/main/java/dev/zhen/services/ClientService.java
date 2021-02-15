package dev.zhen.services;

import dev.zhen.entities.Client;

import java.util.Set;

public interface ClientService {

    Client registerClient(Client client);
    Set<Client> getAllClients();
    Client getClientById(int id);
    Client updateClientById(int id, Client client);
    boolean deleteClientById(int id);

}
