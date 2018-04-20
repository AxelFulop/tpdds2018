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
    
    double cargoVariable() //TODO:Hacer
	{
		return 0;
    	
	}
	
}

