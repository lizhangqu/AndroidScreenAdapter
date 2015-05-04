package cn.edu.zafu.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.List;

import cn.edu.zafu.model.Dimen;
import cn.edu.zafu.model.Resource;
import cn.edu.zafu.model.Screen;

import com.thoughtworks.xstream.XStream;

/**
 * 
 * @author lizhangqu
 * @description a tool to generate what we want
 * @date
 */
public class Generator {
	// default base width
	private static final int DEFAULT_BASE_WIDTH = 320;
	// default base height
	private static final int DEFAULT_BASE_HEIGHT = 480;
	// decimal formator
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(
			"#.##");
	// a xstream,XmlDeclarationXStream extends XStream
	private static final XStream XSTREAM = new XmlDeclarationXStream();
	//res dir
	private File resFile=null;
	// base width
	private int baseWidth;
	// base height
	private int beseHeight;

	/**
	 * using default width and height to generate default width is 320,default
	 * height is 480
	 */
	public Generator() {
		this(DEFAULT_BASE_WIDTH, DEFAULT_BASE_HEIGHT);
	}

	/**
	 * using baseWidth and baseHeight to generator
	 * 
	 * @param baseWidth
	 * @param beseHeight
	 */
	public Generator(int baseWidth, int beseHeight) {
		this.baseWidth = baseWidth;
		this.beseHeight = beseHeight;
		XSTREAM.autodetectAnnotations(true);
		this.resFile = new File("./res");
		if (!resFile.exists()) {
			resFile.mkdir();
		}
	}

	/**
	 * using w and h to generate xml
	 * 
	 * @param w
	 *            screen width
	 * @param h
	 *            screen height
	 * @return generated xml
	 */
	public String generateXml(Screen screen) {
		Resource resource = new Resource();
		List<Dimen> dimens = resource.getDimens();

		float cellWidth = screen.getWidth() * 1.0f / baseWidth;
		float cellHeight = screen.getHeight() * 1.0f / beseHeight;

		String result = null;
		Dimen dimen = null;
		for (int i = 1; i <= baseWidth; i++) {
			result = DECIMAL_FORMAT.format(i * cellWidth);
			dimen = new Dimen();
			dimen.setName(String.format("x%d", i));
			dimen.setValue(String.format("%spx", result));
			dimens.add(dimen);
		}

		for (int i = 1; i <= beseHeight; i++) {
			result = DECIMAL_FORMAT.format(i * cellHeight);
			dimen = new Dimen();
			dimen.setName(String.format("y%d", i));
			dimen.setValue(String.format("%spx", result));
			dimens.add(dimen);
		}
		String xml = XSTREAM.toXML(resource);
		return xml;
	}
	public String generateXmlLandscape(Screen screen) {
		Screen s=new Screen(screen.getHeight(),screen.getWidth());
		return generateXml(s);
	}
	/**
	 * write xmlContent to a File
	 * 
	 * @param screen
	 * @param xmlContent
	 */
	public void write2File(String valuesPath, String xmlContent) {
		File fileDir = new File(this.resFile + File.separator + valuesPath);
		fileDir.mkdir();
		File file = new File(fileDir.getAbsolutePath(), "dimens.xml");
		BufferedWriter bw = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write(xmlContent);
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			try {
				if (bw != null) {
					bw.close();
					bw = null;
				}
				if (fos != null) {
					fos.close();
					fos = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
