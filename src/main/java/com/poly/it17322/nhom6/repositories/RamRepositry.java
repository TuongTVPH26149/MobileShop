/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.Ram;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class RamRepositry {
    public List<Ram> SelectAllRam(){
        List<Ram> listram = new ArrayList<>();
        try (Session session =HibernatUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Ram" , Ram.class);
            listram = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listram;
    }
    
    public Ram SelectRamById(UUID Id){
        Ram ram = new Ram();
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Ram where Id = :Id" , Ram.class);
            query.setParameter("Id", Id);
            ram = (Ram) query.getSingleResult();           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ram;
    }
    
    public Boolean InsertRam(Ram ram){
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(ram);
            tran.commit();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean UpdateRam(Ram ram){
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Transaction tran = session.getTransaction();
            tran.begin();
            ram.setLastModifiedDate(new Date());
            session.saveOrUpdate(ram);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
