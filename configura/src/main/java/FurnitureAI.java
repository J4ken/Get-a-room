package main.java;

import main.java.AttachmentFactory.Attachment;
import main.java.AttachmentFactory.AttachmentFactory;
import main.java.AttachmentFactory.Door;
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

    public void decorateRoom(Board board) {
        attachmentList = collectAttachmentsFromWarehouse();
        furnitureList = collectFurnitureFromWarehouse();
        this.board = board;
    }


    private void placeAttachments() {
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


            if(dir.equals(Direction.NORTH)) {
                Boolean mainPlaced = false;
                for (int x = xStart; x > (xStart - xSquares); x--) {
                    for(int y = yStart; y > (yStart - ySquares); y--) {
                        board.setAttachments(x, y, obj);
                        if (!mainPlaced) {
                            mainPlaced = true;
                            if(obj.getClass().equals(Door.class)) {
                                board.setSquares(x, y, SquareType.DOORMAIN);
                            } else {
                                board.setSquares(x, y, SquareType.WINDOWMAIN);
                            }
                        } else {
                            if(obj.getClass().equals(Door.class)) {
                                board.setSquares(x, y, SquareType.DOOR);
                            } else {
                                board.setSquares(x, y, SquareType.WINDOW);
                            }
                        }
                    }
                }
            } else if (dir.equals(Direction.SOUTH)) {
                Boolean mainPlaced = false;
                for (int x = xStart; x < (xStart + xSquares); x++) {
                    for(int y = yStart; y < (yStart + ySquares); y++) {
                        board.setAttachments(x, y, obj);
                        if (!mainPlaced) {
                            mainPlaced = true;
                            if(obj.getClass().equals(Door.class)) {
                                board.setSquares(x, y, SquareType.DOORMAIN);
                            } else {
                                board.setSquares(x, y, SquareType.WINDOWMAIN);
                            }
                        } else {
                            if(obj.getClass().equals(Door.class)) {
                                board.setSquares(x, y, SquareType.DOOR);
                            } else {
                                board.setSquares(x, y, SquareType.WINDOW);
                            }
                        }
                    }
                }
            } else if (dir.equals(Direction.WEST)) {
                Boolean mainPlaced = false;
                for (int x = xStart; x > (xStart - xSquares); x--) {
                    for(int y = yStart; y < (yStart + ySquares); y++) {
                        board.setAttachments(x, y, obj);
                        if (!mainPlaced) {
                            mainPlaced = true;
                            if(obj.getClass().equals(Door.class)) {
                                board.setSquares(x, y, SquareType.DOORMAIN);
                            } else {
                                board.setSquares(x, y, SquareType.WINDOWMAIN);
                            }
                        } else {
                            if(obj.getClass().equals(Door.class)) {
                                board.setSquares(x, y, SquareType.DOOR);
                            } else {
                                board.setSquares(x, y, SquareType.WINDOW);
                            }
                        }
                    }
                }
            } else {
                Boolean mainPlaced = false;
                for (int x = xStart; x < (xStart + xSquares); x++) {
                    for(int y = yStart; y > (yStart - ySquares); y--) {
                        board.setAttachments(x, y, obj);
                        if (!mainPlaced) {
                            mainPlaced = true;
                            if(obj.getClass().equals(Door.class)) {
                                board.setSquares(x, y, SquareType.DOORMAIN);
                            } else {
                                board.setSquares(x, y, SquareType.WINDOWMAIN);
                            }
                        } else {
                            if(obj.getClass().equals(Door.class)) {
                                board.setSquares(x, y, SquareType.DOOR);
                            } else {
                                board.setSquares(x, y, SquareType.WINDOW);
                            }
                        }
                    }
                }
            }
        }
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
