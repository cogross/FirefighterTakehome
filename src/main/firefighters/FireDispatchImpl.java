package main.firefighters;

import java.util.*;

import main.api.*;
import main.api.exceptions.NoFireFoundException;

public class FireDispatchImpl implements FireDispatch {

  //List of FireFighters available
  private List<Firefighter> fireFighters;

  //Reference to the city
  private City city;

  public FireDispatchImpl(City city) {
    this.city = city;
  }

  @Override
  public void setFirefighters(int numFirefighters) {
    fireFighters = new ArrayList<>();
    for(int i=0; i < numFirefighters; i++) {
      //Create a new Firefighter, set their location to be the FireStation
      Firefighter fighter = new FirefighterImpl();
      fighter.setCurrentLocation(city.getFireStation().getLocation());
      fireFighters.add(fighter);
    }
  }

  @Override
  public List<Firefighter> getFirefighters() {
    return fireFighters;
  }

  @Override
  public void dispatchFirefighters(CityNode... burningBuildings) {
    //Go through all of the buildings that are on fire
    for(CityNode burningBuilding : burningBuildings) {
      try {
        //Get the reference to the building
        Building realBuilding = city.getBuilding(burningBuilding);
        //Find which firefighter is going and send them there
        Firefighter firefighter = getFirefighter();
        firefighter.setCurrentLocation(realBuilding.getLocation());
        //Extinguish fire
        realBuilding.extinguishFire();
      } catch(NoFireFoundException nfe) {
        System.out.println("Not on fire");
      }
    }
  }

  private Firefighter getFirefighter() {
    //Sort by distance travelled (so far), send the one with the least distance
    fireFighters.sort(Comparator.comparing(Firefighter::distanceTraveled));
    return fireFighters.get(0);
  }
}
