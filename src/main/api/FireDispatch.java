package main.api;

import java.util.List;

public interface FireDispatch {

  /**
   * Hires a number of firefighters
   * @param numFirefighters the number of {@link Firefighter}s available to dispatch
   */
  void setFirefighters(int numFirefighters);

  /**
   * Get the list of firefighters
   * @return a {@link List} of {@link Firefighter}s
   */
  List<Firefighter> getFirefighters();

  /**
   * The FireDispatch will be notified of burning buildings via this method. It will then dispatch the
   * firefighters and extinguish the fires. We want to optimize for total distance traveled by all firefighters
   * @param burningBuildings list of locations with burning buildings
   */
  void dispatchFirefighters(CityNode... burningBuildings);
}
