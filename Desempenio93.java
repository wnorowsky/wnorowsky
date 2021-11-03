import hsa.Console;
class Desempenio93
{
    static Console c;
    float [] vector1;
    float [] vector2;
    
    Desempenio93()
    {
    vector1 = new float [10];
    vector2 = new float [10];
    }
    
    // all programmed in ReadytoProgram JAVA IDE in the first semester of the degree
    
    void cargaVector()
    {
	for(int i=0; i < vector1.length; i++)
	{
	c.println("Ingrese un valor para el primer vector: ");
	vector1[i] = c.readFloat();
	c.println("Ingrese un valor para el segundo vector: ");
	vector2[i] = c.readFloat();
	}
    }
    
    int mayor(float [] vector)
    {
    float mayor = vector[0];
    int p = 0;
	for (int i = 1; i < vector.length; i++)
	{
	    if(vector[i] > mayor)
	    {
	    mayor = vector[i];
	    p = i;
	    }
	}
    return p;
    }
    
    void impresion()
    {
    int p1;
    int p2;
    p1 = mayor(vector1);
    p2 = mayor(vector2);
    c.println("El mayor elemento del vector1 es: " + vector1[p1]);
    c.println("El mayor elemento del vector2 es: " + vector2[p2]);
    }
    

    
    public static void main (String arg[])
    {
    c = new Console();
    Desempenio93 d = new Desempenio93();
    d.cargaVector();
    c.clear();
    d.impresion();
    }
  
    
}
