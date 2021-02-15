package dev.zhen.daotests;

import dev.zhen.daos.ClientDAO;
import dev.zhen.daos.LocalClientDAO;
import dev.zhen.entities.Client;
//import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientDaoTests {

    private static ClientDAO clientDAO = new LocalClientDAO();
    private static Client client = null;
//    private static Logger logger = Logger.getLogger(ClientDaoTests.class.getName());

    @Test
    @Order(0)
    void create_client() {
        Client client1 = new Client(0,"Jordan");
        this.clientDAO.createClient(client1);
        this.client = client1;
        Assertions.assertNotEquals(0, client1.getClientId());
        System.out.println("TEST 0 passed: create client");
    }

    @Test
    @Order(1)
    void get_all_client() {
        Client client2 = new Client(0,"Steph");
        this.clientDAO.createClient(client2);
        Assertions.assertEquals(2, this.clientDAO.getAllClient().size());
        System.out.println("TEST 1 passed: get all client");
    }

    @Test
    @Order(2)
    void get_client_by_id() {
        Client client3 = this.clientDAO.getClientById(1);
        Assertions.assertEquals(1, client3.getClientId());
        System.out.println("TEST 2 passed: get client by id");
    }

    @Test
    @Order(3)
    void delete_client_by_id() {
        int sizeBeforeDelete = this.clientDAO.getAllClient().size();
        boolean isDeleted = this.clientDAO.deleteClientById(this.client.getClientId());
        int sizeAfterDelete = this.clientDAO.getAllClient().size();
        Assertions.assertTrue(isDeleted);
        Assertions.assertEquals(sizeBeforeDelete, sizeAfterDelete + 1);
        System.out.println("TEST 3 passed: delete client by id");
    }
}
