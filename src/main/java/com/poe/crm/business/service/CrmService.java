package com.poe.crm.business.service;

import com.poe.crm.business.Client;
import com.poe.crm.business.Order;
import com.poe.crm.dao.ClientRepository;
import com.poe.crm.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrmService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OrderRepository orderRepository;


    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void addClient(Client client){
        clientRepository.save(client);
    }

    public Optional<Client> findClient(Long id){
        return clientRepository.findById(id);
    }

    public boolean deleteClient(Long id){
        if(clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateClient(Client client){
        if(clientRepository.existsById(client.getId())) {
            clientRepository.save(client);
            return true;
        } else {
            return false;
        }
    }

    /************************************************/

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public boolean deleteOrder(Long id) {
        if(orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateOrder(Order order) {
        if(orderRepository.existsById(order.getId())) {
            orderRepository.save(order);
            return true;
        } else {
            return false;
        }
    }

    public List<Client> searchByCompanyName(String companyName){
        return clientRepository.findAllByCompanyName(companyName);
    }


    public List<Client> searchByFirstNameAndLastName(String firstName, String lastName){
        return clientRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }


    public float calculateExpense(Long clientId){
        float total = 0;
        Optional<Client> op = clientRepository.findById(clientId);
        if(op.isPresent()){
            Client client = op.get();
            for(Order order : client.getOrders()){
                total = total + order.getNbDays()*order.getUnitPrice();
            }
        }
        return total;
    }
}