package PageFrame;

import java.util.Iterator;
import java.util.Vector;

import Database.Cocktail;
import Database.CocktailDAO;
import Database.MyCocktail;

public class PreferenceCocktail {
	Vector<Cocktail> cocktail;
	
	//sweet
	public Vector<Cocktail> Preference() {
		cocktail = new Vector<Cocktail>();
		Iterator<Cocktail> it = CocktailDAO.getTreeMap().keySet().iterator(); //받아온 리스트를 Iterator에 맞게 변환
		
		while(it.hasNext()) {
			Cocktail ct = it.next();
			
			if(ct.getSweet() == MyCocktail.sweet && ct.getHot() == MyCocktail.hot) {
				cocktail.add(ct);
			}
		}
		
		return cocktail;
	}
}