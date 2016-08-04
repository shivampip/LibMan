/*    Name:            Library Managment
      Created by:    Shivam Agrawal
      Font size:       18
      Font:               Arial                    */


import java.util.Scanner;

class LibMan
{
Scanner sc=new Scanner(System.in);
Calen cl=new Calen();


static String libname="Vidhya Bhoomi";
static int maxbook=3,maxdin=60;
static int d,m,y;
static String book[]={ "No book","Let us C","The Complete Reference","Thinking in Java","Oxford dictionary","Higher Engineering Mathematics","Electromagnetic Fields and Waves","Integrated Electronics","Let us C++","Automatic Control System","Microprocesser","Electrical Circuit Analysis","Data Structure through C/C++"};
static int rr=0;
static int fineperday=3;
static long pass=4321;

String name,city;
int age,id;
int rd,rm,ry;
int bookn[]=new int[10];
int bookcount=0;
int latefee=0;
int latedin=0;


/*-------------------------------------------------------Administration Login------------------------------------------------------------------------------*/
static void admin()
{
Scanner sc=new Scanner(System.in);

System.out.print("Enter the password:-   ");
long upass=sc.nextLong();
if(upass==pass)
{
line('-');
System.out.println(" Login Successful\t\t Administration");
line('~');
System.out.println(" (1)  Library name \n (2)  Maximum number of book \n (3)  Maximun day limit.Fine per day \n (4)  Fine per day \n (5)  Change the password.");
int adc=sc.nextInt();
switch(adc)
{
case 1:
System.out.print("Enter new Library name:-  ");
libname=sc.next();
break;

case 2:
System.out.print("Enter new number of books:-  ");
maxbook=sc.nextInt();
break;


case 3:
System.out.print("Enter new Day limit:-  ");
maxdin=sc.nextInt();
break;

case 4:
System.out.print("Enter new Fine per day:-  ");
fineperday=sc.nextInt();
break;

case 5:
long tpass;
do
{
System.out.print("\nEnter new password:-  ");
tpass=sc.nextLong();
if(tpass<1000)
System.out.print("Password must contain atleast 4 digits. ");
else
{
pass=tpass;
System.out.print("Password ");
}}while(tpass<1000);
break;

default:
System.out.println("Invalid choice");
break;
}
System.out.println("Successfully Changed.");
}
else
System.out.print("Incorrect Password. Please try again.\n");
}



/*-------------------------------------------------------------------Welcome----------------------------------------------------------------------------------*/
static void wel()
{
line('*');
line('*');
System.out.println("\t Welcome to "+libname);
line('=');
}

/*--------------------------------------------------------------------Bye Bye-----------------------------------------------------------------------------------*/
static void bye()
{
line('~');
System.out.println("Thankyou for using the program......");
line('_');
line('^');
}

/*-----------------------------------------------------------------------Line------------------------------------------------------------------------------------*/
static void line(char a)
{
for(byte i=0;i<50;i++)
System.out.print(a);
System.out.println();
}

/*------------------------------------------------------------------Choice Menu---------------------------------------------------------------------------*/
int choice(boolean wu)
{
Scanner sc=new Scanner(System.in);
if(rr<=0)
{
System.out.println(" (0) Administration Login \n (1) User Login \n (2) New User \n (3) User Information \n (4) Change the Date \n (5) Exit.");
int c=sc.nextInt();   
return c;
}
else 
{
if(!wu)
{
line('*');
System.out.println("Welcome "+name+".......\t  Date "+d+"-"+m+"-"+y+" ("+Calen.date(d,m,y)+")");
}
line('~');
if(latefee<=0)
{
System.out.println(" (1) Issuing a book \n (2) Return the book \n (3) Logout \n (4) Exit");
int cc=sc.nextInt();   
return (5+cc);
}
else
{
System.out.println(" (1) Issue a book \n (2) Return the book \n (3)  Payment \n (4) Logout \n (5) Exit");
int cc=sc.nextInt();   
return (9+cc);
}
}
}

/*---------------------------------------------------------------------------Book Input---------------------------------------------------------------------*/
void book()
{
Scanner sc=new Scanner(System.in);
int c;
do
{
if(bookcount>=maxbook)
{
System.out.println("BOOK ISSUING LIMIT FULL. NO MORE BOOKS");
break;
}
System.out.print("Enter the book no.:     ");
int bn=sc.nextInt();
bookn[bookcount]=bn-100;
line('-');
System.out.println("\t  Book name:    "+LibMan.book[bn-100]);
line('-');
bookcount++;
if(bookcount>=maxbook)
{
System.out.println("Book issuing limit Full. No more books");
break;
}
else
System.out.print(" Do you want another book    Yes(1)     No(0)");
c=sc.nextInt();
}while(c==1&&bookcount<maxbook);
Calen.date(d,m,y,maxdin);
rd=Calen.rday;
rm=Calen.rmonth;
ry=Calen.ryear;
line('-');
}


/*------------------------------------------------------------------------Return book---------------------------------------------------------------------*/
void bookr()
{
if(!Calen.datebig(rd,rm,ry,d,m,y)||latefee<=0)
{
System.out.println("Books returned Successfully");
bookcount=0;
bookn[0]=0;
}
else
{
System.out.println("You are "+latedin+" days late. Your fine is "+latefee);
}
}

/*---------------------------------------------------------------------Modify--------------------------------------------------------------------------------*/
void modi()
{
if(rd==0&&rm==0&&ry==0)
{
rd=d;
rm=m;
ry=y;
}
latedin=Calen.date(rd,rm,ry,d,m,y);        
latefee+=latedin*fineperday;
}

/*----------------------------------------------------------------------Payment---------------------------------------------------------------------------*/
void pay()
{
latedin=0;
rd=d;
rm=m;
ry=y;
System.out.println("\n (1) Full Payment \n (2) Some Payment");
int pc=sc.nextInt();
if(pc==1)
{
latefee=0;
System.out.println(" Payment Successful...");
}
else if(pc==2)
{
System.out.print("Enter the amount:-  ");
int amo=sc.nextInt();
latefee-=amo;
System.out.print("Payment Successful. ");
if(latefee>=0)
System.out.println("your due payment is Rs "+latefee);
else
System.out.println("Extra Rs "+(-1*latefee)+" is added in your account.");

}
else
System.out.println("Invalid Choice");
}

/*----------------------------------------------------------------------Taking inputs-----------------------------------------------------------------------*/
void get(int idc)
{
line('~');
System.out.print("Enter your name:\t");
name=sc.next();
System.out.print("Enter your age:     \t");
age=sc.nextInt();
System.out.print("Enter your city:\t");
city=sc.next();
id=idc;
}

/*------------------------------------------------------------------Adding new Member------------------------------------------------------------------*/
void addmem(int a)
{
get(a+1100);
line('-');
System.out.println("Account Created Successfully. Your Id no. is "+(a+1100));
line('-');
}

/*---------------------------------------------------------------------Showing Details---------------------------------------------------------------------*/
void show()
{
line('-');
System.out.println(" Id no:           "+id);
System.out.println(" Name:            "+name);
System.out.println(" Age:             "+age);
System.out.println(" City:            "+city);
System.out.print(" Book:            "+book[bookn[0]]);
for(int p=1;p<bookcount;p++)
System.out.print(", "+book[bookn[p]]);
System.out.println();
if(latefee>0)
System.out.println(" Payment due:     Rs "+latefee);
line('_');
}

/*__________________________________________________________________________________________________*/
/*-----------------------------------------------------------------Main Method-----------------------------------------------------------------------------*/
public static void main(String as[])
{
Scanner sc=new Scanner(System.in);
LibMan lm[]=new LibMan[10];
for(int i=0;i<10;i++)
lm[i]=new LibMan();

wel();
Calen.date("Current");
d=Calen.d;
m=Calen.m;
y=Calen.y;
line('-');

/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
int fordo=0;
boolean ext=true;
boolean welusr=false;
boolean lo=false;
while(ext)
{

int ch=lm[rr].choice(welusr);
/*------------------------------------------------------------------ Control------------------------------------------------------------------------------------*/
if(!lo&&ch>5)
ch=100;

switch(ch)
{

/*--------------------------------------------------------------------Login-------------------------------------------------------------------------------------*/
case 1:
System.out.print("Enter Your ID no:-    ");
int iid=sc.nextInt();
rr=iid-1100;
lo=true;
break;

/*--------------------------------------------------------------------Adding  Users-------------------------------------------------------------------------*/
case 2:
int cc;
do
{
lm[fordo+1].addmem(fordo+1);
fordo++;
System.out.println("Add more member?     Yes(1)\t No(0)");
cc=sc.nextInt();
}while(cc==1);
break;
/*---------------------------------------------------------------------User Information--------------------------------------------------------------------*/
case 3:
System.out.print("Enter your id no:-     ");
int idd=sc.nextInt();
lm[idd-1100].show();
break;


/*----------------------------------------------------------------------Date Change----------------------------------------------------------------------*/
case 4:
Calen.date("New");
d=Calen.d;
m=Calen.m;
y=Calen.y;
for(int i=0;i<10;i++)        
lm[i].modi();    
System.out.println("Date changed Successfully"); 
line('-');
break;   


/*-------------------------------------------------------------------------------Exit--------------------------------------------------------------------------*/
case 5:
case 9:
case 14:
bye();
ext=false;
break;


/*-------------------------------------------------------------------------Book Issue----------------------------------------------------------------------*/
case 6:
case 10:
lm[rr].book();
welusr=true;
break;


/*-------------------------------------------------------------------------Book Return--------------------------------------------------------------------*/
case 7:
case 11:
lm[rr].bookr();                    
welusr=true;
break;

/*-----------------------------------------------------------------------------Logout--------------------------------------------------------------------------*/
case 8:
case 13:
rr=0;
welusr=false;
lo=false;
break;


/*-----------------------------------------------------------------------------Payment----------------------------------------------------------------------*/
case 12:
lm[rr].pay();
welusr=true;
break;

/*--------------------------------------------------------------------------Administration-----------------------------------------------------------------*/
case 0:
line('-');
admin();
wel();
break;



/*-------------------------------------------------------------------------------Default-----------------------------------------------------------------------*/
default:
System.out.println("Invalid choice");
break;
/*___________________________________________________________________________________________________*/

}  //Switch
}  //While 




}  //Main
}  //class
