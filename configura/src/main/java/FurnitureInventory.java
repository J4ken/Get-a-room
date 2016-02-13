package main.java;

import main.java.AttachmentFactory.AttachmentFactory;
import main.java.FurnitureFactory.FurnitureFactory;

import java.io.IOException;

public class FurnitureInventory
{

    private FurnitureFactory[] furnitures;
    private AttachmentFactory[] attachmentList;

    public FurnitureInventory() {

    }

    public FurnitureFactory[] getFurnitures() {
        return furnitures;
    }

    public AttachmentFactory[] getAttachmentList() {
        return attachmentList;
    }

    public void  CreateFurniture(String[] buildFurnitures) throws IOException, NotInBoardBoundsException {
        furnitures = new FurnitureFactory[buildFurnitures.length-3];
        attachmentList = new AttachmentFactory[3];

        for(int i=0; i<buildFurnitures.length;i++) {
            if(i<3){
                attachmentList[i] = new AttachmentFactory();
                String[] temp = buildFurnitures[i].split("	");
                if(temp.length > 1) {
                    String[] tempNr = temp[1].split(",");
                    attachmentList[i].createAttachment(temp[0], Integer.parseInt(tempNr[0]), Integer.parseInt(tempNr[1]),
                                                       Integer.parseInt(tempNr[2]), Integer.parseInt(tempNr[3]));
                }
                else{
                    for(String c: temp) {
                        System.out.println(c); //bara en nice kontroll. Ändra till throw sen kanske
                    }
                }
            }
            else {
                furnitures[i-3] = new FurnitureFactory();
                furnitures[i-3].createFurniture(buildFurnitures[i]);
            }
        }
    }

}
