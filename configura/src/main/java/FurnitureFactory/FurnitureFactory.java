package main.java.FurnitureFactory;

/**
 * Created by lukas on 2016-02-12.
 */
public class FurnitureFactory {


    public Furniture createFurniture(String furnitureType) {
        if(furnitureType == null) {
            return null;
        } else if (furnitureType.equalsIgnoreCase("SÄNG")) {
            return new Bed();
        } else if (furnitureType.equalsIgnoreCase("SOFFA")){
            return new Sofa();
        } else if (furnitureType.equalsIgnoreCase("SKRIVBORD")) {
            return new Desk();
        } else if (furnitureType.equalsIgnoreCase("SKRIVBORDSSTOL")) {
            return new DeskChair();
        } else if (furnitureType.equalsIgnoreCase("VÄGG-TV")) {
            return new WallTV();
        } else if (furnitureType.equalsIgnoreCase("SOFFBORD")) {
            return new SofaTable();
        } else if(furnitureType.equalsIgnoreCase("MATTA")) {
            return new Mat();
        } else if(furnitureType.equalsIgnoreCase("BOKHYLLA")) {
            return new Bookshelf();
        }
        return null;
    }
}