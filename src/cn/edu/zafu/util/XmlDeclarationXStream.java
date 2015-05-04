package cn.edu.zafu.util;

import java.io.OutputStream;
import java.io.Writer;

import com.thoughtworks.xstream.XStream;

/**
 * @author lizhangqu
 * @description 
 * @date 
 */
public class XmlDeclarationXStream extends XStream {
	private String xmlDeclaration;
	private String version;
	private String ecoding;

	public XmlDeclarationXStream() {
		this("1.0", "utf-8");
	}

	public XmlDeclarationXStream(String version, String ecoding) {
		this.version = version;
		this.ecoding = ecoding;
		buildDeclaration();

	}

	private void buildDeclaration() {
		// generate xmlDeclaration
		StringBuffer buffer = new StringBuffer();
		xmlDeclaration = buffer.append("<?xml version=\"").append(this.version)
				.append("\" encoding=\"").append(this.ecoding).append("\"?>")
				.append("\n").toString();
		buffer = null;
	}

	public String getDeclaration() {
		return xmlDeclaration;
	}

	@Override
	public void toXML(Object arg0, OutputStream arg1) {
		try {
			String dec = this.getDeclaration();
			byte[] bytesOfDec = dec.getBytes(this.ecoding);
			arg1.write(bytesOfDec);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.toXML(arg0, arg1);
	}

	@Override
	public void toXML(Object arg0, Writer arg1) {
		try {
			arg1.write(getDeclaration());
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.toXML(arg0, arg1);
	}

}