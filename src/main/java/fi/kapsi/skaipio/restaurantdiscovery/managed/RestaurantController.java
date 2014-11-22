/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.kapsi.skaipio.restaurantdiscovery.managed;

import fi.kapsi.skaipio.restaurantdiscovery.ejb.RestaurantEJB;
import fi.kapsi.skaipio.restaurantdiscovery.entity.Restaurant;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/*
JSF backing bean for restaurant actions.
*/
@Named(value = "restaurantController")
@RequestScoped
public class RestaurantController {
    
    @Inject
    private RestaurantEJB restaurantEJB;

    /**
     * Creates a new instance of RestaurantController
     */
    public RestaurantController() {
    }
    
    public List<Restaurant> getRestaurants(){
        return restaurantEJB.findAllRestaurants();
    }
    
    public String getRestaurantCleanLink(Restaurant restaurant){
        String link = restaurant.getHomepage();
        link = link.replaceFirst("http://", "");
        if (link.endsWith("/"))
            link = link.substring(0, link.length()-1);
        return link;
    }
}
