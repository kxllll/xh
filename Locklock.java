import java.lang.*;
import java.io.*;

class  Locklock
{
	public static void main(String[] args) 
	{
		File file =new File("C:\\Users\\82736\\OneDrive - 香港中国妇女会中学\\Desktop\\账号密码.txt");
		String str1[] = new String[100];
		String str2[] = new String[100];
		char key = '1';
		try
		{
			FileReader inOne = new FileReader(file);
			BufferedReader inTwo = new BufferedReader(inOne);
			for (int i=0;i<=99 ;i++ )
			{	
				str1[i] = inTwo.readLine();
				if (str1[i] == null) break;
//				System.out.println(str1[i]);		
			}
			for (int i = 0;i<= 99 ;i++ )
			{	
				if (str1[i] == null) break;
				char c[] = str1[i].toCharArray();
				int j = c.length;
				char b[] = new char[j];		
				for (int a= 0;a<j ;a++ )
				{
					b[a] = (char)(c[a]^key);
				}
				str2[i] = String.valueOf(b);
			}
			FileWriter outOne = new FileWriter(file);
			BufferedWriter outTwo = new BufferedWriter(outOne);
			for (int i = 0;i<=99 ;i++ )
			{
				if(str2[i]==null) break;
				outTwo.write(str2[i]);
				outTwo.write("\n");			
			}
			outTwo.close();
				
		}
		catch (IOException e){}
	}

}
