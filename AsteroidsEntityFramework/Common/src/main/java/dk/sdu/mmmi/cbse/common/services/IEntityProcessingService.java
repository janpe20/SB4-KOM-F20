package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Operation: Process
 * Description: It is responsible for updating the entities in the game loop and rendering position
 * Parameters: Gamedata handles events, delta and the window while World handles entity
 * Preconditions: It's been X amount of time since last update
 * Postcondition: All Entities have been updated
 */

public interface IEntityProcessingService {

    void process(GameData gameData, World world);
}
