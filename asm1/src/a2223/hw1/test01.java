package a2223.hw1;
import java.math.BigDecimal;


public class test01 {
	
	public static void main(String[] args) {
		BigDecimal b1 = new BigDecimal(100);
		BigDecimal sum = new BigDecimal(1);
		BigDecimal one = new BigDecimal(-1);
		for(int i =1; i<=100;i++) {
			sum.multiply(new BigDecimal(i));
			b1.add(one);
		}
		System.out.print(sum);
		System.out.print(b1);
		
	}
	
}
