package modelo;

public enum Categoria {
	R1,
	R2,
	R3,
	R4,
	R5,
	R6,
	R7,
	R8,
	R9;
	
    double cargoFijo()
	{
    	switch (this) {
        case R1:
            return 18.76;
        case R2:
        	return 35.32;
        case R3:
        	return 60.71;
        case R4:
        	return 71.74;
        case R5:
        	return 110.38;
        case R6:
        	return 220.75;
        case R7:
        	return 443.59;
        case R8:
        	return 545.96;
        case R9:	
        	return 887.19;
        default:
            throw new AssertionError("Unknown operations " + this);
    	}		
	}
    
    double cargoVariable() 
	{
		switch(this) {
		case R1:
            return 0.644;
        case R2:
        	return 0.644;
        case R3:
        	return 0.681;
        case R4:
        	return 0.738;
        case R5:
        	return 0.794;
        case R6:
        	return 0.832;
        case R7:
        	return 0.851;
        case R8:
        	return 0.851;
        case R9:	
        	return 0.851;
        default:
            throw new AssertionError("Unknown operations " + this);
		}  	
	}
	
}

