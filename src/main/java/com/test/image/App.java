package com.test.image;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Address op=new Address();
        op.setCity("delhi");
        op.setStreet("7 main");
        op.setOpen(true);
        op.setAddedDate(new Date());
        op.setX(45.56);
        FileInputStream fis=new FileInputStream("src/main/java/pic.jpg");
        byte [] data=new byte[fis.available()];
        fis.read(data);
        op.setImage(data);
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Transaction  tx= session.beginTransaction();
        session.save(op);
        Address l=(Address)session.get(Address.class, 2);
        System.out.println(l.getCity());
        tx.commit();
        

    }
}
