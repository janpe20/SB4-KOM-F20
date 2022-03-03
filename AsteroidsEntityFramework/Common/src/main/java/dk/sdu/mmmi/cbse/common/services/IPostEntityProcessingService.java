package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Operation: Process
 * Description: Updating for collision and subsequent status and points after new position update
 * Parameters: amedata handles events, delta and the window while World handles entity
 * Preconditions: A new update of entities have just occured
 * Postcondition: Updated entities
 */
public interface IPostEntityProcessingService  {
        void process(GameData gameData, World world);
}
