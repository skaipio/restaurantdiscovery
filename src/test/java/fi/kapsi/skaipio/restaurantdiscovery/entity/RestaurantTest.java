/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.kapsi.skaipio.restaurantdiscovery.entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class RestaurantTest {
    
    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("RestaurantDiscoveryTestPU");
    private EntityManager em;
    
    public RestaurantTest() {
    }

    @Before
    public void initEntityManager() throws Exception{
        em = emf.createEntityManager();
    }
    
    @After
    public void closeEntityManager() throws Exception{
        if (em != null) em.close();
    }
    
    @Test
    public void findsRestaurantById() {
        Restaurant restaurant = em.createNamedQuery("Restaurant.findById", Restaurant.class).setParameter("id", 1).getSingleResult();
        assertNotNull(restaurant);
        assertEquals("Lappi Restaurant", restaurant.getName());
    }
    
    @Test
    public void findsAllRestaurants() {
        List<Restaurant> restaurants = em.createNamedQuery("Restaurant.findAll", Restaurant.class).getResultList();
        assertEquals(2, restaurants.size());
        assertEquals("Lappi Restaurant", restaurants.get(0).getName());
        assertEquals("Classic American Diner", restaurants.get(1).getName());
    }
    
    @Test
    public void restaurantHasAddress() {
        Restaurant restaurant = em.createNamedQuery("Restaurant.findById", Restaurant.class).setParameter("id", 1).getSingleResult();
        assertNotNull(restaurant.getAddress());
        assertEquals("Annankatu 22", restaurant.getAddress().getStreet());
    }
}
