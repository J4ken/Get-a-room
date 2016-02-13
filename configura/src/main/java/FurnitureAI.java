package main.java;

import main.java.AttachmentFactory.Attachment;
import main.java.AttachmentFactory.AttachmentFactory;
import main.java.AttachmentFactory.Door;
import main.java.FurnitureFactory.Bed;
import main.java.FurnitureFactory.Furniture;
import main.java.FurnitureFactory.FurnitureFactory;
import main.java.FurnitureFactory.Mat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukas on 2016-02-13.
 */
public class FurnitureAI {
    private List<Attachment> attachmentList = null;
    private List<Furniture> furnitureList = null;

    public FurnitureAI() {

    }

    public Board decorateRoom(Board board) {
        Board newBoard = board;
        attachmentList = collectAttachmentsFromWarehouse();
        furnitureList = collectFurnitureFromWarehouse();
        newBoard = placeAttachments(newBoard);

        newBoard = placeFurnitures(newBoard);

        return newBoard;
    }

    private Board placeFurnitures(Board board) {
        Board newBoard = board;
        // Check if there is a bed
        boolean containsBed = false;
        for(int i = 0; i < furnitureList.size(); i++) {
            if(furnitureList.get(i).getClass().equals(Bed.class)) {
                containsBed = true;
            }
        }
        if(containsBed) {
            newBoard = doBedModule(board);
        }
        boolean containsMat = false;
        for(int i = 0; i < furnitureList.size(); i++) {
            if(furnitureList.get(i).getClass().equals(Mat.class)) {
                containsMat = true;
            }
        }
        if(containsMat) {
            newBoard = doMatModule(board);
        }


        return newBoard;
    }

    private Board doMatModule(Board board) {
        Board newBoard = board;

        int mats = 0;
        List<Furniture> matList = new ArrayList<>();
        for(int i = 0; i < furnitureList.size(); i++) {
            if(furnitureList.get(i).getClass().equals(Mat.class)) {
                mats++;
                matList.add(furnitureList.get(i));
            }
        }

        if(mats > 0) {
            Furniture mat = matList.get(0);
            int ySquares = mat.getHeight() / 10;
            int xSquares = mat.getWidth() / 10;
            int yStart = 15;
            int xStart = 15;
            // 250 - 100
            boolean mainPlaced = false;
            for(int y = yStart; y < (yStart + ySquares); y++) {
                for (int x = xStart; x < (xStart + xSquares); x++) {
                    mat.setDirection(Direction.SOUTH);
                    newBoard.setFurnitures(15, 15, mat);
                    if(!mainPlaced) {
                        mainPlaced = true;
                        newBoard.setSquares(y, x, SquareType.MATMAIN);
                    } else {
                        newBoard.setSquares(y, x, SquareType.MAT);
                    }
                }
            }
        }
        if(mats > 1) {
            Furniture mat2 = matList.get(1);
            int ySquares = mat2.getHeight() / 10;
            int xSquares = mat2.getWidth() / 10;
            int yStart = 30;
            int xStart = 15;
            boolean mainPlaced = false;
            for(int y = yStart; y < (yStart + ySquares); y++) {
                for (int x = xStart; x < (xStart + xSquares); x++) {
                    mat2.setDirection(Direction.SOUTH);
                    newBoard.setFurnitures(30, 15, mat2);
                    if(!mainPlaced) {
                        mainPlaced = true;
                        newBoard.setSquares(y, x, SquareType.MATMAIN);
                    } else {
                        newBoard.setSquares(y, x, SquareType.MAT);
                    }
                }
            }
        }

        return newBoard;
    }

    private Board doBedModule(Board board) {
        // Count beds
        Board newBoard = board;
        int beds = 0;
        List<Furniture> bedList = new ArrayList<>();
        for(int i = 0; i < furnitureList.size(); i++) {
            if(furnitureList.get(i).getClass().equals(Bed.class)) {
                beds++;
                bedList.add(furnitureList.get(i));
            }
        }

        // find corner furthest away from the door/windows;
        // Start top left
        int topLeft = topLeftPrio(board);
        int topRight = topRightPrio(board);
        int bottomLeft = bottomLeftPrio(board);
        int bottomRight = bottomRightPrio(board);
        int bestCorner = decideCorner(topLeft, topRight, bottomLeft, bottomRight);
        int secondBest = decideSecondBest(topLeft,topRight, bottomLeft, bottomRight);


        // 1 beds
        // bestCorner :: 0 = topleft, 1 = topright, 2 = bottomleft, 3 = bottomright
        Furniture bed = bedList.get(0);
        if(bestCorner == 0) {
            //TopLeft
            int ySquares = bed.getHeight() / 10;
            int xSquares = bed.getWidth() / 10;
            int yStart = 1;
            int xStart = 1;
            Boolean mainPlaced = false;
            for(int y = yStart; y < (yStart + ySquares); y++) {
                for (int x = xStart; x < (xStart + xSquares); x++) {
                    // Set bed direction to south
                    bed.setDirection(Direction.SOUTH);
                    board.setFurnitures(y, x, bed);
                    if (!mainPlaced) {
                        mainPlaced = true;
                        newBoard.setSquares(y, x, SquareType.BEDMAIN);
                    } else {
                        newBoard.setSquares(y, x, SquareType.BED);                        }
                }
            }
        } else if (bestCorner == 1) {
            //TopRight
            int ySquares = bed.getWidth() / 10;
            int xSquares = bed.getHeight() / 10;
            int yStart = 1;
            int xStart = Board.ROOM_WIDTH - 1 - xSquares;
            Boolean mainPlaced = false;
            for(int y = yStart; y < (yStart + ySquares); y++) {
                for (int x = xStart; x < (xStart + xSquares); x++) {
                    // Set bed direction to west
                    bed.setDirection(Direction.WEST);
                    board.setFurnitures(y, x, bed);
                    if (!mainPlaced) {
                        mainPlaced = true;
                        newBoard.setSquares(y, x, SquareType.BEDMAIN);
                    } else {
                        newBoard.setSquares(y, x, SquareType.BED);                        }
                }
            }
        } else if (bestCorner == 2) {
            //BottomLeft
            int ySquares = bed.getWidth() / 10;
            int xSquares = bed.getHeight() / 10;
            int yStart = Board.ROOM_HEIGHT - 1 - ySquares;
            int xStart = 1;
            Boolean mainPlaced = false;
            for(int y = yStart; y < (yStart + ySquares); y++) {
                for (int x = xStart; x < (xStart + xSquares); x++) {
                    // Set bed direction to eaST
                    bed.setDirection(Direction.EAST);
                    board.setFurnitures(y, x, bed);
                    if (!mainPlaced) {
                        mainPlaced = true;
                        newBoard.setSquares(y, x, SquareType.BEDMAIN);
                    } else {
                        newBoard.setSquares(y, x, SquareType.BED);                        }
                }
            }
        } else {
            //BottomRight
            int ySquares = bed.getHeight() / 10;
            int xSquares = bed.getWidth() / 10;
            int yStart = Board.ROOM_HEIGHT - 1 - ySquares;
            int xStart = Board.ROOM_WIDTH - 1 - xSquares;
            Boolean mainPlaced = false;
            for(int y = yStart; y < (yStart + ySquares); y++) {
                for (int x = xStart; x < (xStart + xSquares); x++) {
                    // Set bed direction to eaST
                    bed.setDirection(Direction.NORTH);
                    board.setFurnitures(y, x, bed);
                    if (!mainPlaced) {
                        mainPlaced = true;
                        newBoard.setSquares(y, x, SquareType.BEDMAIN);
                    } else {
                        newBoard.setSquares(y, x, SquareType.BED);                        }
                }
            }

        }
        if(beds > 1) {
            // 2 beds
            Furniture bedTwo = bedList.get(1);
            if(secondBest == 0) {
                //TopLeft
                int ySquares = bed.getHeight() / 10;
                int xSquares = bed.getWidth() / 10;
                int yStart = 1;
                int xStart = 1;
                Boolean mainPlaced = false;
                for(int y = yStart; y < (yStart + ySquares); y++) {
                    for (int x = xStart; x < (xStart + xSquares); x++) {
                        // Set bed direction to south
                        bed.setDirection(Direction.SOUTH);
                        board.setFurnitures(y, x, bed);
                        if (!mainPlaced) {
                            mainPlaced = true;
                            newBoard.setSquares(y, x, SquareType.BEDMAIN);
                        } else {
                            newBoard.setSquares(y, x, SquareType.BED);                        }
                    }
                }
            } else if (secondBest == 1) {
                //TopRight
                int ySquares = bed.getWidth() / 10;
                int xSquares = bed.getHeight() / 10;
                int yStart = 1;
                int xStart = Board.ROOM_WIDTH - 1 - xSquares;
                Boolean mainPlaced = false;
                for(int y = yStart; y < (yStart + ySquares); y++) {
                    for (int x = xStart; x < (xStart + xSquares); x++) {
                        // Set bed direction to west
                        bed.setDirection(Direction.WEST);
                        board.setFurnitures(y, x, bed);
                        if (!mainPlaced) {
                            mainPlaced = true;
                            newBoard.setSquares(y, x, SquareType.BEDMAIN);
                        } else {
                            newBoard.setSquares(y, x, SquareType.BED);                        }
                    }
                }
            } else if (secondBest == 2) {
                //BottomLeft
                int ySquares = bed.getWidth() / 10;
                int xSquares = bed.getHeight() / 10;
                int yStart = Board.ROOM_HEIGHT - 1 - ySquares;
                int xStart = 1;
                Boolean mainPlaced = false;
                for(int y = yStart; y < (yStart + ySquares); y++) {
                    for (int x = xStart; x < (xStart + xSquares); x++) {
                        // Set bed direction to eaST
                        bed.setDirection(Direction.EAST);
                        board.setFurnitures(y, x, bed);
                        if (!mainPlaced) {
                            mainPlaced = true;
                            newBoard.setSquares(y, x, SquareType.BEDMAIN);
                        } else {
                            newBoard.setSquares(y, x, SquareType.BED);                        }
                    }
                }
            } else {
                //BottomRight
                int ySquares = bed.getHeight() / 10;
                int xSquares = bed.getWidth() / 10;
                int yStart = Board.ROOM_HEIGHT - 1 - ySquares;
                int xStart = Board.ROOM_WIDTH - 1 - xSquares;
                Boolean mainPlaced = false;
                for (int y = yStart; y < (yStart + ySquares); y++) {
                    for (int x = xStart; x < (xStart + xSquares); x++) {
                        // Set bed direction to eaST
                        bed.setDirection(Direction.NORTH);
                        board.setFurnitures(y, x, bed);
                        if (!mainPlaced) {
                            mainPlaced = true;
                            newBoard.setSquares(y, x, SquareType.BEDMAIN);
                        } else {
                            newBoard.setSquares(y, x, SquareType.BED);
                        }
                    }
                }
            }
        }
        return newBoard;
    }

    private int decideCorner(int topLeft, int topRight, int bottomLeft, int bottomRight) {
        int bestValue = 0;
        int bestCorner = 0;
        if(topLeft > bestValue) {
            bestCorner = 0;
            bestValue = topLeft;
        }
        if(topRight > bestValue) {
            bestCorner = 1;
            bestValue = topRight;
        }
        if(bottomLeft > bestValue) {
            bestCorner = 2;
            bestValue = bottomLeft;
        }
        if(bottomRight > bestValue) {
            bestCorner = 3;
        }
        return bestCorner;
    }

    private int decideSecondBest(int topLeft, int topRight, int bottomLeft, int bottomRight) {
        int bestValue = 0;
        int bestCorner = 0;
        int secondBestCorner = 3;
        if(topLeft > bestValue) {
            bestCorner = 0;
            bestValue = topLeft;
        }
        if(topRight > bestValue) {
            secondBestCorner = bestCorner;
            bestCorner = 1;
            bestValue = topRight;
        }
        if(bottomLeft > bestValue) {
            secondBestCorner = bestCorner;
            bestCorner = 2;
            bestValue = bottomLeft;
        }
        if(bottomRight > bestValue) {
            secondBestCorner = bestCorner;
        }
        return secondBestCorner;
    }

    private int topLeftPrio(Board board) {
        int prio = 0;
        for(int x = 0; x < Board.ROOM_WIDTH; x++) {
            if(board.getSquareType(0, x).equals(SquareType.WINDOWMAIN) || board.getSquareType(0, x).equals(SquareType.WINDOW) ||
                    board.getSquareType(0, x).equals(SquareType.DOORMAIN) || board.getSquareType(0, x).equals(SquareType.DOOR)) {
                break;
            } else {
                prio += 1;
            }
        }
        for(int y = 0; y < Board.ROOM_HEIGHT; y++) {
            if(board.getSquareType(y, 0).equals(SquareType.WINDOWMAIN) || board.getSquareType(y, 0).equals(SquareType.WINDOW) ||
                    board.getSquareType(y, 0).equals(SquareType.DOORMAIN) || board.getSquareType(y, 0).equals(SquareType.DOOR)) {
                break;
            } else {
                prio += 1;
            }
        }
        return prio;
    }

    private int topRightPrio(Board board) {
        int prio = 0;
        for(int x = Board.ROOM_WIDTH - 1; x >= 0; x--) {
            if(board.getSquareType(0, x).equals(SquareType.WINDOWMAIN) || board.getSquareType(0, x).equals(SquareType.WINDOW) ||
                    board.getSquareType(0, x).equals(SquareType.DOORMAIN) || board.getSquareType(0, x).equals(SquareType.DOOR)) {
                break;
            } else {
                prio += 1;
            }
        }
        for(int y = 0; y < Board.ROOM_HEIGHT; y++) {
            if(board.getSquareType(y, Board.ROOM_WIDTH - 1).equals(SquareType.WINDOWMAIN) || board.getSquareType(y, Board.ROOM_WIDTH - 1).equals(SquareType.WINDOW) ||
                    board.getSquareType(y, Board.ROOM_WIDTH - 1).equals(SquareType.DOORMAIN) || board.getSquareType(y, Board.ROOM_WIDTH - 1).equals(SquareType.DOOR)) {
                break;
            } else {
                prio += 1;
            }
        }
        return prio;
    }

    private int bottomLeftPrio(Board board) {
        int prio = 0;
        for(int x = 0; x < Board.ROOM_WIDTH; x++) {
            if(board.getSquareType(Board.ROOM_HEIGHT - 1, x).equals(SquareType.WINDOWMAIN) || board.getSquareType(Board.ROOM_HEIGHT - 1, x).equals(SquareType.WINDOW) ||
                    board.getSquareType(Board.ROOM_HEIGHT - 1, x).equals(SquareType.DOORMAIN) || board.getSquareType(Board.ROOM_HEIGHT - 1, x).equals(SquareType.DOOR)) {
                break;
            } else {
                prio += 1;
            }
        }
        for(int y = Board.ROOM_HEIGHT - 1; y >= 0; y--) {
            if(board.getSquareType(y, 0).equals(SquareType.WINDOWMAIN) || board.getSquareType(y, 0).equals(SquareType.WINDOW) ||
                    board.getSquareType(y, 0).equals(SquareType.DOORMAIN) || board.getSquareType(y, 0).equals(SquareType.DOOR)) {
                break;
            } else {
                prio += 1;
            }
        }
        return prio;
    }

    private int bottomRightPrio(Board board) {
        int prio = 0;
        for(int x = Board.ROOM_WIDTH - 1; x >= 0; x--) {
            if(board.getSquareType(Board.ROOM_HEIGHT - 1, x).equals(SquareType.WINDOWMAIN) || board.getSquareType(Board.ROOM_HEIGHT - 1, x).equals(SquareType.WINDOW) ||
                    board.getSquareType(Board.ROOM_HEIGHT - 1, x).equals(SquareType.DOORMAIN) || board.getSquareType(Board.ROOM_HEIGHT - 1, x).equals(SquareType.DOOR)) {
                break;
            } else {
                prio += 1;
            }
        }
        for(int y = Board.ROOM_HEIGHT - 1; y >= 0; y--) {
            if(board.getSquareType(y, Board.ROOM_WIDTH - 1).equals(SquareType.WINDOWMAIN) || board.getSquareType(y, Board.ROOM_WIDTH - 1).equals(SquareType.WINDOW) ||
                    board.getSquareType(y, Board.ROOM_WIDTH - 1).equals(SquareType.DOORMAIN) || board.getSquareType(y, Board.ROOM_WIDTH - 1).equals(SquareType.DOOR)) {
                break;
            } else {
                prio += 1;
            }
        }
        return prio;
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
//            newBoard.setAttachments(yStart, xStart, obj);
//            if(obj.getClass().equals(Door.class)) {
//                newBoard.setSquares(yStart, xStart, SquareType.DOORMAIN);
//            } else {
//                newBoard.setSquares(yStart, xStart, SquareType.WINDOWMAIN);
//            }
//
            Boolean mainPlaced = false;
            for(int y = yStart; y < (yStart + ySquares); y++) {
                for (int x = xStart; x < (xStart + xSquares); x++) {
                    board.setAttachments(y, x, obj);
                    if (!mainPlaced) {
                        mainPlaced = true;
                        if(obj.getClass().equals(Door.class)) {
                            newBoard.setSquares(y, x, SquareType.DOORMAIN);
                        } else {
                            newBoard.setSquares(y, x, SquareType.WINDOWMAIN);
                        }
                    } else {
                        if(obj.getClass().equals(Door.class)) {
                            newBoard.setSquares(y, x, SquareType.DOOR);
                        } else {
                            newBoard.setSquares(y, x, SquareType.WINDOW);
                        }
                    }
                }
            }
        }
        return newBoard;
    }

    private List<Furniture> collectFurnitureFromWarehouse() {
        List<Furniture> newFurnitureList = new ArrayList<>();

        /*
        Code used for testing!!
         */
        FurnitureFactory furnitureFactory = new FurnitureFactory();

        Furniture kuk1 = furnitureFactory.createFurniture("säNg");

        newFurnitureList.add(kuk1);

        return newFurnitureList;
    }

    private List<Attachment> collectAttachmentsFromWarehouse() {
        List<Attachment> newAttachmentList = new ArrayList<>();

        /*
        Code used for testing!!
         */
        AttachmentFactory attachmentFactory = new AttachmentFactory();

        Attachment door1 = attachmentFactory.createAttachment("dÖrR", 300, 500, 390, 500);
        Attachment window1 = attachmentFactory.createAttachment("FöNStEr", 0, 350, 0, 450);
        Attachment window2 = attachmentFactory.createAttachment("fÖnStEr", 300, 0, 400, 0);

        newAttachmentList.add(door1);
        newAttachmentList.add(window1);
        newAttachmentList.add(window2);


        return newAttachmentList;

    }

}
