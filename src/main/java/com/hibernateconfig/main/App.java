package com.hibernateconfig.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	
        
        Address obj1 = new Address();
      
        obj1.setCity("Hyderabad");
        
        Employee obj=new Employee();
        obj.setSid(1);
        obj.setFirstname("ujjawal");
        obj.setLastname("kumar");
        obj.setAddresss(obj1);
        
 
       
        Configuration con=new  Configuration();
        con.configure().addAnnotatedClass(Employee.class);
        
        ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf =con.buildSessionFactory(reg);
        Session session= sf.openSession();
        Transaction tx=session.beginTransaction();
     
         session.save(obj);
 
         tx.commit();
        
    }
}
