package CalcApp;


/**
* CalcApp/CalcInterfacePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalcInterface.idl
* Tuesday, November 17, 2015 9:23:03 PM CET
*/

public abstract class CalcInterfacePOA extends org.omg.PortableServer.Servant
 implements CalcApp.CalcInterfaceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("add", new java.lang.Integer (0));
    _methods.put ("subtract", new java.lang.Integer (1));
    _methods.put ("multiply", new java.lang.Integer (2));
    _methods.put ("divide", new java.lang.Integer (3));
    _methods.put ("random", new java.lang.Integer (4));
    _methods.put ("shutdown", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CalcApp/CalcInterface/add
       {
         double x = in.read_double ();
         double y = in.read_double ();
         String $result = null;
         $result = this.add (x, y);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // CalcApp/CalcInterface/subtract
       {
         double a = in.read_double ();
         double b = in.read_double ();
         String $result = null;
         $result = this.subtract (a, b);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // CalcApp/CalcInterface/multiply
       {
         double x = in.read_double ();
         double y = in.read_double ();
         String $result = null;
         $result = this.multiply (x, y);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // CalcApp/CalcInterface/divide
       {
         double a = in.read_double ();
         double b = in.read_double ();
         String $result = null;
         $result = this.divide (a, b);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 4:  // CalcApp/CalcInterface/random
       {
         String $result = null;
         $result = this.random ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 5:  // CalcApp/CalcInterface/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CalcApp/CalcInterface:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public CalcInterface _this() 
  {
    return CalcInterfaceHelper.narrow(
    super._this_object());
  }

  public CalcInterface _this(org.omg.CORBA.ORB orb) 
  {
    return CalcInterfaceHelper.narrow(
    super._this_object(orb));
  }


} // class CalcInterfacePOA
