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

    public void toIcon(Note n) throws IOException {
        File folder = new File("graphics/blankButton.png");
        String nStr = n.toString();
        String fileName = FilenameUtils.removeExtension(folder.getName());
        BufferedImage image = ImageIO.read(folder);
        ImageIcon icon = new ImageIcon(image);
        icon.setDescription(fileName);
        if (nStr.substring(0,nStr.length() - 1).equals(fileName)) {
            iconList.add(icon);
        } else if (fileName.equals("EllipseButton")) {
            this.setEllipseIcon(icon);
        } else {
            nonUsedIconList.add(icon);
        }

    }
}
