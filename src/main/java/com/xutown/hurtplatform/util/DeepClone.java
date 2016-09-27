package com.xutown.hurtplatform.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 通过序列化对象进行深度克隆 对象必须是实现可序列化接口的
 * 
 * @author kangming.ning
 * 
 * */
public class DeepClone{

  /**
   * deepClone the Object
   * */
  public static Object deepClone(Object src){
	  
    Object o = null;
    try{
    	
      if (src != null){
    	  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(src);
        oos.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        o = ois.readObject();
        ois.close();
      }
    }catch (IOException e){
      e.printStackTrace();
    }catch (ClassNotFoundException e){
      e.printStackTrace();
    }
    return o;
  }
}
