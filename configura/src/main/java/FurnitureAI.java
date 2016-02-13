package main.java;

import main.java.AttachmentFactory.Attachment;
import main.java.AttachmentFactory.AttachmentFactory;
import main.java.AttachmentFactory.Door;
import main.java.FurnitureFactory.Bed;
import main.java.FurnitureFactory.Furniture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukas on 2016-02-13.
 */
public class FurnitureAI {
    private List<Attachment> attachmentList = null;
    private List<Furniture> furnitureList = null;
    private Board board;

    public FurnitureAI() {

    }

    public Board decorateRoom(Board board) {
        Board newBoard = board;
        attachmentList = collectAttachmentsFromWarehouse();
        furnitureList = collectFurnitureFromWarehouse();
        newBoard = placeAttachments(newBoard);

        //placeFurnitures();

        return newBoard;
    }

    private void placeFurnitures() {
        // Check if there is a bed
        boolean containsBed = false;
        for(int i = 0; i < furnitureList.size(); i++) {
            if(furnitureList.get(i).getClass().equals(Bed.class)) {
                containsBed = true;
            }
        }
        if(containsBed) {
            doBedModule();
        }
    }

    private void doBedModule() {

    }


    private Board placeAttachments(Board board) {
        Board newBoard = board;
        for(int i = 0; i < attachmentList.size(); i++) {
            int xSquares;
            int ySquares;
            Attachment obj = attachmentList.get(i);
            Direction dir = obj.getDirection();

            if(dir.equals(Direction.SOUTH) || dir.equals(Direction.NORTH)) {
                xSquares = obj.getWidth() / 10;
                ySquares = obj.getHeight() / 10;
            } else {
                xSquares = obj.getHeight() / 10;
                ySquares = obj.getHeight() / 10;
            }

            int xStart = obj.getXStart() / 10;
            int yStart = obj.getYStart() / 10;
            if(xStart == 50) xStart += 1;
            if(yStart == 50) yStart += 1;

            // TEST
            newBoard.setAttachments(yStart, xStart, obj);
            if(obj.getClass().equals(Door.class)) {
                newBoard.setSquares(yStart, xStart, SquareType.DOORMAIN);
            } else {
                newBoard.setSquares(yStart, xStart, SquareType.WINDOWMAIN);
            }
//
//            if(dir.equals(Direction.NORTH)) {
//                Boolean mainPlaced = false;
//                for (int x = xStart; x > (xStart - xSquares); x--) {
//                    for(int y = yStart; y > (yStart - ySquares); y--) {
//                        board.setAttachments(y, x, obj);
//                        if (!mainPlaced) {
//                            mainPlaced = true;
//                            if(obj.getClass().equals(Door.class)) {
//                                newBoard.setSquares(y, x, SquareType.DOORMAIN);
//                            } else {
//                                newBoard.setSquares(y, x, SquareType.WINDOWMAIN);
//                            }
//                        } else {
//                            if(obj.getClass().equals(Door.class)) {
//                                newBoard.setSquares(y, x, SquareType.DOOR);
//                            } else {
//                                newBoard.setSquares(y, x, SquareType.WINDOW);
//                            }
//                        }
//                    }
//                }
//            } else if (dir.equals(Direction.SOUTH)) {
//                Boolean mainPlaced = false;
//                for (int x = xStart; x < (xStart + xSquares); x++) {
//                    for(int y = yStart; y < (yStart + ySquares); y++) {
//                        board.setAttachments(y, x, obj);
//                        if (!mainPlaced) {
//                            mainPlaced = true;
//                            if(obj.getClass().equals(Door.class)) {
//                                newBoard.setSquares(y, x, SquareType.DOORMAIN);
//                            } else {
//                                newBoard.setSquares(y, x, SquareType.WINDOWMAIN);
//                            }
//                        } else {
//                            if(obj.getClass().equals(Door.class)) {
//                                newBoard.setSquares(y, x, SquareType.DOOR);
//                            } else {
//                                newBoard.setSquares(y, x, SquareType.WINDOW);
//                            }
//                        }
//                    }
//                }
//            } else if (dir.equals(Direction.WEST)) {
//                Boolean mainPlaced = false;
//                for (int x = xStart; x > (xStart - xSquares); x--) {
//                    for(int y = yStart; y < (yStart + ySquares); y++) {
//                        board.setAttachments(y, x, obj);
//                        if (!mainPlaced) {
//                            mainPlaced = true;
//                            if(obj.getClass().equals(Door.class)) {
//                                newBoard.setSquares(y, x, SquareType.DOORMAIN);
//                            } else {
//                                newBoard.setSquares(y, x, SquareType.WINDOWMAIN);
//                            }
//                        } else {
//                            if(obj.getClass().equals(Door.class)) {
//                                newBoard.setSquares(y, x, SquareType.DOOR);
//                            } else {
//                                newBoard.setSquares(y, x, SquareType.WINDOW);
//                            }
//                        }
//                    }
//                }
//            } else {
//                Boolean mainPlaced = false;
//                for (int x = xStart; x < (xStart + xSquares); x++) {
//                    for(int y = yStart; y > (yStart - ySquares); y--) {
//                        board.setAttachments(y, x, obj);
//                        if (!mainPlaced) {
//                            mainPlaced = true;
//                            if(obj.getClass().equals(Door.class)) {
//                                newBoard.setSquares(y, x, SquareType.DOORMAIN);
//                            } else {
//                                newBoard.setSquares(y, x, SquareType.WINDOWMAIN);
//                            }
//                        } else {
//                            if(obj.getClass().equals(Door.class)) {
//                                newBoard.setSquares(y, x, SquareType.DOOR);
//                            } else {
//                                newBoard.setSquares(y, x, SquareType.WINDOW);
//                            }
//                        }
//                    }
//                }
//            }
        }
        return newBoard;
    }

    private List<Furniture> collectFurnitureFromWarehouse() {
        List<Furniture> newFurnitureList = new ArrayList<>();
        return newFurnitureList;
    }

    private List<Attachment> collectAttachmentsFromWarehouse() {
        List<Attachment> newAttachmentList = new ArrayList<>();

        /*
        Code used for testing!!
         */
        AttachmentFactory attachmentFactory = new AttachmentFactory();

        Attachment door1 = attachmentFactory.createAttachment("dÖrR", 100, 500, 190, 500);
        Attachment window1 = attachmentFactory.createAttachment("FöNStEr", 100, 0, 200, 0);
        Attachment window2 = attachmentFactory.createAttachment("fÖnStEr", 300, 0, 400, 0);

        newAttachmentList.add(door1);
        newAttachmentList.add(window1);
        newAttachmentList.add(window2);


        return newAttachmentList;

    }

}
