package doughert1.grinnell.edu;

import java.util.Vector;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class Parse
{
  public Vector<Object> vec(String str)
  {
    Vector<Object> vec = new Vector<Object>();
    vec.add(parse(str));
    //STUB
    return null;
 
  }//vec(String)

  public Hashtable hash(String str)
  {
    //STUB
    return null;

  }//hash(String)
  
  public String quote(String str)
  {
   //STUB
    return null;
  }//quote(String)
  
  
  public Object parse(String json)
  {
    Object fin;
    
    char begin = json.charAt(0);
    switch(begin)
    {
      case '[':
      {
        fin = vec(json.substring(1));
        break;
      }//case [
      
      case '{':
      {
        fin = hash(json.substring(1));
        break;
      }//case {
      
      case '"':
      {
        fin = quote(json.substring(1));
        break;
      }//case "
      
      case 'n':
      {
        return null;
      }//case n
      
      case 't':
      {
        return true;
      }//case t
      
      case 'f':
      {
        return false;
      }//case f
      default:
        break;
    }//switch
    
    
    return fin;
  }//parse(String)

}//class parse
