package org.liu.Grey.core;

import org.liu.Grey.tools.FileDealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

public class ColorChanger extends ColorDeal {

    private static final Logger logger = LoggerFactory.getLogger(ColorChanger.class);
    public String startPath = "GreyCore/src/main/resources/pics";
    public String destinationPath = "GreyCore/src/main/resources/res";

    public void setWinDowsRegrexsplit(String winDowsRegrexsplit) {
        this.winDowsRegrexsplit = winDowsRegrexsplit;
    }

    public String winDowsRegrexsplit = "\\\\";

    @Override
    public boolean changeTo() {
        return changeTo(this.getColor());
    }

    public boolean changeTo(String Color) {
        return changeTo(Color, startPath);
    }

    public boolean changeTo(String Color, String startPath) {
        return changeTo(Color, startPath, destinationPath);
    }

    public boolean changeTo(String Color, String startPath, String destinationPath) {
        logger.info("Start,change to:" + Color.toUpperCase());
        synchronized (this) {
            FileDealer fileDealer = new FileDealer();
            logger.info("reading all files through " + startPath);
            for (String fileName : fileDealer.listFile(startPath)) {
                File destFile = new File(destinationPath + "/" + fileName.split(winDowsRegrexsplit)[fileName.split(winDowsRegrexsplit).length - 1].replace("." + fileDealer.fileSuffix, "") + ".png");
                logger.info("Changing to " + destinationPath + "/" + fileName.split(winDowsRegrexsplit)[fileName.split(winDowsRegrexsplit).length - 1].replace("." + fileDealer.fileSuffix, "") + ".png");
                try {
                    BufferedImage image = ImageIO.read(new File(fileName));
                    BufferedImage destImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
                    //此处转化
                    ColorConvertOp cco = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
                    cco.filter(image, destImage);
                    ImageIO.write(destImage, "png", destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info("NO File here:" + fileName);
                    return false;
                }
            }
        }
        return true;
    }
}
