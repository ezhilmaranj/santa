import java.util.Date;

public class DateCheck {
	public static void main(String[] args) {
		Date d = new Date("2012/09/21");
//		d.setTime(System.nanoTime());
		System.out.println(d.getYear()+1900);
		System.out.println(d.getMonth()+1);
		System.out.println(d.getDate());
	}
	
}
