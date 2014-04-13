package doughert1.grinnell.edu;

import java.util.Stack;
import java.util.Vector;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class ParseStack
{
  public <T> Object parse(String str)
  {
    Stack<Object> myStack = new Stack<Object>();

    int i = 0;
    char ind;
    while (str.length() > i)
      {
        ind = str.charAt(i);

        switch (ind)
          {
            case '[':
              {
                myStack.push(new Group(i, '['));
                i++;
                break;
              }// case [
            case ']':
              {

              }
            case '{':
              {
                myStack.push(new Group(i, '{'));
                i++;
                break;
              }// case {
              
            case '"':
              {
                
              }
            default:
              break;
          }// switch
        if (Character.isDigit(ind))
          {
            int k = i;
            while (k < str.length())
              {
                if (Character.isDigit(str.charAt(k)))
                  {
                    k++;
                  }
                return Double.valueOf(str.substring(i, k - 1));
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

  class Group
  {
    int index;
    char ch;

    public Group(int index, char ch)
    {
      this.index = index;
      this.ch = ch;
    }

  }

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
