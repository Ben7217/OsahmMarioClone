package marioclone;

import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MoveMario {


    public static void main(String[] args) throws IOException {
        Mario mario = new Mario();
        mario.setVelX(1.0);
        mario.setX(50);
        mario.setY(350);

        Obstacles obstacles = new Obstacles();
        obstacles.setVelX(-1.0);
        obstacles.setX(50);
        obstacles.setY(350);


        BasicFrame bf = new BasicFrame("Mario Clone");

        //Adding Mario sprite to frame
        SpriteComponent marioSprite = new SpriteComponent();
        bf.add("mario", marioSprite, 0, 0, 1, 1);
        marioSprite.setPreferredSize(new Dimension(800, 400));
        marioSprite.addSprite(mario);

        //Adding obstacle sprite to frame
        SpriteComponent block = new SpriteComponent();
        bf.add("block", block, 1,0,0,0);
        block.setPreferredSize(new Dimension(50, 50));
        block.addSprite(obstacles);


        bf.show();
        marioSprite.start(0, 10);
        block.start(0, 10);


        bf.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    mario.setY(330);
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    mario.setY(350);
                }
            }

//            @Override
//            public void keyReleased(KeyEvent e) {
//                if(e.getKeyCode() != KeyEvent.VK_UP) {
//                    mario.setY(350);
//                }
//            }
        });

    }
}

