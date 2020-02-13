package com.qhm.pojo;
/** 

* @author 作者 QHM: 

* @version 创建时间：2019年12月20日 下午7:20:57 

* 类说明 

*/
public class Link {

	
	private Integer id;
	private String text;
	private String url;
	private String created;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Link(Integer id, String text, String url, String created) {
		super();
		this.id = id;
		this.text = text;
		this.url = url;
		this.created = created;
	}

	@Override
	public String toString() {
		return "Link [id=" + id + ", text=" + text + ", url=" + url + ", created=" + created + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
