package dev.zhen.servicetests;


import dev.zhen.daos.LocalClientDAO;
import dev.zhen.entities.Client;
import dev.zhen.services.ClientService;
import dev.zhen.services.ClientServiceImpl;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceTests {

    private static ClientService clientService = new ClientServiceImpl(new LocalClientDAO());
    private static Client client = null;


    @Test
    @Order(0)
    void register_client() {
        Client client1 = new Client(0, "client1");
        clientService.registerClient(client1);
        client = client1;
        Assertions.assertEquals(1, client1.getClientId());
        System.out.println("Test 0 passed: register client");
    }

    @Test
    @Order(1)
    void get_all_clients() {
        Set<Client> allClients = clientService.getAllClients();
        Assertions.assertEquals(1, allClients.size());
        System.out.println("Test 1 pass: get all clients");
    }

    @Test
    @Order(2)
    void get_client_by_id() {
        Client client2 = clientService.getClientById(client.getClientId());
        Assertions.assertEquals(1, client2.getClientId());
        System.out.println("Test 2 pass: get client by id");
    }

    @Test
    @Order(3)
    void update_client_by_id() {
        Client client3 = clientService.getClientById(client.getClientId());
        client3.setName("client3");
        Assertions.assertTrue(client3.getName().equals("client3"));
        System.out.println("Test 3 pass: update client by id");
    }

    @Test
    @Order(4)
    void delete_client_by_id() {
        Client client4 = new Client(0, "client4");
        clientService.registerClient(client4);
        int sizeBeforeDelete = clientService.getAllClients().size();
        boolean isDeleted = clientService.deleteClientById(client.getClientId());
        int sizeAfterDelete = clientService.getAllClients().size();
        Assertions.assertTrue(isDeleted);
        Assertions.assertEquals(sizeBeforeDelete, sizeAfterDelete + 1);
        System.out.println("Test 4 pass: delete client by id");
    }


}
