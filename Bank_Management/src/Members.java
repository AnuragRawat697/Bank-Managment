
import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Members {
	private final int LENGTH = 0;
	private String fName;
	private String lName;
	private int ID;
	private double money;
	private final int RECSIZE = 92;

	public void setData(String first_name, String last_name, int id, double money) {
		fName = first_name;
		lName = last_name;
		ID = id;
		this.money = money;
	}

	public void setFirstName(String first) {
		fName = padding(first, LENGTH);
	}

	public void setLastName(String last) {
		lName = padding(last, LENGTH);
	}

	public void setID(int id) {
		ID = id;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getFirstName() {
		return fName;
	}

	public String getLastName() {
		return lName;
	}

	public int getID() {
		return ID;
	}

	public double getMoney() {
		return money;
	}

	private void writeString(RandomAccessFile out, String str) throws IOException {
		System.out.println(str);
		out.writeBytes(str);
//		char[] temp = new char[str.length()];
//		temp = str.toCharArray();
//		for (int i = 0; i < temp.length; i++) {
//			out.writeChar(temp[i]);
//			out.
//			}
		
		
		
	}

	public void writeToFile(RandomAccessFile out,int firstNameLength,int lastNameLength) throws IOException {
		
	writeString(out, fName);
	writeString(out, lName);
	out.writeInt(ID);
	out.writeDouble(money);
	}

	
	private String readString(RandomAccessFile in, int size) throws IOException {
		char[] temp = new char[size];
		for (int i = 0; i < temp.length; i++)
			temp[i] = in.readChar();
		return new String(temp);
	}

	public void readFromFile(RandomAccessFile in) throws IOException {
		fName = readString(in, LENGTH);
		lName = readString(in, LENGTH);
		ID = in.readInt();
		money = in.readDouble();
	}

	public static String padding(String s, int size) {
		if (s.length() > size)
			s = s.substring(0, size);
		else {
			for (int i = s.length(); i < size; i++)
				s += '	';
		}
		return s;
	}

	
}
