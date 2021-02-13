package dev.zhen.daos;

import dev.zhen.entities.Client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LocalClientDAO implements ClientDAO{

    private final Map<Integer, Client> clientTable = new HashMap<>();
    private int idCounter = 0;
    @Override
    public Client createClient(Client client) {
        client.setClientId(++this.idCounter);
        clientTable.put(idCounter, client);
        return client;
    }

    @Override
    public Set<Client> getAllClient() {
        Set<Client> allClient = new HashSet<>(this.clientTable.values());
        return allClient;
    }

    @Override
    public Client getClientById(int id) {
        return this.clientTable.get(id);
    }

    @Override
    public boolean deleteClientById(int id) {
        Client client = this.clientTable.remove(id);
        if (client == null)
            return false;
        return true;
    }
}
