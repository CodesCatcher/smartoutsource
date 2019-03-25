package com.phydf.outsourceout.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.awt.image.BufferedImage;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class QRFactory {

    public static BufferedImage getQRImage(String content) {

        try {

            int width = 250; // 图像宽度
            int height = 250; // 图像高度

            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                    BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵

            return MatrixToImageWriter.toBufferedImage(bitMatrix);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
