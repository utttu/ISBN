
public class ISBNValidation {
	char[] ISBN;
	
	public ISBNValidation(){
		ISBN = new char[10];
		for(int i=0;i<10;i++)
		{
			ISBN[i]='0';
		}
	}
	public ISBNValidation(String s){
		ISBN = new char[10];
		for(int i=0;i<10;i++)
		{
			ISBN[i]=s.charAt(i);
		}
	}
	
	public boolean isValid()
	{
		boolean x=false,q=false;
		for(int i=0;i<10;i++)
		{
			if(ISBN[i]=='X'&&!x)
				x=true;
			else if(ISBN[i]=='?'&&!q)
				q=true;
			else if(!Character.isDigit(ISBN[i]))
				return false;
		}
		return true;
	}
	
	public boolean isValid(String s)
	{
		boolean x=false,q=false;
		for(int i=0;i<10;i++)
		{
			if(s.charAt(i)=='X'&&!x)
				x=true;
			else if(s.charAt(i)=='?'&&!q)
				q=true;
			else if(!Character.isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}
	public void solve(){
		char q = findQ();
		for(int i=0;i<10;i++)
			if(ISBN[i]=='?')
				ISBN[i]=q;
	}
	
	public boolean isSolved(){
		if(!isValid())
			return false;
		for(int i=0;i<10;i++)
			if(ISBN[i]=='?')
				return false;
		return true;
	}
	
	public boolean validate()
	{
		if(!isSolved() || !isValid())
			return false;
		int sum=0;
		for(int i=0;i<10;i++){
			if(ISBN[i]!='?'&&ISBN[i]!='X'){
				sum+=Character.getNumericValue(ISBN[i])*(10-i);
			}
			else
				sum+=10*(10-i);
		}
		if(sum%11==0)
			return true;
		return false;
	}
	
	public char findQ(){
		if(isSolved())
			return 's';
		if(!isValid())
			return 'n';
		char q='?';
		int sum=0;
		int qindex=0;
		for(int i=0;i<10;i++){
			if(ISBN[i]!='?'&&ISBN[i]!='X'){
				sum+=Character.getNumericValue(ISBN[i])*(10-i);
			}
			else if(ISBN[i]=='X'){
				sum+=10*(10-i);
			}
			else{
				qindex=10-i;
			}
		}
		int isx =10;
		if(qindex==1)
			isx=11;
		for(int i=1;i<isx;i++)
		{
			if((((qindex*i)+sum)%11==0))
			{
				if(i!=10){
					q=(char)(i+48);
				}
				else
					q='X';
			}
		}
		return q;
	}
	public String toString()
	{
		String s = "";
		for(int i=0;i<10;i++)
		{
			s+=ISBN[i];
		}
		return s;
	}
}
