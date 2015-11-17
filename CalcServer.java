/* 
**CalcServer.java : Acts as Calculator Server 
*/  
import CalcApp.*;  
import org.omg.CosNaming.*;  
import org.omg.CosNaming.NamingContextPackage.*;  
import org.omg.CORBA.*;  
import org.omg.PortableServer.*;  
import org.omg.PortableServer.POA;  
import java.util.Properties;  
  
class CalcInterfaceImpl extends CalcInterfacePOA  // This is the servant class  
{  
    private ORB orb;  
  
    public void setORB(ORB orb_val)   
    {     
        orb = orb_val;  
    }  
  
    /* List of functions specified in IDL file 
        string add(in double x, in double y); 
        string subtract(in double a, in double b); 
        string multiply(in double x, in double y); 
        string divide(in double a, in double b); 
        string random(); 
        oneway void shutdown(); 
         
     if IDL file would have following function 
     void multiply(in double x, in double y, out double result); 
     then implement it here like 
      
    public void multiply(double x, double y, org.omg.CORBA.DoubleHolder result)  
    {   
      result.value = x * y;   
    } 
    */  
  
    //implement add(double,double) method  
    public String add(double x, double y)  
    {  
        double res= x+y;  
        return Double.toString(res);  
    }  
  
    // implement subtract(double,double) method  
    public String subtract(double x, double y)  
    {  
        double res= x-y;  
        return Double.toString(res);  
    }  
  
    // implement multiply(double,double) method  
    public String multiply(double x, double y)  
    {  
        double res= x*y;  
        return Double.toString(res);  
    }  
  
    // implement divide(double,double) method  
    public String divide(double x, double y)  
    {  
        double res= x/y;  
        return Double.toString(res);  
    }  
      
    // implement random() method  
    public String random()   
    {  
        double res=Math.random();  
        return Double.toString(res);  
    }  
  
    // implement shutdown() method  
    public void shutdown()  
    {  
            orb.shutdown(false);  
    }  
}  
  
  /*
  CALC SERVER BEGINS
  */
public class CalcServer  
{  
    public static void main(String args[])   
   {  
  
    try{  
         // Create and initialize the ORB    
         ORB orb = ORB.init(args, null);    
          
        // get reference to rootpoa & activate the POAManager  
        POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));  
        rootpoa.the_POAManager().activate();  
  
        // create servant and register it with the ORB  
        CalcInterfaceImpl CalcImpl = new CalcInterfaceImpl();  
        CalcImpl.setORB(orb);  
  
        // get object reference from the servant  
        org.omg.CORBA.Object ref = rootpoa.servant_to_reference(CalcImpl);  
        CalcInterface href = CalcInterfaceHelper.narrow(ref);  
  
        // get the root naming context  
      org.omg.CORBA.Object objRef =orb.resolve_initial_references("NameService");  
  
        // Use NamingContextExt which is part of the Interoperable  
        // Naming Service (INS) specification.  
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);  
  
        // bind the Object Reference in Naming  
        String name = "CalcOperations";  
        NameComponent path[] = ncRef.to_name( name );  
        ncRef.rebind(path, href);  
       System.out.println("\n----------------------------------------------");  
       System.out.println("CalcServer: Ready and waiting...");  
       System.out.println("\n----------------------------------------------");  
  
        // wait for invocations from clients  
        orb.run();  
        }  
            catch (Exception e)   
            {     
               //System.err.println("ERROR: " + e);     
               //e.printStackTrace(System.out);     
  
       System.out.println("\n----------------------------------------------");  
       System.out.println("CalcServer: Some Error Has Occurred !");  
       System.out.println("\n----------------------------------------------");  
            }  
      System.out.println("\nCaclServer: Exiting...");  
     System.out.println("\n----------------------------------------------");  
        }  
    }  