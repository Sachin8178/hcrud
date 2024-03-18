package edu.sachin.module;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class crud {

	public static void main(String[] args) {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("sachin");
           EntityManager em = emf.createEntityManager();
          EntityTransaction et = em.getTransaction();
          boolean j=true;
         Scanner sc=new Scanner(System.in);
        
         while(j==true)
          {
        	 System.out.println("enter your choise");
        	 System.out.println("1:perform insert operation");
        	 System.out.println("2: perform the delete operation");
        	 System.out.println("3: perform the update operation");
        	 System.out.println("4: perform the find operation");
        	 System.out.println("5: exit");
        	 System.out.println("enter:..");
        	 int x=sc.nextInt();
        	
        	 if(x==1)//insert
        	 {
        	et.begin();
        	studentdetails sd=new studentdetails();
        	System.out.println("enter the student id");
        	int id=sc.nextInt();
        	System.out.println("enter the student name");
        	sc.nextLine();
        	String name=sc.nextLine();
        	System.out.println("enter the student email");
        
        	String email=sc.nextLine();
        	System.out.println("enter the student phone no");
        	long phone=sc.nextLong();
        	System.out.println("enter the student age");
        	int age=sc.nextInt();
        	sd.setSid(id);
        	sd.setSname(name);
        	sd.setSemail(email);
        	sd.setSphone(phone);
        	sd.setAge(age);
 
           em.persist(sd);
           et.commit();
             
        	 }
        	 
        	 if(x==2)//remove data
        	 {
        		 et.begin();
        		 System.out.println("enter the student id");
             	int id=sc.nextInt();
        		 studentdetails st = em.find(studentdetails.class, id);
        		 em.remove(st);
        		 et.commit();
        	 }
        	 if(x==3)//update
        	 {
        		et.begin();
        		 System.out.println("enter the student id whome detail you want to update");
              	int id=sc.nextInt();
              	 studentdetails st = em.find(studentdetails.class, id);
        		System.out.println("what you want to update");
        		System.out.println("1:name");
        		System.out.println("2:email");
        		System.out.println("3:phone no");
        		System.out.println("4:age");
        		System.out.println("5:all");
        		System.out.println("enter:");
        	   int u=sc.nextInt();
        	   if(u==1) {
        		 
               	System.out.println("enter the student name");
               	sc.nextLine();
               	String name=sc.nextLine();
               	st.setSname(name);
               em.merge(st);
               et.commit();
               	
        	   }
        	   if(u==2) {
        		   System.out.println("enter the student email");
        		   sc.nextLine();
                  	String email=sc.nextLine();
                  	st.setSemail(email);
                  	 em.merge(st);
                     et.commit();
        	   } 
        	   if(u==3) {
        			System.out.println("enter the student phone no");
                   	long phone=sc.nextLong();
                   	st.setSphone(phone);
                    em.merge(st);
                    et.commit();
        	   }
        	   if(u==4) {
        		   System.out.println("enter the student age");
                  	int age=sc.nextInt();
                  	st.setAge(age);
                  	 em.merge(st);
                     et.commit();
        	   }
        	   if(u==5) {
        		   System.out.println("enter the student name");
        		   sc.nextLine();
               	String name=sc.nextLine();
               	System.out.println("enter the student email");
               
               	String email=sc.nextLine();
               	System.out.println("enter the student phone no");
               	long phone=sc.nextLong();
               	System.out.println("enter the student age");
               	int age=sc.nextInt();
               	st.setSname(name);
            	st.setSemail(email);
            	st.setSphone(phone);
            	st.setAge(age);
                em.merge(st);
                et.commit();
        	   }
        	 }
        	 
        	 if(x==4)//find
        	 {
        		System.out.println("1:find detail of perticular user");
        		System.out.println("2:display all the user detail");
        		System.out.println("enter the number");
        		int f=sc.nextInt();
        		if(f==1)
        		{
        		System.out.println("enter the student id");
             	int id=sc.nextInt();
        		// studentdetails st = em.find(studentdetails.class, id);
             	studentdetails st=em.getReference(studentdetails.class, id);
        		 System.out.println("name    :"+st.getSname());
        		 System.out.println("email   :"+st.getSemail());
        		 System.out.println("phone no:"+st.getSphone());
        		 System.out.println("age     :"+st.getAge());
        		}
        		if(f==2)
        		{
        			Query q = em.createQuery("select s from studentdetails" );
        			List<studentdetails> list = q.getResultList();
        			for(studentdetails st: list)
        			{
        				 System.out.println("id      :"+st.getSid());
        				 System.out.println("name    :"+st.getSname());
                		 System.out.println("email   :"+st.getSemail());
                		 System.out.println("phone no:"+st.getSphone());
                		 System.out.println("age     :"+st.getAge());
        			}
        		}
        	 }
        	 if(x==5)//exit
        	 {
        		 j=false;
        	 }
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
          }

	}

}
