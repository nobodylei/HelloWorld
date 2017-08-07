public class Game {
  public static void main(String[] args) {
    int num = buDrink(10,0,0);
    System.out.println(num);
     num = add(100);
     System.out.println(num);
  }
  /**
  * 一块钱一瓶汽水两个空瓶子换一瓶汽水，三个瓶盖换一瓶汽水，十块钱最多可以喝多少瓶汽水？
  * money 钱数
  * bottle 瓶子数量
  * cap 瓶盖数量
  */
  public static int buyDrink(int money,int bottle,int cap) {
		if(money<=0 && bottle<2 && cap<3) {
			return 0;
		}
		int num =  0;//汽水的数量
		num =  num + money + bottle/2 + cap/3；
		bottle = num + bottle % 2;
		cap = num + cap%3;
		money = money - money;
		
		return num + buyDrink(money,bottle,cap);
	}
  /**
  * 递归计算1加到100
  *
  */
  public static int add(int num){
		//System.out.println(num);
		if(num==1){
			return 1;
		}
		return num+add(num-1);
	}
}
















