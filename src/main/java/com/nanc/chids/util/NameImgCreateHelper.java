package com.nanc.chids.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


public class NameImgCreateHelper {
    public static void create(String name,String idCardNo) throws IOException {

        //需要添加水印的图片的路径

        InputStream is = new FileInputStream("d:/20171015153427.jpg");
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        Graphics g = buffImg.getGraphics();
        ImageIcon imgIcon = new ImageIcon("d:/20171015153427.jpg");


        Image img = imgIcon.getImage();
        g.drawImage(img, 5, 330, null);
        g.setColor(Color.BLACK);
        Font f = new Font("宋体", Font.BOLD, 15);
        g.setFont(f);
        g.drawString(name, 10, 30);

        g.dispose();

        File file = new File("d:/name/"+idCardNo+".jpg");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        OutputStream os = new FileOutputStream(file);

        //创键编码器，用于编码内存中的图象数据。
        JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
        en.encode(buffImg);


        is.close();
        os.close();


    }

}