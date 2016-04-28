package com.lhs.pay.web.permission.entity.vo;

import com.lhs.pay.web.permission.entity.PmsMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthMenuTreeVO {
	private Map data = new HashMap();
	private Map attr = new HashMap();
	private List<AuthMenuTreeVO> children = new ArrayList<>();
	
	public AuthMenuTreeVO(PmsMenu menu){
		//菜单项名称
		this.data.put("title", menu.getName());
		//菜单项链接
		Map linkattr = new HashMap();
		Map href = new HashMap();
		linkattr.put("val", menu.getUrl());
		this.data.put("attr", linkattr);
		
//		Set<PmsMenu> subMenus = menu.get;
//		for(Iterator<Menu> iter = subMenus.iterator() ; iter.hasNext() ;){
//			PmsMenu subMenu = iter.next();
//			AuthMenuTreeVO mtv = new AuthMenuTreeVO(subMenu);
//			children.add(mtv);
//		}
	}

	
	public Map getData() {
		return data;
	}


	public void setData(Map data) {
		this.data = data;
	}


	public Map getAttr() {
		return attr;
	}
	public void setAttr(Map attr) {
		this.attr = attr;
	}
	public List<AuthMenuTreeVO> getChildren() {
		return children;
	}
	public void setChildren(List<AuthMenuTreeVO> children) {
		this.children = children;
	}

	public static void main(String[] args) {
		PmsMenu menu = new PmsMenu();
		menu.setId(1l);
		menu.setName("测试节点");
		menu.setUrl("www.baidu.com");
		List<AuthMenuTreeVO> vos = new ArrayList<>();
		vos.add(new AuthMenuTreeVO(menu));
System.out.println(vos.get(0).data);
	}
}