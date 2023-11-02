package com.anufnds;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anufnds.model.Address;
import com.anufnds.model.Customer;


/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	
    	Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        try
        {
        	Customer c1=new Customer();
        	c1.setName("Soumya");
        	
        	Address a1=new Address();
        	a1.setStreet("123 street");
        	a1.setCity("Hyd");
        	a1.setCustomer(c1);
        	
        	Address a2=new Address();
        	a2.setStreet("456 street");
        	a2.setCity("Delhi");
        	a2.setCustomer(c1);
        	
        	Customer c2=new Customer();
        	c2.setName("Divya");
        	
        	Address a3=new Address();
        	a3.setStreet("789 street");
        	a3.setCity("Wgl");
        	a3.setCustomer(c2);
        	
        	Address a4=new Address();
        	a4.setStreet("143 street");
        	a4.setCity("Mumbai");
        	a4.setCustomer(c2);
        	
        	session.beginTransaction();
        	session.save(c1);
        	session.save(a1);
        	session.save(a2);
        	session.save(c2);
        	session.save(a3);
        	session.save(a4);
        	session.getTransaction().commit();
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally
        {
        	session.close();
        	factory.close();
        }
    }
}
