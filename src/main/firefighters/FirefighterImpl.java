package main.firefighters;

import main.api.CityNode;
import main.api.Firefighter;

public class FirefighterImpl implements Firefighter {

  //Starting location (FireStation)
  private CityNode startingLocation;
  //The current location of the FireFighter
  private CityNode currentLocation;

  @Override
  public int distanceTraveled() {
    //See Taxicab Geometry referenced in the interface
    return Math.abs(currentLocation.getX() - startingLocation.getX()) +
            Math.abs(currentLocation.getY() - startingLocation.getY());
  }

  @Override
  public CityNode getCurrentLocation() {
    return currentLocation;
  }

  @Override
  public void setCurrentLocation(CityNode newLocation) {
    if(startingLocation == null) {
      startingLocation = newLocation;
    }
    currentLocation = newLocation;
  }

}
