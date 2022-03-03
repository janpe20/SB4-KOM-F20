package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author corfixen
 */
public class Collision implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        final List<Entity> entities = new ArrayList<>(world.getEntities());

        Entity entity1;
        Entity entity2;
        LifePart entity1life;

        for (int i = 0; i < entities.size()-1; i++) {
            entity1 = entities.get(i);
            entity1life = entity1.getPart(LifePart.class);

            for (int j = i + 1; j < entities.size(); j++) {
                entity2 = entities.get(j);

                if (!isCollided(entity1, entity2)){
                    continue;
                }

                if (entity1life.getLife()<= 1) {
                    world.removeEntity(entity1);
                } else {
                    entity1life.setLife(entity1life.getLife() -1);
                }

                LifePart entity2Life = entity2.getPart(LifePart.class);

                if (entity2Life.getLife() <= 1) {
                    world.removeEntity(entity2);
                } else {
                    entity2Life.setLife(entity2Life.getLife()-1);
                }
            }
        }
    }

    private boolean isCollided(Entity entity1, Entity entity2){
        PositionPart entity1Position = entity1.getPart(PositionPart.class);
        PositionPart entity2Position = entity2.getPart(PositionPart.class);

        float dx = entity1Position.getX() - entity2Position.getX();
        float dy = entity1Position.getY() - entity2Position.getY();
        float distance = (float) Math.sqrt(dx*dx+dy*dy);

        return distance < entity1.getRadius() + entity2.getRadius();
    }
}
