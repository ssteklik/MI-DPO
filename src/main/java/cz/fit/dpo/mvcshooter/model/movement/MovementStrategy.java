package cz.fit.dpo.mvcshooter.model.movement;

import cz.fit.dpo.mvcshooter.model.entities.Coordinates;
import cz.fit.dpo.mvcshooter.model.entities.Missile;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public interface MovementStrategy {

  public Coordinates move(int gravity, Missile missile);
}
