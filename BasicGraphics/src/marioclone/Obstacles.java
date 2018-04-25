package marioclone;

import basicgraphics.*;
import basicgraphics.images.Picture;

import java.awt.*;
import java.io.IOException;

public class Obstacles extends Sprite {
    private Picture basePic;
    int count;
    Obstacles() throws IOException {
        basePic = new Picture("Mario_brick.png");
        setPicture(basePic);
    }

    @Override
    public void preMove() {
        count++;
        if(count == 100)
            setPicture(basePic);
    }

    @Override
    public void processEvent(SpriteCollisionEvent ev) {
        if(ev.eventType == CollisionEventType.WALL_INVISIBLE) {
            setX(800);
            basePic = basePic.resize(1.1);
        }
    }


}
