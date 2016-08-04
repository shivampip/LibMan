/* Created by Shivam Agrawal  */
/* Date:   24-11-2015  2:35AM  */

import java.util.Scanner;
class Calen
{
static int mo[]={ 31,28,31,30,31,30,31,31,30,31,30,31};

/*---------------------------------------Date input----------------------------------------------------------------*/
static int d,m,y;
static void date(String as)
{
do {
Scanner sc=new Scanner(System.in);
System.out.print("Enter the "+as+" date:-\n\t Day:-      "); 
d=sc.nextInt();
System.out.print("\t Month:-    "); 
m=sc.nextInt();
System.out.print("\t Year:-     ");
y=sc.nextInt();
}while(!dateValid(d,m,y));
}

/*----------------------------------------Date Validity--------------------------------------------------------------*/
static boolean dateValid(int d,int m,int y)
{
if(leap(y)&&m==2&&d==29)
return true;
else if(m>12||d>mo[m-1])   
{
System.out.println("The date "+d+"-"+m+"-"+y+" is Invalid."); 
return false;
}
else                  
return true;
}
	
/*-------------------------------------------------------------Leap Year--------------------------------------------------------------------------*/
static boolean leap(int i)
{						
if(i%400==0||(i%4==0&&i%100!=0))
return true;
else 
return false;
}

/*---------------------------------------------------------------Next Date--------------------------------------------------------*/
static int rday,rmonth,ryear;
static void date(int d,int m,int y,int t)
{
String daydin=date(d,m,y);
int tot=totday+t;
date(tot);
System.out.println("Returing date=  "+day+"-"+month+"-"+year);
rday=day;
rmonth=month;
ryear=year;
}

/*_______________________________________Total Days & Day____________________________________________*/
static int totday;
static String date(int d,int m,int y)
{
Calen cl=new Calen();
if(!cl.dateValid(d,m,y))
return " Enter Date again. ";
else
{
int lp=(y-1)/4+(y-1)/400-(y-1)/100;
int td=(y-1)*365+lp;
for(int i=0;i<(m-1);i++)
td+=mo[i];
td+=d;
if(leap(y))
td+=1;
totday=td;
String day="Noday";
switch(td%7)
{
case 0:    return "Sunday";
case 1:    return "Monday";
case 2:    return "Tuesday";
case 3:    return "Wenesday";
case 4:    return "Thersday";
case 5:    return "Friday";
case 6:    return "Saturday";
default:   return "Noday";
}
}
}

/*----------------------------------------------Date big or not--------------------------------------------------------*/
static boolean datebig(int d1,int m1,int y1,int d2,int m2,int y2)
{
if(y1<y2)
return true;
else if(y1>y2)
return false;
else
{
if(m1<m2)
return true;
else if(m1>m2)
return false;
else
{
if(d1>d2)
return false;
else
return true;
}
}
}

/*------------------------------------------------------Day b/w two dates-------------------------------------------------*/
static int date(int d1,int m1,int y1,int d2,int m2,int y2)
{
int lp1=(y1-1)/4+(y1-1)/400-(y1-1)/100;
int td1=(y1-1)*365+lp1;
for(int i=0;i<(m1-1);i++)
td1+=mo[i];
td1+=d1;
if(leap(y1))
td1+=1;
int lp2=(y2-1)/4+(y2-1)/400-(y2-1)/100;
int td2=(y2-1)*365+lp2;
for(int i=0;i<(m2-1);i++)
td2+=mo[i];
td2+=d2;
if(leap(y2))
td2+=1;
int td=td2-td1;
return td;
}



/*---------------------------------------------------------------Days to Date--------------------------------------------------------*/
static int day,month,year;
static void date(int a)
{
int y=0,m=0,d=0;
/*---------------------------for Year----------------------*/
for(;0<(a-365);)
{
	a-=365;
	y++;
	if(leap(y))
	a--;	
}
year=y+1;
/*-------------------------for Month-------------------------*/
for(int i=0;mo[i]<a;i++)
{
	a-=mo[i];
	if(leap(y+1)&&i==1)
	a--;
	m++;
}
month=m+1;
/*-------------------------for days-------------------------*/
d=a;
day=d;
}




		



}
