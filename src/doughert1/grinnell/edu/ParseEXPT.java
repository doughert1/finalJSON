package doughert1.grinnell.edu;

import java.util.Vector;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class ParseEXPT
{

  public Vector<Object> vec(String str)
  {
    Vector<Object> vec = new Vector<Object>();
    vec.add(parse(str));
    
  }

  public Hashtable hash(String str)
  {

  }

  public Object parse(String json)
  {
    int i = 0;
    char ind;
    boolean vector = false;
    boolean object = false;
    int vind = 0;
    boolean quote = true;
    Vector<Object> vec;
    Hashtable hash;
    
    Object full;
    while (json.length() > i)
      {
        ind = json.charAt(i);

        switch (ind)
          {
            case '[':
              {
                for (int j = i; j < json.length(); j++)
                  {
                    if (json.charAt(j) == ']')
                      {
                        i = j + 1;
                        return vec(json.substring(i, j));
                      } // if
                  } // for
                break;
              }// case [
            case '{':
              {
                for (int k = i; k < json.length(); k++)
                  {
                    if (json.charAt(k) == '}')
                      {
                        i = k + 1;
                        return hash(json.substring(i, k));
                      }
                  }
              }// case {
            case '"':
              {
                if (quote)
                  {
                    quote = false;
                  }// if it's
              }
            default:
              break;
          }// switch
        if (Character.isDigit(ind))
          {
            int k = i;
            while (k < json.length())
              {
                if (Character.isDigit(json.charAt(k)))
                  {
                    k++;
                  }
                return Double.valueOf(json.substring(i, k - 1));
              }
          }

        if (Character.isAlphabetic(ind))
          {
            if (ind == 'n')
              {
                return null;
              }
            else if (ind == 't')
              {
                return true;
              }
            else if (ind == 'f')
              {
                return false;
              }
          }
      }// while
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
