/* 
**CalcClient.java : Acts as Calculator Terminal
*/ 
import CalcApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.Scanner;
import java.lang.*;

public class CalcClient
{
  static CalcInterface CalcImpl;
  static int flag=1;
  static double x=0.0d;
  static double y=0.0d;
  
  public static void main(String args[])
   {
        
    try{
                 System.out.println("\n----------------------------------------------");
System.out.println("CalcClient: Looking up CalcServer...");
           
                // create and initialize the ORB
                ORB orb = ORB.init(args, null);

                // get the root naming context
                org.omg.CORBA.Object objRef = 
                orb.resolve_initial_references("NameService");

                // Use NamingContextExt instead of NamingContext. 
                // This is part of the Interoperable naming Service.  
                NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

                // resolve the Object Reference in Naming
                String name = "CalcOperations";
                CalcImpl = CalcInterfaceHelper.narrow(ncRef.resolve_str(name));

System.out.print("CaclClient: Obtained a handle on server object: \n\n");
System.out.println(CalcImpl);

                Scanner sc=new Scanner(System.in);
      
                flag=1;

                do
                {
                System.out.print("\nCaclyClient: Enter First Number: ");
                 x=sc.nextDouble();

                System.out.print("\nCaclyClient: Enter Second Number: ");
                y=sc.nextDouble();
                System.out.println("--------------------------------------------------");
System.out.println("\nCaclClient: Addition\t= "+CalcImpl.add(x,y));
System.out.println("\nCaclClient: Subtraction\t= "+CalcImpl.subtract(x,y));
System.out.println("\nCaclClient: Multiplication\t= "+CalcImpl.multiply(x,y));
System.out.println("\nCaclClient: Division\t= "+CalcImpl.divide(x,y));
System.out.println("\nCaclClient: Random()\t= "+CalcImpl.random());

                System.out.println("--------------------------------------------------");
                System.out.println("Continue?[1:Yes|0:No]: ");
                flag=sc.nextInt();
                }
                while (flag!=0);

                CalcImpl.shutdown();
         }
            catch (Exception e) 
            {   
                 //System.err.println("ERROR: " + e);   
                 //e.printStackTrace(System.out);   
                 System.out.println("\n----------------------------------------------");
System.out.println("CalcClient: Some Error Has Occurred !");
                 System.out.println("\n----------------------------------------------");
            }

System.out.println("\nCaclServer: Exiting...");
System.out.println("\n----------------------------------------------");
        }
}
