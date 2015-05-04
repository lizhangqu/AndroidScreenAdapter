package cn.edu.zafu.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * @author lizhangqu
 * @description 
 * @date 
 */
@XStreamAlias("dimen")
@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "value" })
public class Dimen {
	@XStreamAlias("name")
	@XStreamAsAttribute()
	private String name;
	private String value;

	public Dimen() {
	}

	public Dimen(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Dimen [name=" + name + ", value=" + value + "]";
	}
	
}
