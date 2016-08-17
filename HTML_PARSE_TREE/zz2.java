import java.io.*;
import java.util.*;
import java.lang.*;

class zz2
{
 public static FileReader fr;
 public static FileWriter fw2;
 public static String data="";
 public char analyse[]=new char[1000];
  public String tag1;
 public String  gettag() throws Exception
 {
   
   String tag="";
   data="";
   int c=0;
   char d[]=new char[1];
   
   int flag=1;
   boolean dataflag=true;
   do
   {
      tag="";
      do
      {
       c=fr.read();
       if(c==-1)
       {
        tag="end of file";
        tag1=tag;
        return tag;
       }
       d[0]=(char)c;
       
       if(d[0]=='|')
         d[0]=' ';
       if(d[0]=='&')
       { 
         d[0]=' ';
       do
       {
         c=fr.read();
         if((char)c==' ')
           break;
       }while((char)c!=';');
       }
       if(dataflag&&d[0]!='<')
        data=data+new String(d);
      }while(d[0]!='<');
      data=trim1(data,1);
      fw2.write(data);
      fw2.write("\r\n");
      
      tag=tag+new String(d);
     do
     {
       c=fr.read();
       d[0]=(char)c;
       tag=tag+new String(d);
       if(tag.equals("<script")||tag.equals("<SCRIPT")||tag.equals("<STYLE")||tag.equals("<FORM")||tag.equals("<SELECT")||tag.equals("<IFRAME")||tag.equals("<UL"))
       {
         
         tag="";
         flag=0;
         dataflag=false;
         
       }
       if(tag.equals("<META")||tag.equals("<LINK")||tag.equals("<BR")||tag.equals("<IMG")||tag.equals("<INPUT"))
       {
         do
         {
         
         c=fr.read();
         d[0]=(char)c;
         }while(d[0]!='>');
         
         tag="";
       }
        
       else if(tag.equals("</SCRIPT>")||tag.equals("</script>")||tag.equals("</STYLE>")||tag.equals("</FORM>")||tag.equals("</SELECT>")||tag.equals("</IFRAME>")||tag.equals("</UL>"))
       {
         
          tag="";flag=1;dataflag=true;
       }
       else if(tag.equals("<!--"))
       {
         tag="";
         do
         {
            c=fr.read();
            d[0]=(char)c;
         }while(d[0]!='>');
       }

     }while(d[0]!='>');
    }while(flag==0||tag.equals(""));
   tag=trim1(tag,0);
   return tag;
 }
 public String trim1(String tag,int c)
 {

   char temp[]=new char[1000];
   char temp1[]=new char[1000];
   int length=tag.length();
  
   
   
    tag.getChars(0,length,temp,0);
    tag="";
    int j=0,k=0;
    for(int i=0;i<length;i++)
    {
     if(Character.isWhitespace(temp[i])&&c==0)
     {
        c=1;
        analyse[k++]='>';
     }
     if(c==0) //counterflag
     {
      analyse[k++]=temp[i];
     }  
     if(!Character.isWhitespace(temp[i]))
     {
        temp1[j++]=temp[i];
        
     }
    }
    
    /*if(analyse[1]=='/')
    {
       int i;
       for( i=1;i<k-1;i++)
         analyse[i]=analyse[i+1];
       analyse[i]=' ';
    }*/
    tag=new String(temp1);
    tag=tag.substring(0,j);
    tag1=new String(analyse);
    tag1=tag1.substring(0,k);
    tag.trim();
    
    return tag;
 } 
     
 
}
     