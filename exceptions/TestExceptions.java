class TestExceptions{
   public static void main(String[] args){
   try{

	int x,y,z;
	x=Integer.parseInt(args[0]);	
	y=Integer.parseInt(args[1]);
	z=x/y;
	System.out.println("Output is "+z);

  
   }catch(NumberFormatException  nex){
	  System.out.println("Invalid Input given");   
      }catch(ArithmeticException aex){
	  System.out.println("Denominator cannot be zero");
      } catch(ArrayIndexOutOfBoundsException aex){
	  System.out.println("Inputs are missing");
      } catch(Exception ex){
	  System.out.println("Error Message :"+ex.getMessage());
	  ex.printStackTrace();	
    }
  }
}