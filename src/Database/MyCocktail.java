package Database;

import java.util.Vector;

public class MyCocktail {
	private String name = "Guest01";
	private String favor;
	public static int sweet = 2;
	public static int hot = 2;
	public static Vector<Basket> basket = new Vector<Basket>();
	
	public MyCocktail() {
		String a = "";
		String b = "";
		if(sweet == 1) {
			a = "달고 ";
		}else if(sweet == 0) {
			a = "달지 않고 ";
		}
		
		if(hot == 1) {
			b = "도수가 높은것을 선호 합니다.";
		}
		else if(hot == 0) {
			b = "도수가 낮은걸을 선호 합니다.";
		}
		
		favor = a + b;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFavor() {
		return favor;
	}
	public void setFavor(String favor) {
		this.favor = favor;
	}
	
	public String recommendCocktail() {
		if(sweet == 0 && hot == 0) {
			favor = "";
		}
		return favor;
	}

	@Override
	public String toString() {
		return "<HTML>이름 : " + name + "<br>선호하는 칵테일 : " + favor;
	}
}
