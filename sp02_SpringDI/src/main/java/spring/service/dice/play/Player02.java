package spring.service.dice.play;

import spring.service.dice.Dice;
import spring.service.dice.DiceA;
import spring.service.dice.impl.DiceAImpl;

/*
 *	FileName : Player02.java
 *	ㅇ Dice 인터페이스를 가지고 느슨한 결합을 이뤘다. 결과적으로 재사용성이 높아진 코드가 만들어진다.
 *  ㅇ 이전 과정에서는 DiceA 주사위만 플레이할 수 있었다면, 다른 주사위들을 플레이하기 위해서는 코드 라인이 기하급수적으로 늘어나야만했다. 
 *  하지만 인터페이스를 사용하면 깔끔하게 해결된다.
 */
public class Player02 {
	
	///Field
	private Dice dice;
	private int totalValue;
	
	///Constructor Method
	public Player02() {
	}

	
	public Player02(Dice dice) {
		super();
		this.dice = dice;
		
	}


	///Method (getter/setter)
	public Dice getDice() {
		return dice;
	}
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	//==> count 만큼 주사위를 굴려서 합을 후하는 행위
	public void playDice(int count){
		
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			dice.selectedNumber();
			System.out.println("::[ "+dice.getClass().getName()+" ] 의 선택된수 : "+dice.getValue());
			totalValue += dice.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}

}//end of class