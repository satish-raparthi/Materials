
import java.lang.reflect.*;
import java.util.Arrays;
 
public class ReflectionExample {
    public static void main(String[] args) {

			Class act=Account.class;
 
        try {

            // Obtain the class object if we know the name of the class
            //Class act = Class.forName("Account");

            // get the simple name of the class 
            String actName = act.getSimpleName();
            System.out.println("Class Name is: " + actName);
 
            // get the package name of the class
            Package actPackage = act.getPackage();
            System.out.println("Package Name is: " + actPackage);
 
            // get all the constructors of the class
            Constructor[] constructors = act.getConstructors();
            System.out.println("Constructors are: "  + Arrays.toString(constructors));
 
            // initializing an object of the Account class
            //Account a1= (Account)constructors.newInstance(101,"ABC",40000);
            //Account a1= (Account)act.newInstance(40000);
			  Account a1=new Account(101,"ABC",40000);
 
            // get deposit method with specific name and parameters
            Method depMethod = act.getMethod("deposit",
                    new Class[] {Double.TYPE });
            System.out.println("Method is: " + depMethod);
 
            // call deposit method with parameter int
            depMethod.invoke(a1,5000);
 
            // get all the parameters of deposit
            Class[] parameterTypes = depMethod.getParameterTypes();
            System.out.println("Parameter types of deposit() are: "
                    + Arrays.toString(parameterTypes));
 
            // get the return type of depsoit
            Class returnType = depMethod.getReturnType();
            System.out.println("Return type is: " + returnType);
 
            // gets all the public member fields of the class Account
            Field[] fields = act.getFields();
 
            System.out.println("Public Fields are: ");
            for (Field afield : fields) {

                // get public field name
               // Field afield = act.getField(field.getName());
                String fieldname = afield.getName();
                System.out.println("Fieldname is: " + fieldname);
 
                // get public field type
                Object fieldType = afield.getType();
                System.out.println("Type of field " + fieldname + " is: "
                        + fieldType);
 
                // get public field value
                 Object value = afield.get(a1);
                 System.out.println("Value of field " + fieldname + " is: "  + value);
 
            }
 
            // How to access private member fields of the class
 
            // getDeclaredField() returns the private field
            Field privateField = Account.class.getDeclaredField("balance");
 
            String name = privateField.getName();
            System.out.println("One private Fieldname is: " + name);
            // makes this private field instance accessible
            // for reflection use only, not normal code
            privateField.setAccessible(true);
 
            // get the value of this private field
            String fieldValue = (String) privateField.get(a1);
            System.out.println("fieldValue = " + fieldValue);
 
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        //} catch (InstantiationException e) {
          //  e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}