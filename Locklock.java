import java.lang.*;
import java.io.*;

class  Locklock
{
	public static void main(String[] args) 
	{
		File file =new File("");                                     //文件位置
		String str1[] = new String[100];                             //读取文档字符串，文件长度不超过100行
		String str2[] = new String[100];                             //加密文档字符串
		char key = '1';						     //加密密钥
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
