class TestTicket{
	public static void main(String[] args){

		//create Ticket Obj
		Ticket tt=new Ticket(12728,"SAC","30/07/2022","VSKP","BZA");
	
		//Add Passengers
		Passenger[] travelers=new Passenger[6];

		travelers[0]=new Passenger("Samba",'M',(byte)40);
		travelers[1]=new Passenger("Madhavi",'F',(byte)36);
		travelers[2]=new Passenger("KoteswarRao",'M',(byte)70);
		travelers[3]=new Passenger("Santha kumari",'F',(byte)60);
		travelers[4]=new Passenger("Hiran",'M',(byte)7);
		travelers[5]=new Passenger("Sonu",'F',(byte)3);
		tt.setPassengers(travelers);
		
		tt.displayTicketDetails();
	}
}