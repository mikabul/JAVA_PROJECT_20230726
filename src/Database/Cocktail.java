package Database;

public class Cocktail implements Comparable<Cocktail>{
	
	
	//칵테일 이름, 설명, 추천안주
	private String favor;
	private String cName;
	private String description;
	private String sideMenu;
	
	private int sweet; // false 0 true 1
    private int hot;
    
	public Cocktail() {
		// TODO Auto-generated constructor stub
	}

	public Cocktail(String favor, String cName, String description, String sideMenu, int sweet, int hot) {
		this.favor = favor;
		this.cName = cName;
		this.description = description;
		this.sideMenu = sideMenu;
		this.sweet = sweet;
		this.hot = hot;
	}

	public String getFavor() {
		return favor;
	}

	public void setFavor(String favor) {
		this.favor = favor;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSideMenu() {
		return sideMenu;
	}

	public void setSideMenu(String sideMenu) {
		this.sideMenu = sideMenu;
	}

	public int getSweet() {
		return sweet;
	}

	public void setSweet(int sweet) {
		this.sweet = sweet;
	}

	public int getHot() {
		return hot;
	}

	public void setHot(int hot) {
		this.hot = hot;
	}

	@Override
	public String toString() {
		return "<HTML>이름 : " + cName + "<br>역사 : "+description+"<br>추천 안주 : "+sideMenu;
	}
	
	public String getString() {
		return "<HTML>이름 : " + cName + "<br>역사 : "+description +"</HTML>";
	}
	
	@Override
	public int compareTo(Cocktail o) {
        if(cName.compareTo(o.getcName()) > 0) return 1;
        else if(cName.compareTo(o.getcName()) == 0) return 0;
        else return -1;
    }
	
	
}