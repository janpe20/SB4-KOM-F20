package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Operation: Start & Stop
 * Description: Start method starts the game loop while stop method closes the game loop
 * Parameters: Gamedata handles events, delta and the window while World handles entity
 * Preconditions: There is data to load when starting the game loop
 * Postcondition: The game loop is not running
 */

public interface IGamePluginService {
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
