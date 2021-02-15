package dev.zhen.services;

import dev.zhen.daos.ClientDAO;
import dev.zhen.entities.Client;

import java.util.Set;

public class ClientServiceImpl implements ClientService{

    private ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public Client registerClient(Client client) {
        clientDAO.createClient(client);
        return client;
    }

    @Override
    public Set<Client> getAllClients() {
        return clientDAO.getAllClient();
    }

    @Override
    public Client getClientById(int id) {
        return clientDAO.getClientById(id);
    }

    @Override
    public Client updateClientById(int id, Client client) {
        return clientDAO.updateClientById(id, client);
    }

    @Override
    public boolean deleteClientById(int id) {
        return clientDAO.deleteClientById(id);
    }
}
