package Database;

import java.util.ArrayList;
import java.util.TreeMap;

public class CocktailDAO {
	
	private ArrayList<Cocktail> list;
	private ArrayList<Ingredients> iList;
	private ArrayList<MyCocktail> myList;
	private static TreeMap<Cocktail,Ingredients> treeMap;
	
	public CocktailDAO() {
		if(myList == null){
			myList = new ArrayList<MyCocktail>();
		}
		
		if(treeMap == null) {
			init3();
		}
	}
	
	private void init() {
		list = new ArrayList<Cocktail>();
		//드라이1 (마티니), 드라이2(베르무트)
        list.add(new Cocktail("dry","마티니","진을 베이스로 하며, 칵테일의 왕으로 불린다.","리코타치즈",0,0));
        list.add(new Cocktail("dry","베르무트","18세기 이탈리아의 토리노에서 처음 만들어졌다","리코타치즈",0,1));

        //푸르트1(미도리샤워), 푸르트2(시브리즈)
        list.add(new Cocktail("fruit","미도리샤워","미도리 사워는 멜론 맛 리큐어인 미도리에서 유래했습니다.","참치카나페",1,0));
        list.add(new Cocktail("fruit","시브리즈","명칭인 ‘시 브리즈(Sea Breeze)’는 바다에서 불어오는 바람을 의미한다.","참치카나페",1,0));

        //핫1(블랙러시안), 핫2(위스키콕)
        list.add(new Cocktail("hot","블랙러시안","보드카 베이스 칵테일. 여기에 리큐르인 깔루아를 넣는다.","감자튀김",0,1));
        list.add(new Cocktail("hot","위스키콕","유래는 아무도 모른다.","감자튀김",1,1));

        //리프레싱1(코스모폴리탄), 리프레싱2(그래스호퍼)
        list.add(new Cocktail("refresing","코스모폴리탄","보드카를 베이스로 한다. 대표적인 레이디 킬러 칵테일 중 하나이다.","견과류",1,0));
        list.add(new Cocktail("refresing","그래스호퍼","1950~60 년대 미국 남동부 지역에서 최고의 인기를 얻었던 복고풍 칵테일입니다.","견과류",1,0));

        //스무디1(피나콜라다), 스무디2(화이트러시안)
        list.add(new Cocktail("smoothie","피나콜라다","해변가의 바에서 특히 인기있는 칵테일 중 하나입니다.","해산물",1,0));
        list.add(new Cocktail("smoothie","다이키리","다이키리는 1898년 제닝스 콕스라는 한 미국 광산 기술자가 쿠바 남동쪽의 "
                + "광산 마을인 Daiquiri에서 발명한 것으로 추정됩니다.","해산물",0,0));

        //스위트1(깔루아밀크), 스위트2(마가리타)
        list.add(new Cocktail("sweet","깔루아밀크","리큐르를 베이스로 한 칵테일. 말 그대로 우유에 커피 리큐르인 깔루아를 섞은 "
                + "것으로 달콤하고 부드러우며 도수는 맥주와 비슷한 정도. 물론 우유를 섞는 양에 따라 도수는 달라진다.","시나몬과자",1,0));
        list.add(new Cocktail("sweet","마가리타","마가리타는 북미에서 가장 인기 있는 칵테일 중 하나입니다.","닭고기",1,1));
	}
	
	private void init2() {

		iList = new ArrayList<Ingredients>();
			
		//드라이1 (마티니)
		ArrayList<String> martiniName = new ArrayList<String>();
		ArrayList<Integer> martiniPrice = new ArrayList<Integer>();
		
		martiniName.add("진");
		martiniName.add("드라이 베르무트 700ml");
		martiniName.add("앙고스투라 비터스");
		
		martiniPrice.add(80000);
		martiniPrice.add(82600);
		martiniPrice.add(56900);
		
		iList.add(new Ingredients(martiniName, martiniPrice,
				"1. 셰이커에 얼음과 드라이 베르무트를 넣고 조용히 셰이크한 뒤 베르무트만 버린다."
				+ "2. 베르무트를 버린 셰이커에 진을 넣고 다시 셰이크."
				+ "3.차갑게 식힌 마티니 글라스에 따라준다."));

		//드라이2 (베르무트)
		ArrayList<String> VermouthName = new ArrayList<String>();
		ArrayList<Integer> VermouthPrice = new ArrayList<Integer>();
		
		VermouthName.add("레드 와인 750ml");
		VermouthName.add("설탕 1kg");
		VermouthName.add("향쑥 30립");
		VermouthName.add("창포뿌리 300g");
		
		VermouthPrice.add(65500);
		VermouthPrice.add(2970);
		VermouthPrice.add(4800);
		VermouthPrice.add(28000);
		
		iList.add(new Ingredients(VermouthName, VermouthPrice, "원료인 레드/화이트 와인에 주정과 "
				+ "설탕과 향쑥·용담·키니네·창포뿌리 등의 향료나 약초를 넣어만든다"));
		
		
		//푸르트1 (미도리샤워)	
		ArrayList<String> midoriName = new ArrayList<String>();
		ArrayList<Integer> midoriPrice = new ArrayList<Integer>();
		
		midoriName.add("미도리");
		midoriName.add("스윗 앤 사워 믹스 1L");
		midoriName.add("스프라이트 500ml");
		
		midoriPrice.add(38400);
		midoriPrice.add(9800);
		midoriPrice.add(980);
		
		iList.add(new Ingredients(midoriName, midoriPrice, "얼음이 들어 있는 하이볼 글라스 또는 사워 글라스에 스프라이트를 "
				+ "제외한 나머지 재료들을 모두 넣은 다음, 스프라이트로 나머지를 채워준다. "
				+ "이후 레몬 또는 체리로 가니쉬하면 완성."));
		
	
		//푸르트2(시브리즈)
		ArrayList<String> seaBreezeName = new ArrayList<String>();
		ArrayList<Integer> seaBreezePrice = new ArrayList<Integer>();
		
		seaBreezeName.add("보드카");
		seaBreezeName.add("크렌베리 주스 1.89L");
		seaBreezeName.add("자몽주스 1.89L");
		
		seaBreezePrice.add(31000);
		seaBreezePrice.add(4050);
		seaBreezePrice.add(4130);
		
		iList.add(new Ingredients(seaBreezeName, seaBreezePrice, "얼음을 채운 하이볼 글라스에 위의 재료들을 모두 부어준다."
				+ "이후 오렌지 필과 마라스키노 체리로 가니쉬해주면 완성."));
		

		//핫1(블랙러시안)
		ArrayList<String> blackrussianName = new ArrayList<String>();
		ArrayList<Integer> blackrussianPrice = new ArrayList<Integer>();
		
		blackrussianName.add("보드카");
		blackrussianName.add("깔루아 700ml");
		
		blackrussianPrice.add(31000);
		blackrussianPrice.add(31500);
		
		iList.add(new Ingredients(blackrussianName, blackrussianPrice, "재료들을 얼음이 담긴 온더락 글라스에 부어준 다음, 그대로 스터해주면 완성."));
		
		//핫2(위스키콕)
		ArrayList<String> whiskycokeName = new ArrayList<String>();
		ArrayList<Integer> whiskycokePrice = new ArrayList<Integer>();
		
		whiskycokeName.add("위스키 700ml");
		whiskycokeName.add("코카콜라 500ml");
		
		whiskycokePrice.add(43900);
		whiskycokePrice.add(1080);
		
		iList.add(new Ingredients(whiskycokeName, whiskycokePrice, "재료들을 모두 온더락 글라스에 빌드해주면 완성."));
		
		//리프레싱1(코스모폴리탄)
		ArrayList<String> cosmopolitanName = new ArrayList<String>();
		ArrayList<Integer> cosmopolitanPrice = new ArrayList<Integer>();
		
		cosmopolitanName.add("보드카");
		cosmopolitanName.add("코앵트로");
		cosmopolitanName.add("라임주스 750ml");
		
		cosmopolitanPrice.add(31000);
		cosmopolitanPrice.add(47000);
		cosmopolitanPrice.add(10900);
		
		iList.add(new Ingredients(cosmopolitanName, cosmopolitanPrice, "재료들을 얼음과 함께 8~10초간 셰이킹한 다음, "
				+ "더블 스트레인으로 걸러내 "
				+ "커다란 마티니 글라스에 따라준다."));
		
		//리프레싱2(그래스호퍼)
		ArrayList<String> grasshopperName = new ArrayList<String>();
		ArrayList<Integer> grasshopperPrice = new ArrayList<Integer>();
		
		grasshopperName.add("크렘 드 멘트 그린 750ml");
		grasshopperName.add("크렘 드 카카오 화이트 700ml");
		grasshopperName.add("크림 200ml");
		
		grasshopperPrice.add(32600);
		grasshopperPrice.add(19900);
		grasshopperPrice.add(2310);
		
		iList.add(new Ingredients(grasshopperName, grasshopperPrice, "위의 재료들을 얼음과 함께 8~10초 가량 “활기차게” 셰이킹해 주고, "
				+ "얼음을 걸러내어 차갑게 식힌 마티니 글라스에 따라주면 완성."));
		
		//스무디1(피나콜라다)
		ArrayList<String> pinacoladaName = new ArrayList<String>();
		ArrayList<Integer> pinacoladaPrice = new ArrayList<Integer>();
		
		pinacoladaName.add("화이트 럼");
		pinacoladaName.add("피냐 콜라다 믹스 1L");
		pinacoladaName.add("파인애플 주스 1L");
		
		pinacoladaPrice.add(41900);
		pinacoladaPrice.add(12000);
		pinacoladaPrice.add(4000);
		
        iList.add(new Ingredients(pinacoladaName, pinacoladaPrice, "1. 재료들을  얼음 큐브 5~6개와 함께 블렌딩해 준다."
                + "2. 그란데 글라스에 따라주고 파인애플과 체리로 가니쉬해주면 완성."));
        
        
        //스무디2(화이트러시안)
        ArrayList<String> whiterussianName = new ArrayList<String>();
		ArrayList<Integer> whiterussianPrice = new ArrayList<Integer>();
		
		whiterussianName.add("보드카");
		whiterussianName.add("깔루아 700ml");
		whiterussianName.add("우유 1L");
		
		whiterussianPrice.add(31000);
		whiterussianPrice.add(31500);
		whiterussianPrice.add(1360);
		
        iList.add(new Ingredients(whiterussianName, whiterussianPrice, "1. 보드카와 칼루아를 순서대로 얼음이 든 온더락 글라스에 빌드해준다."
                + "2. 그 위에 생크림을 조심스레 부어서 층이 지게 해준다."
                + "3. 살짝 저어서 마무리해주면 완성."));

        //스위트1(깔루아밀크)
        ArrayList<String> kahluamilkName = new ArrayList<String>();
		ArrayList<Integer> kahluamilkPrice = new ArrayList<Integer>();
		
		kahluamilkName.add("깔루아 700ml");
		kahluamilkName.add("우유 1L");
		
		kahluamilkPrice.add(31500);
		kahluamilkPrice.add(1360);

		
        iList.add(new Ingredients(kahluamilkName, kahluamilkPrice, "1. 얼음이 들어간 하이볼 글라스 또는 온더락 글라스를 준비하고 잔에 차례대로 붓는다."
                + "잘 섞이게 저어주면 완성."));
        
        //스위트2(마가리타)
        ArrayList<String> margaritaName = new ArrayList<String>();
		ArrayList<Integer> margaritaPrice = new ArrayList<Integer>();
		
		margaritaName.add("데킬라");
		margaritaName.add("트리플 섹");
		margaritaName.add("라임주스 750ml");
		
		margaritaPrice.add(36900);
		margaritaPrice.add(8000);
		margaritaPrice.add(10900);
        
        iList.add(new Ingredients(margaritaName, margaritaPrice, "1. 마가리타 글라스의 테두리의 반만 소금으로 리밍한 다음, 차갑게 식혀준다."
                + "2. 위의 재료들을 모두 얼음과 함께 8~10초 가량 쉐이킹해 준다."
                + "3. 이후 얼음을 걸러내고 아까 전에 리밍한 마가리타 글라스에 따라주면 완성. 가니쉬는 따로 준비하지 않아도 된다."));
	}
	
	private void init3() {
		init();
		init2();
		
		treeMap = new TreeMap<Cocktail,Ingredients>();
		
		for(int i = 0; i < list.size();i++) {
			treeMap.put(list.get(i), iList.get(i));
		}
	}

	public static TreeMap<Cocktail, Ingredients> getTreeMap() {
		if(treeMap == null) {
			new CocktailDAO();
		}
		return treeMap;
	}
	
//	public static void main(String[] args) {
//		Set<Cocktail> keySet = getTreeMap().keySet();
//		Iterator<Cocktail> it = keySet.iterator();
//		while(it.hasNext()) {
//			Cocktail key = it.next();
//			Ingredients i = getTreeMap().get(key);
//			System.out.println(i.getRecipe());
//		}
//		
//		
//	}
}
