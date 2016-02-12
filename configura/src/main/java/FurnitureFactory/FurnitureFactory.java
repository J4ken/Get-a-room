package main.java.FurnitureFactory;

/**
 * Created by lukas on 2016-02-12.
 */
public class FurnitureFactory {

    public Furniture createFurniture(String furnitureType) {
        if(furnitureType == "säng") {
            return new Bed();
        } else if (furnitureType == "soffa") {
            return new Sofa();
        }

        }
    }
}