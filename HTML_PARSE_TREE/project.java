

import java.io.*;
import java.util.*;
import java.lang.*;
class Pat
{
  String tag;
  int level;
  int count=1;
  String string;
  Pat father;
  Pat child;
  Pat next;
  public void Pat()
  {
    tag="";
    level=-1;
    count=1;
    string=" ";
    father=null;
    child=null;
    next=null;
  }
}

class project
{
  protected FileReader fr;
  protected BufferedReader br;
  protected char analyse[];;
  public static String tag="";
  public static String data="";
  public static boolean moretags=true;
  public void project() throws Exception
  {
      
      data=br.readLine();
  }
  public void gettag() throws Exception
  {
        data="";
        tag="";
        data=br.readLine();
        tag=br.readLine();
         if(data.equals("end of file")||tag.equals("end of file"))
          moretags=false;
 
  }
  
        
      
  public void tagtree() throws Exception
  {
    project p=new project();
    p.fr=new FileReader("mk27_1.txt");
    int length;
    p.br=new BufferedReader(p.fr);
    FileWriter fw=new FileWriter("f.txt");
    FileWriter fw2=new FileWriter("g.txt");
       FileWriter f=new FileWriter("o.txt");
    Pat root=null;
    Pat temp=null,temp1=null;
    Pat mov=null;
    int count=1;
   
    while(moretags)
      {
      p.gettag();
       if(tag!=null&&!tag.equals("end of file")){
      p.analyse=new char[100];
      length=tag.length();
      tag.getChars(0,length,p.analyse,0);

      if(p.analyse[1]=='/')
      {
         for(int i=1;i<length-1;i++)
             p.analyse[i]=p.analyse[i+1];
         p.analyse[length-1]=' ';
         tag=new String(p.analyse).trim();
         temp1=mov;
          if(mov.string.equals(""))
         mov.string=data;
         if(mov.tag.equals(tag))
         {
             
             mov=mov.father;
         }
                          
      }
      else if(root==null)
      {
        root=new Pat();
        root.tag=tag;
        root.level=0;
        root.string=" ";
        mov=root;
      }
      else if(mov.child==null)
      {
       temp=new Pat();
       temp.tag=tag;
       temp.level=mov.level+1;
       temp.string=data;
       temp.father=mov;
       temp.next=null;
       mov.child=temp;
       mov=temp;
  
      }   
      else
      {
        temp=new Pat();
        mov=mov.child;
        while(mov.next!=null)
        {
            mov=mov.next;
        }
        temp.tag=tag;
        temp.level=mov.level;
        temp.string=data;
        temp.next=null;
        temp.father=mov.father;
        mov.next=temp;
        mov=temp;
      }
        
      }
      

      
    }
    p.trav(root,fw);
    fw.close();
    Parser parser=new Parser();
    parser.formsubtree(root,f);
    FileWriter fw3=new FileWriter("h.txt");
    p.trav(parser.template,fw3);
    fw3.close();
    p.trav1(parser.template,fw2);
   
    p.br.close();
    p.fr.close();
    f.close();
    fw2.close();
    FileReader fr=new FileReader("g.txt");
    BufferedReader br=new BufferedReader(fr);
    String  c="";
    int iindex=0,oindex=-1,startindex=0,currentindex=-1;
    String res[][]=new String[1000][1000];
    while((c=br.readLine())!=null)
    {
        startindex=0;
        currentindex=-1;
       
        oindex++;
        iindex=0;
        int last=c.lastIndexOf('-');
        do
        {
          startindex=currentindex+1;
          currentindex=c.indexOf('-',startindex);
          if(currentindex!=-1)
          res[oindex][iindex++]=c.substring(startindex,currentindex);
          else
           res[oindex][iindex++]=c.substring(startindex,c.length());   
                  
        }while(last!=startindex-1);
    }
    int i=0;
    FileWriter w=new FileWriter("a.txt");
    while(res[0][i]!=null)
    {
        int j=0;
        while(res[j][i]!=null)
        {
             w.write(res[j][i]+"               ");
            j++;
        }
        i++;
        w.write("\r\n");
    }
    w.close();
  }
  public void trav(Pat root,FileWriter fw) throws Exception
  {
     if(root!=null)
     {
     fw.write(root.tag);
     fw.write("\t\t");
     String s=Integer.toString(root.level);
     fw.write(s);
     fw.write("\t\t");
     fw.write(root.string);
     fw.write("\t\t count:");
     String s1=Integer.toString(root.count);
     fw.write(s1);
     fw.write("\t\t");
     if(root.next==null)
     fw.write("null");
     fw.write("\r\n");
     trav(root.child,fw);
     trav(root.next,fw);
     }
  }
  public void trav1(Pat root,FileWriter fw) throws Exception
  {
      if(root!=null)
      {
          if(root.count>3&&root.count!=12)
          {
              fw.write(root.string+"\r\n");
              
          }
          trav1(root.child,fw);
              trav1(root.next,fw);
      }
  }

}
 

class Parser
{
  
   Pat template=null;
   int counter_e=0;

   public Pat formsubtree(Pat root,FileWriter f) throws Exception
   {
      Pat mov=null;
      if(root.child==null)
      {
          return root;
      }
      mov=root.child;
      
      Pat set[]=new Pat[20];
      Pat subtree=null;
      int count=0;
      for(int i=0;i<20;i++)
      {
          set[i]=null;
          
      }
      if(mov!=null){
      if(mov.tag.equals("<TR>"))
      {
          for(int i=0;mov!=null;mov=mov.next)
          {
              set[i++]=mov;
               }
               for(int l=0;set[l]!=null;l++)
              set[l].next=null;
          analyser(set,f);
           
          subtree=join(set,f);
      }
      else
      {
      
          do
          {
             set[count++]=formsubtree(mov,f);
               mov=mov.next;
          } while(mov!=null);
          
           for(int l=0;set[l]!=null;l++)
              set[l].next=null;
          analyser(set,f);
           subtree=join(set,f);
      }
      }
      
      return subtree;
      
      
   }

  
public void analyser(Pat[] set,FileWriter f)    throws Exception
{
  
       
   
    for(int i=0;set[i]!=null;i++)
    {
        for(int k=i+1;set[k]!=null;k++)
        {
            
        if(traverse(set[i],set[k],f))//SEE THE DCODE
        {
            
               set[k]=null;
            for(int j=k;j<19;j++)
            {
                set[j]=set[j+1];
             }

            
            k=k-1;;
            
        }
        else
        {
//        set[0].next=temp1;
//        set[i].next=temp2;
        }
        
       
             
    
        }   
    }


}
public void trav(FileWriter fw2,Pat template) throws Exception
{
    if(template!=null)
    {
    fw2.write(template.tag);
    String s=Integer.toString(template.level);
    fw2.write(s);
    fw2.write("\r\n");
     trav(fw2,template.child);
    trav(fw2,template.next);
    }
    
}

public boolean traverse(Pat seed,Pat second,FileWriter f) throws Exception
{
   boolean bool1=false,bool2=false;
   
 
   int length1=0,length2=0;
   
    if(seed.tag.equals(second.tag)&&seed.child==null&&second.child==null)
    {
       if(seed.father==second.father)
       {
          return false;
       }
       else
       {
          return true;
       }
    }
   
   
    else if(seed!=null&&second!=null&&seed.tag.equals(second.tag))
    {
       char grid[][];
       int len1=0,len2=0;
       Pat temp3=null;
        for(Pat temp=seed.child;temp!=null;temp=temp.next)
       {
           len1++;
       }
       for(Pat temp=second.child;temp!=null;temp=temp.next)
       {
           len2++;
       }
       grid=new char[len1+1][len2+1];
       for(int i=0;i<=len1;i++)
       {
           for(int j=0;j<=len2;j++)
           {
               grid[i][j]='n';
           }
       }
       int i=1;
       int j=1;
      
       for(Pat temp1=seed.child;temp1!=null;temp1=temp1.next,i++)
       {
           j=1;
           for(Pat temp2=second.child;temp2!=null;temp2=temp2.next,j++)
           {
             bool1=false;
                     
             bool1=traverse(temp1,temp2,f);
             if(bool1==true)
             {
                 grid[i][j]='y';
             }
               
               
           }
          
               
       }
       
       Form form=new Form(grid,len1,len2);
       if(form.istree())
       {
           temp3=form.finaltree(seed.child,second.child);
           seed.child=temp3;
           
            form.t(seed);
           return true;
       }
       else
       {
           
           return false;
       }
      
    }
    
    else if(seed!=null&&second==null)
    {
         
        return true;
    }
    
    else
    {
         
        return false;
    }
    //return bool1;
}

public Pat join(Pat[] set,FileWriter f) throws Exception
{
     for(int i=0;set[i]!=null;i++)
    {


        set[i].next=set[i+1];
    }
        f.write("\r\nJOIN\r\n");
     for(int i=0;set[i]!=null;i++)
    {

    trav(f,set[i]);
    f.write("\r\n");
     }
    template=set[0].father;
    
    return template;
    
}

}


class Array
{
    public int y;
    public int distance;
    public void Array()
    {
      
    }
}

class Form
{
    public int al;
    public int bl;
    public char grid[][];
    public Array fill[][];
    public Array sel[][];
    public Array fin[][];
    public int seq;
    Pat root1;
    Pat root2;
    Pat root3;
    Pat one;
    Pat two;
    Pat three;
    public Form()
    {
        
    }
    public Form(char[][] a,int len1,int len2)
    {
        grid=new char[len1+1][len2+1];
        al=len1;
        bl=len2;
        for(int i=0;i<=len1;i++)
        {
            for(int j=0;j<=len2;j++)
            {
                grid[i][j]=a[i][j];
            }
        }
        process();
    }
    public void formgrid(Pat first,Pat second)
    {
        root1=first;
        root2=second;
         for(;first!=null;first=first.next)
        {
            al++;

        }
        for(;second!=null;second=second.next)
        {
            bl++;

        }

        grid=new char[al+1][bl+1];
        first=root1;
        second=root2;
        int j;
        for(int i=1;i<=al;i++,first=first.next)
        {
            for(second=root2,j=1;j<=bl;j++,second=second.next)
            {
                               if(first.tag.equals(second.tag))
                {
                    grid[i][j]='y';
                }
                else
                {
                    grid[i][j]='n';
                }
                
            }
        }
       
        process();
    }
    public void print()
    {

         for(int i=0;i<=al;i++)
           {
               for(int j=0;j<=bl;j++)
               {
                   
               }
               
           }

    }
    public void process()
   {
       fill=new Array[al+1][bl+1];
       sel=new Array[al+1][1];
       fin=new Array[al+1][1];
       for(int i=0;i<=al;i++)
       {
           for(int k=0;k<=bl;k++)
           {
               fill[i][k]=new Array();
           }
           sel[i][0]=new Array();
           fin[i][0]=new Array();
       }
       for(int i=1;i<=al;i++)
       {
           fillup(i);
           
       }
       select();
       
   }
    
    
   public void fillup(int i)
   {
       int x=0,y=0;
       for(int j=1;j<=bl;j++)
       {
           if(grid[i][j]=='y')
           {
               fill[i][j].y=j;
               x=i;
               y=j;
               do
               {
                   fill[i][j].distance++;
                   x++;y++;
               }while(x<=al&&y<=bl&&grid[x][y]=='y');
           }
       }
       
       
   }
   
 public void select()
   {
       boolean flag=false;
       Array temp=new Array();
       for(int i=1;i<=al;i++)
       {
           flag=false;
           sel[i][0].distance=fill[i][0].distance;
           sel[i][0].y=fill[i][0].y;
           temp=new Array();
           for(int j=1;j<=bl;j++)
           {
               flag=false;
              
               if(sel[i][0].distance<fill[i][j].distance)
               {

                   for(int k=1;k<i;k++)
                   {
                       
//                       int sum=sel[k][0].y+(sel[k][0].distance-1)-((sel[k][0].distance-1)-(i-k));
                       if(fill[i][j].y==sel[k][0].y+(sel[k][0].distance-1)-((sel[k][0].distance-1)-(i-k))&&(sel[k][0].distance-1)>(i-k))
                       {


//                           if(i==5&&j==5)

                           temp.distance=fill[i][j].distance;
                           temp.y=fill[i][j].y;
                           flag=true;
                           break;
                           
                       }
                       for(int l=0;l<sel[k][0].distance;l++)
                       {
                           if(fill[i][j].y==sel[k][0].y+l)
                           {
                               flag=true;
                               break;
                           }
                       }
                       if(fill[i][j].y<sel[k][0].y&&fill[i][j].distance<sel[k][0].distance)
                       {
                           flag=true;
                           break;
                       }
                       if(fill[i][j].distance<=temp.distance)
                       {
                           flag=true;
                           break;
                       }
                       
                   }
                   
                   if(flag)
                   {
//                       continue;
                   }
                   else
                   {
                       sel[i][0].distance=fill[i][j].distance;
                       sel[i][0].y=fill[i][j].y;
                   }
               }
           }
       }
       
       int i=1;
       while(i<=al)
       {
          fin[i][0].distance=sel[i][0].distance;
          fin[i][0].y=sel[i][0].y;
          if(sel[i][0].distance>1)
          {
              for(int j=1;j<sel[i][0].distance;j++)
              {
                  if(sel[i][0].distance<sel[i+j][0].distance)
                  {
                      fin[i][0].y=0;
                      fin[i][0].distance=0;
                      break;
                  }
              }
              
          }
          if(fin[i][0].distance==0)
          {
              i++;
          }
          else
          {
              i=i+fin[i][0].distance;
          }
          
           
       }
       
      
       
   }
 
   public boolean istree()
   {
       seq=0;
       for(int i=1;i<=al;i++)
       {
           if(fin[i][0].distance>=1)
               seq=seq+fin[i][0].distance;
       }
       
       if(seq==0)
       {
           return false;
       }
       
       int seq1=al-seq;
       if(seq>=seq1)
       {
           return true;
       }
       return false;
   }
   
   public Pat finaltree(Pat first,Pat second)
   {
     boolean flag=false;  
     one=first;
     
     two=second;

     int i=1;
     int y=1;
     
     one=first;
     two=second;
     root1=first;
     while(i<=al)
     {
         
         flag=false;
         if(fin[i][0].y==0)
         {
             insert(1,i);
             
         }
         for(int j=1;j<=al;j++)
         {
             if(fin[j][0].y==y)
             {
                 flag=true;   
                
             }
            
         }
          
//         if(flag==true) y++;
          if(!flag&&y<=bl)
         {
            
             insert(2,i);
             y++;
         }
         if(fin[i][0].y!=0)
         {
             int k=i;
             for(int j=0;j<fin[i][0].distance;j++)
             {
                
                 insert(0,k++);
                 y++;
                
             }
             i=i+fin[i][0].distance;
            
             continue;
         }
         i=i+1;
     }
     for(;y<=bl;y++)
     {
         insert(2,0);
     }
     
     return root3;
  }
   
   public void insert(int p,int i)
   {

       if(root3==null)
       {
           Pat temp=new Pat();
           if(p==0||p==1)
           {

               String buffer=one.string;
               if(p==0&&one!=null&&two!=null)
 
               {
                                     /* if(one.string.equals(two.string))
                    {
                       buffer=one.string;
                     }
                   else
                   {*/
                       buffer=one.string+"-"+two.string;
//                   }
               }
               if(p==1)
               {
                   buffer=one.string+"-*";
                  
               }
               temp.tag=one.tag;
               temp.father=one.father;
               temp.string=buffer;
               temp.child=one.child;
               temp.count=one.count+1;
               temp.level=one.level;
               temp.next=null;
           }
           if(p==2)
           {
                String buffer="";
               if(three!=null)
               for(int j=0;j<three.count;j++)
               {
                   buffer=buffer+"*";
                   if(j!=three.count-1)
                   {
                       buffer=buffer+"-";
                   }
               }
               buffer=buffer+two.string;

               temp.tag=two.tag;
               temp.father=one.father;
               temp.string=buffer;
               temp.child=two.child;
               temp.count=one.count+1;
               temp.level=two.level;
               temp.next=null;
           }
           root3=temp;
           three=root3;
           if(p==0)
           {
               if(one.next!=null)
               one=one.next;
               if(two.next!=null)
               two=two.next;
              
           }
           if(p==1)
           {
               if(one.next!=null)
               one=one.next;
           }
           if(p==2)
           {
               if(two.next!=null)
               two=two.next;
           }
       }
       else
       {
           Pat temp=new Pat();
          
           if(p==0||p==1)
           {
                   String buffer=one.string;
               if(p==0&&one!=null&&two!=null)
               {
                    
                
                       buffer=one.string+"-"+two.string;

               }
               if(p==1)
               {
                   buffer=buffer+"-*";
                   
               }
               temp.tag=one.tag;
               temp.father=one.father;
               temp.string=buffer;
               temp.child=one.child;
               temp.level=one.level;
               temp.count=root1.count+1;
               temp.next=null;
           }
           if(p==2)
           {
               
               String buffer="";
               //if(three!=null)
               for(int j=1;j<three.count;j++)
               {
                   buffer=buffer+"*";
//                   if(j!=three.count-1)
                   {
                       buffer=buffer+"-";
                   }
               }
               buffer=buffer+two.string;
               temp.tag=two.tag;
               temp.father=root1.father;
               temp.string=buffer; 
               
               temp.count=three.count;
               temp.child=two.child;
               temp.level=two.level;
               temp.next=null;
           }
           three.next=temp;
           three=three.next;
           if(p==0&&one!=null&&two!=null)
           {
               if(one.next!=null)
               one=one.next;
               if(two.next!=null)
               two=two.next;
           }
           if(p==1)
           {
               if(one.next!=null)
               one=one.next;
           }
           if(p==2)
           {
               if(two.next!=null)
               two=two.next;
           }
       }
         
   }
   
   public void t(Pat a)
   {
       if(a!=null)
	{

       t(a.child);
       t(a.next);
       }
   }


}









