package main.api;

public interface Firefighter {

  /**
   * Get the total distance traveled by this firefighter. Distances should be represented using TaxiCab
   * Geometry: https://en.wikipedia.org/wiki/Taxicab_geometry
   *
   * @return the total distance traveled by this firefighter
   */
  int distanceTraveled();

  /**
   * Get the firefighter's current location. Initially, the firefighter should be at the FireStation
   *
   * @return {@link CityNode} representing the firefighter's current location
   */
  CityNode getCurrentLocation();

  /**
   * Sets the location of the Firefighter in the {@link City}
   *
   * @param location {@link CityNode} representing the location that the Firefighter is being sent
   */
  void setCurrentLocation(CityNode location);
}
