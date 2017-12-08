package frontend;

import org.apache.commons.io.FilenameUtils;
import org.jfugue.theory.Note;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

    public JButton toIcon(Note n) throws IOException {
        File blankFile = new File("graphics/C.png");
        String nStr = n.toString();
        System.out.println(nStr);
        BufferedImage image = ImageIO.read(blankFile);
        ImageIcon icon = new ImageIcon(image);
        icon.setDescription(nStr);
        JButton button = new JButton();
        button.setIcon(icon);
        button.setFont(new Font(button.getFont().getName(), Font.PLAIN, 25));
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setText(nStr.substring(0, nStr.length()-1));
        return button;
    }
}
