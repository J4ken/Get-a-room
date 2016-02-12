package main.java.AttachmentFactory;

/**
 * Created by lukas on 2016-02-12.
 */
public class AttachmentFactory {
    public Attachment createAttachment(String attachmentType, int xStart, int yStart, int xEnd, int yEnd) {
        if(attachmentType == null) {
            return null;
        } else if (attachmentType.equalsIgnoreCase("DÖRR")) {
            return new Door(xStart, yStart, xEnd, yEnd);
        } else if (attachmentType.equalsIgnoreCase("FÖNSTER")) {
            return new WallWindow(xStart, yStart, xEnd, yEnd);
        }
        return null;
    }
}
