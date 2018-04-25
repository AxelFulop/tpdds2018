package modelo;
public class TupleDouble { 
	
	public Double x; 
    public Double y;
    
    public TupleDouble(Double x, Double y) { 
    this.x = x; 
    this.y = y; 
  } 
  
  public boolean inBetween (Double valor)
  {
	  if (valor>(Double) this.x && valor<= (Double)this.y)
		  return true;
	  else
		  return false;
	  
  }
  public Double getX()
  {
	 return (Double) this.x;
	 
  }
  public Double getY()
  {
	 return (Double) this.y;
	 
  }
} 