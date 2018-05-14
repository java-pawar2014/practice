
package org.testng.demo;

import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;

public class Test {

	public static void main(String[] args) {

		BytePointer outText = null;

		TessBaseAPI api = new TessBaseAPI();
		// Initialize tesseract-ocr with English, without specifying tessdata
		// path
		if (api.Init(null, "eng") != 0) {
			System.err.println("Could not initialize tesseract.");
			System.exit(1);
		}

		// Open input image with leptonica library
		PIX image = pixRead(args.length > 0 ? args[0] : "/home/bpawar/Downloads/vrkIj.png");
		api.SetImage(image);
		// Get OCR result
		outText = api.GetUTF8Text();
		System.out.println("OCR output:\n" + outText.getString());

		// Destroy used object and release memory
		api.End();
		outText.deallocate();
		pixDestroy(image);
	}
}
