package CalcApp;

/**
* CalcApp/CalcInterfaceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalcInterface.idl
* Tuesday, November 17, 2015 9:23:03 PM CET
*/

public final class CalcInterfaceHolder implements org.omg.CORBA.portable.Streamable
{
  public CalcApp.CalcInterface value = null;

  public CalcInterfaceHolder ()
  {
  }

  public CalcInterfaceHolder (CalcApp.CalcInterface initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalcApp.CalcInterfaceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalcApp.CalcInterfaceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalcApp.CalcInterfaceHelper.type ();
  }

}