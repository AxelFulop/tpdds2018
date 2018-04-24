package modelo;
public class Tuple<X, Y> { 
  public final X x; 
  public final Y y; 
  public Tuple(X x, Y y) { 
    this.x = x; 
    this.y = y; 
  } 
  
  public boolean inBetween (Float valor)
  {
	  if (valor>(Float) this.x && valor<= (Float)this.y)
		  return true;
	  else
		  return false;
	  
  }
} 