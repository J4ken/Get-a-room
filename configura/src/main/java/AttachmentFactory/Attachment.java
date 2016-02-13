package main.java.AttachmentFactory;

import main.java.Direction;

/**
 * Created by lukas on 2016-02-12.
 */
public interface Attachment {

    int getXStart();
    int getYStart();
    int getXEnd();
    int getYEnd();

    int getWidth();
    int getHeight();

    Direction getDirection();
}
