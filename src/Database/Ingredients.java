package Database;

import java.util.ArrayList;

public class Ingredients {
	
	private ArrayList<String> iName;
	private ArrayList<Integer> price;
	private String recipe;
	
	public Ingredients() {
		// TODO Auto-generated constructor stub
	}

	public Ingredients(ArrayList<String> iName, ArrayList<Integer>price, String recipe) {
		this.iName = iName;
		this.price = price;
		this.recipe = recipe;
	}

	public ArrayList<String> getiName() {
		return iName;
	}

	public ArrayList<Integer> getPrice() {
		return price;
	}

	public String getRecipe() {
		return recipe;
	}
	
	
}
