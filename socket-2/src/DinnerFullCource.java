public class DinnerFullCource {

	private Dish[] list = new Dish[5];// [0]-[4]の計5個

	public static void main(String[] args) {

		DinnerFullCource fullcourse = new DinnerFullCource();
		fullcourse.eatAll();
	}

	DinnerFullCource() {

        list[0] = new Dish();
        list[0].setName("特選シーザーサラダ");
        list[0].setValune(10);

        list[1] = new Dish();
        list[1].setName("銀シャリ");
        list[1].setValune(2);

        list[2] = new Dish();
        list[2].setName("梅干し");
        list[2].setValune(20);

        list[3] = new Dish();
        list[3].setName("お味噌汁");
        list[3].setValune(5);

        list[4] = new Dish();
        list[4].setName("おしんこ");
        list[4].setValune(25);


		// dish1 = new Dish();
		// dish1.setName("特選シーザサラダ");
		// dish1.setValune(10);

		// dish2 = new Dish();
		// dish2.setName("銀しゃり");
		// dish2.setValune(2);
		
		// dish3 = new Dish();
		// dish3.setName("梅干し");
		// dish3.setValune(20);
		

	}// Dinnerコンストラクターエンド

	void eatAll() {
		String str = list[0].getName() + "=" + list[0].getValune() + ","
				+ list[1].getName() + "=" + list[1].getValune() + ","
				+ list[2].getName() + "=" + list[2].getValune() + ","
				+ list[3].getName() + "=" + list[3].getValune() + ","
				+ list[4].getName() + "=" + list[4].getValune();
		System.out.println("たかしへ、ママです。今日の晩御飯は" + str + "よ");
	}// eat end

	// cook3Dishes()

}//Dinner end
