package Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JOptionPane;

import Database.Basket;
import Database.Cocktail;
import Database.CocktailDAO;
import Database.Ingredients;
import Database.MyCocktail;

public class ButtonEventManager_Shop implements ActionListener{
	Ingredients ingredients;
	Ingredients temp;
	int price;
	String str;
	String iName;
	Boolean bool = false;
	@Override
	public void actionPerformed(ActionEvent e) {
		Iterator<Cocktail> it = CocktailDAO.getTreeMap().keySet().iterator();
		str = e.getActionCommand();
		if(str.charAt(0) == '-') {
			iName = str.substring(1);
		}else {
			iName = str;
		}
		
		while(it.hasNext()) {
			Cocktail ct = it.next();
			temp = CocktailDAO.getTreeMap().get(ct);
			for(int i = 0; i < temp.getiName().size(); i++) {
				if(temp.getiName().get(i).equals(iName)) {
					ingredients = temp;
				}
			}
		}
		
		for(int i = 0; i < ingredients.getiName().size(); i++) {
			if(ingredients.getiName().get(i).equals(iName)) {
				price = ingredients.getPrice().get(i);
			}
		}
		
		if(e.getActionCommand().charAt(0) == '-') {
			for(int i = 0; i < MyCocktail.basket.size(); i++) {
				if(MyCocktail.basket.get(i).getName().equals(iName) && MyCocktail.basket.get(i).getCount() != 0) {
					MyCocktail.basket.get(i).setCount(-1);
					bool = true;
					if(MyCocktail.basket.get(i).getCount() == 0) {
						MyCocktail.basket.remove(i);
					}
					break;
				}
			}
			if(!bool) {
				JOptionPane.showMessageDialog(null, "없는 상품 입니다!");
			}
			bool = false;
			
		}else {
			for(int i = 0; i < MyCocktail.basket.size();i++) {
				if(MyCocktail.basket.get(i).getName().equals(iName)) {
					MyCocktail.basket.get(i).setCount(+1);
					bool = true;
					break;
				}
			}
			if(!bool) {
				MyCocktail.basket.add(new Basket(iName, price, 1));
			}
			bool = false;
		}
	}
	
}