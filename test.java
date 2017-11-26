
public class test {
	
	public static void main(String[] args){
		ISBNValidation isbn = new ISBNValidation("156881111X");
		//493?568419  =  4*10+9*9+3*8+3*7+5*6+6*5+8*4+4*3+1*2+9
		System.out.println("is valid "+isbn.isValid());
		System.out.println("fin q: "+isbn.findQ());
		//System.out.println("cal: "+((4*10+9*9+3*8+3*7+5*6+6*5+8*4+4*3+1*2+9)%11));
	}
}
