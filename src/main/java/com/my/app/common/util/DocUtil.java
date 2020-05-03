package com.my.app.common.util;

import java.awt.image.BufferedImage;
import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

public class DocUtil {

	public static void toImage(String src, String des) {
		try (PDDocument document = PDDocument.load(new File(src))) {
			PDFRenderer renderer = new PDFRenderer(document);

			for (int page = 0; page < document.getNumberOfPages(); page++) {
				BufferedImage bi = renderer.renderImageWithDPI(page, 300, ImageType.RGB);

				ImageIOUtil.writeImage(bi, des, 300);
			}

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}