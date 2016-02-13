package main.java;

import main.java.AttachmentFactory.Attachment;
import main.java.AttachmentFactory.AttachmentFactory;
import main.java.FurnitureFactory.Furniture;
import main.java.FurnitureFactory.FurnitureFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FurnitureInventory
{
    private List<Attachment> attachmentList = new ArrayList<>();
    private List<Furniture> furnitureList = new ArrayList<>();

    public FurnitureInventory() {
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void  CreateFurniture(String[] buildFurnitures) throws IOException, NotInBoardBoundsException {
        AttachmentFactory attachmentFactory = new AttachmentFactory();
        FurnitureFactory furnitureFactory = new FurnitureFactory();





        for(int i=0; i<buildFurnitures.length;i++) {
            if(i<3) {
                String[] temp = buildFurnitures[i].split("	");
                if(temp.length > 1) {
                    String[] tempNr = temp[1].split(",");
                    Attachment attachment = attachmentFactory.createAttachment(temp[0], Integer.parseInt(tempNr[0]), Integer.parseInt(tempNr[1]),
                                                       Integer.parseInt(tempNr[2]), Integer.parseInt(tempNr[3]));
                    attachmentList.add(attachment);
                }
                else{
                    for(String c: temp) {
                        System.out.println(c); //bara en nice kontroll. Ändra till throw sen kanske
                    }
                }
            }
            else {
                Furniture furniture = furnitureFactory.createFurniture(buildFurnitures[i]);
                furnitureList.add(furniture);
            }
        }

        for(int i = 0; i < attachmentList.size(); i++) {
        Attachment object = attachmentList.get(i);
        System.out.println(object.getClass() + " " + object.getXStart() + " " + object.getYStart() + " " + object.getXEnd() + " " + object.getYEnd() + " " + object.getDirection());
        }
        System.out.println("\n");
        for(int c = 0; c < furnitureList.size(); c++) {
        Furniture object = furnitureList.get(c);
        System.out.println(object.getClass() + " ");
        }

    }

}
