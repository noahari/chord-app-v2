package frontend;

import org.apache.commons.io.FilenameUtils;
import org.jfugue.theory.Note;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Panel extends JPanel {
    private ArrayList<ImageIcon> iconList = new ArrayList<>();
    private ArrayList<ImageIcon> nonUsedIconList = new ArrayList<>();
    private ImageIcon ellipseIcon;

    public void setEllipseIcon(ImageIcon ellipseIcon) {
        this.ellipseIcon = ellipseIcon;
    }

    public ImageIcon getEllipseIcon() {
        return ellipseIcon;
    }

    public ArrayList<ImageIcon> getIconList() {
        return iconList;
    }

    public abstract void draw();

    public void toIcons(Note n) throws IOException {
        File folder = new File("graphics/");
        File[] listOfFiles = folder.listFiles();
        String nStr = n.toString();
        for (File f : listOfFiles) {
            String fileName = FilenameUtils.removeExtension(f.getName());
            BufferedImage image = ImageIO.read(f);
            ImageIcon icon = new ImageIcon(image);
            icon.setDescription(fileName);
            if (nStr.substring(0, nStr.length() - 1).equals(fileName)) {
                iconList.add(icon);
            }
            else if(fileName.equals("EllipseButton")){
                this.setEllipseIcon(icon);
            }
            else {
                nonUsedIconList.add(icon);
            }
        }
    }
}
