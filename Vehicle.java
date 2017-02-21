package encapsulation;



public class Vehicle {
	char type,fuel;
	String regnr;

public Vehicle (char type, char fuel, String regnr){
	if(checkreg(type,fuel,regnr)){
		this.type=type;
		this.fuel=fuel;
		this.regnr=regnr;
	}

}
public void setRegistrationNumber(String Nregnr){
	if(checkreg(this.type,this.fuel,Nregnr)){
		this.regnr = Nregnr;		
	}
}
	
public String getRegistrationNumber(){
	return regnr;
}
public char getVehicleType(){
	return type;
}
public char getFuelType(){
	return fuel;
}

	public boolean checkreg(char type,char fuel, String regnr){
		// type not car or motorcycle
		boolean valid=false;
				if (type=='C'||type=='M'){
					//check if M has H as fuel	
					if(fuel=='D'||fuel=='G'||fuel=='H'||fuel=='E'){
						if(type=='M' && fuel=='H'){
							throw new IllegalArgumentException("Motorcycle dont use hydrogen");
						}
						//check the first two letters in the registration number
						else{
							if(fuel=='H'){
								if(!regnr.startsWith("HY")){
								    throw new IllegalArgumentException("Registration number: "+ regnr+" is invalid, must start with HY");
								}
							}
							else if(fuel=='E'){
								if(regnr.startsWith("EL")||regnr.startsWith("EK")){
									
								}
								else{
									throw new IllegalArgumentException("Invalid registration number for E vehicles, must start with EK or EL");
								}
							}
							else{
								if(regnr.startsWith("HY")||regnr.startsWith("EK")||regnr.startsWith("EL")){
									throw new IllegalArgumentException("Invalid registration number for D/G vehicles");
								}			
							}
							//check length of registration number
							if(type=='C'){
								if(regnr.length()==7){
										if(!regnr.matches("\\p{Upper}{2}\\d{5}")){
											throw new IllegalArgumentException("Invalid registration number for cars, needs to end with 5 digits");
										}
										else{
											valid = true;
											
										}
								}
								else{
									throw new IllegalArgumentException("Invalid registration number for cars");
								}
							}			
							if(type=='M'){
									if(regnr.length()==6){
											if(!regnr.matches("\\p{Upper}{2}\\d{4}")){
												throw new IllegalArgumentException("Invalid registration number for motorcycles, need to have 4 digits");
											}
											else {
												valid = true;
											}
									}
									else{
										throw new IllegalArgumentException("Invalid registration number for motorcycles");
									}
									
							}
						}
					}
					else{
						throw new IllegalArgumentException("Invalid fuel for vehicle");
					}
				}
				else {
					throw new IllegalArgumentException("Invalid vehicle type");
				}
	return valid;	
	}
	
	public String toString(){
		return "vehicle " + type + ", fuel= " + fuel +", regnr: "+ regnr;
	}
	public static void main(String[] args){
		Vehicle mc = new Vehicle('M','H',"DC89076");
		System.out.println(mc);
	}
}



