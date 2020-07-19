//Leeland Zhang
//Spent 90 mins
//1/10
//Couldn't figure out what was wrong with my code
//difficulty 6/10
//I used like a plastic method, not even bronze prob so maybe thats why
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class backforth_bronze 
{
	static ArrayList<Integer> barn1=new ArrayList<Integer>();
	static ArrayList<Integer> barn2=new ArrayList<Integer>();
	public static int backforth(int pos1, int pos2)
	{
		int r=0;
		int temp=barn1.get(pos1);
		barn2.add(temp);
		barn1.remove(pos1);
		r-=temp;
		temp=barn2.get(pos2);
		barn1.add(temp);
		barn2.remove(pos2);
		r+=temp;
		Collections.sort(barn1);
		Collections.sort(barn2);
		return r;
	}
	public static void reset(ArrayList<Integer> orig1, ArrayList<Integer> orig2)
	{
		for(int i=0; i<orig1.size(); i++)
		{
			barn1.set(i,orig1.get(i));
			barn2.set(i,orig2.get(i));
		}
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("backforth.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("backforth.out"));
		ArrayList<Integer> orig1=new ArrayList<Integer>();
		ArrayList<Integer> orig2=new ArrayList<Integer>();
		for(int i=0; i<10; i++)
		{
			int y=sc.nextInt();
			barn1.add(y);
			orig1.add(y);
		}
		for(int i=0; i<10; i++)
		{
			int y=sc.nextInt();
			barn2.add(y);
			orig2.add(y);
		}
		sc.close();
		//--------------------------------------------------------
		Collections.sort(barn1);
		Collections.sort(barn2);
		Collections.sort(orig1);
		Collections.sort(orig2);
		ArrayList<Integer> solutions=new ArrayList<Integer>();
		int milk=0;
		for(int i=0; i<10; i++)
		{
			if(i!=0&&barn1.get(i)==barn1.get(i-1))
				continue;
			for(int j=0; j<11; j++)
			{
				if(j!=0&&barn2.get(j)==barn2.get(j-1))
					continue;
				milk+=(backforth(i,j));
				for(int a=0; a<10; a++)
				{
					if(a!=0&&barn1.get(a)==barn1.get(a-1))
						continue;
					for(int b=0; b<11; b++)
					{
						barn2.add(barn1.get(a));
						if(b!=0&&barn2.get(b)==barn2.get(b-1))
							continue;
						milk-=barn1.get(a);
						milk+=barn2.get(b);
						barn2.remove(10);
						solutions.add(milk);
						milk=0;
						reset(orig1, orig2);
					}
				}
			}
		}
		Collections.sort(solutions);
		int count=0;
		for(int i=0; i<solutions.size(); i++)
		{
			if(i!=0&&solutions.get(i)==solutions.get(i-1))
				continue;
			else
				count++;
		}
		pr.println(count);
		pr.close();
	}
}
