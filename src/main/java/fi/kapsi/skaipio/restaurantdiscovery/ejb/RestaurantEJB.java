/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.kapsi.skaipio.restaurantdiscovery.ejb;

import fi.kapsi.skaipio.restaurantdiscovery.entity.Restaurant;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class RestaurantEJB {
    @PersistenceContext(unitName = "RestaurantDiscoveryPU")
    private EntityManager em;

    public List<Restaurant> findAllRestaurants() {
        return em.createNamedQuery("Restaurant.findAll").getResultList();
    }
    
    
}
