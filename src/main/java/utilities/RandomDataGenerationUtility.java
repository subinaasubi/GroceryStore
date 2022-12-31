package utilities;

import com.github.javafaker.Faker;

public class RandomDataGenerationUtility {

	static Faker faker;
	static String fName;
	static String lName;
	static String email;
	static String phoneNumber;
	static String address4;

	public static String getFName(){
		faker=new Faker();
		String fName = faker.name().firstName();
		return fName;
	}

	public static String getPassword() {
		faker = new Faker();
		return faker.internet().password();
	}

	public static String getEmail(){
		faker = new Faker();
		return faker.internet().emailAddress();
	}

	public static String getPhoneNumber(){
		faker=new Faker();
		phoneNumber = faker.phoneNumber().phoneNumber();

		return phoneNumber;
	}

	public static String getLName(){
		faker=new Faker();
		lName = faker.name().lastName();
		return lName;
	}


	public static String getAddress()
	{
		faker=new Faker();
		address4=faker.address().fullAddress();
		return address4;
	}


	public static void main(String args[])
	{
		String k=RandomDataGenerationUtility.getEmail();
		System.out.println("The email is: "+k);
		String a  =RandomDataGenerationUtility.getFName();
		System.out.println("The first name is: "+a);
		String p=RandomDataGenerationUtility.getPhoneNumber();
		System.out.println("The phone number is: "+p);
		String l=RandomDataGenerationUtility.getLName();
		System.out.println("The last name is: "+l);
		String m=RandomDataGenerationUtility.getAddress();
		System.out.println("The full address is: "+m);
		String y=RandomDataGenerationUtility.getPassword();
		System.out.println("The password is: "+y);
	}
}
