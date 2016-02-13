package main.java;

import main.java.AttachmentFactory.*;
import main.java.FurnitureFactory.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukas on 2016-02-12.
 */
public class test {

    /**
     * TEST TEST TEST TEST
     * @param args
     */
    public static void main(String args[]) {
        FurnitureFactory furnitureFactory = new FurnitureFactory();
        List<Furniture> furnitureList = new ArrayList<>();

        AttachmentFactory attachmentFactory = new AttachmentFactory();
        List<Attachment> attachmentList = new ArrayList<>();

        Attachment door1 = attachmentFactory.createAttachment("dÖrR", 100, 500, 190, 500);
        Attachment window1 = attachmentFactory.createAttachment("FöNStEr", 100, 0, 200, 0);
        Attachment window2 = attachmentFactory.createAttachment("fÖnStEr", 300, 0, 400, 0);

        attachmentList.add(door1);
        attachmentList.add(window1);
        attachmentList.add(window2);

        Furniture kuk1 = furnitureFactory.createFurniture("soFfA");
        Furniture kuk2 = furnitureFactory.createFurniture("SkRiVbOrd");
        Furniture kuk3 = furnitureFactory.createFurniture("mAtTa");
        Furniture kuk4 = furnitureFactory.createFurniture("mAtTa");

        furnitureList.add(kuk1);
        furnitureList.add(kuk2);
        furnitureList.add(kuk3);
        furnitureList.add(kuk4);

        for(int i = 0; i < attachmentList.size(); i++) {
            Attachment object = attachmentList.get(i);
            System.out.println(object.getClass() + " " + object.getXStart() + " " + object.getYStart() + " " + object.getXEnd() + " " + object.getYEnd() + " " + object.getDirection());
        }
        System.out.println("\n");
        for(int c = 0; c < furnitureList.size(); c++) {
            Furniture object = furnitureList.get(c);
            System.out.println(object.getClass() + " ");
        }

        System.out.println(attachmentList.get(0).getClass().equals(Door.class));


    }

}
