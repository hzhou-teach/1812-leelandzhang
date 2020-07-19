
//Leeland Zhang
//Took me 15 mins
//10/10
//Difficulty 1
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class mixmilk_bronze 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("mixmilk.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("mixmilk.out"));
		//Scanner sc = new Scanner(System.in);
		long c1=sc.nextLong();
		long m1=sc.nextLong();
		long c2=sc.nextLong();
		long m2=sc.nextLong();
		long c3=sc.nextLong();
		long m3=sc.nextLong();
		sc.close();
		for(int i=0; i<33; i++)
		{
			if(m1+m2>c2)
			{
				m1-=(c2-m2);
				m2=c2;
			}
			else
			{
				m2=m1+m2;
				m1=0;
				System.out.println(m1+" "+m2);
			}
			if(m3+m2>c3)
			{
				m2-=(c3-m3);
				m3=c3;
			}
			else
			{
				m3=m2+m3;
				m2=0;
				System.out.println(m2+" "+m3);
			}
			if(m3+m1>c1)
			{
				m3-=(c1-m1);
				m1=c1;
				System.out.println(m3+" "+m1);
			}
			else
			{
				m1=m3+m1;
				m3=0;
			}
		}
		if(m1+m2>c2)
		{
			m1-=(c2-m2);
			m2=c2;
		}
		else
		{
			m2=m1+m2;
			m1=0;
		}
		pr.println(m1);
		pr.println(m2);
		pr.println(m3);
		pr.close();
	}
}
