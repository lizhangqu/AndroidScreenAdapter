package cn.edu.zafu.model;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * @author lizhangqu
 * @description 
 * @date 
 */
@XStreamAlias("resources")
public class Resource {
	@XStreamImplicit(itemFieldName = "dimen")
	List<Dimen> dimens = new ArrayList<Dimen>();

	public Resource() {
	}

	public Resource(List<Dimen> dimens) {
		this.dimens = dimens;
	}

	public List<Dimen> getDimens() {
		return dimens;
	}

	public void setDimens(List<Dimen> dimens) {
		this.dimens = dimens;
	}

	@Override
	public String toString() {
		return "Resource [dimens=" + dimens + "]";
	}

}
