import hsa.Console;
class Desempenio94
{
    static Console c;
    int [] vector;
    
    Desempenio94()
    {
    vector = new int [20];
    }
    
    // all programmed in ReadytoProgram JAVA IDE in the first semester of the degree
    
    void cargaVector()
    {
	for(int i=0; i < vector.length; i++)
	{
	c.println("Carga el elemento numero: [" + (i+1) + "]");
	vector[i] = c.readInt();
	}
    }
    
    void ordenar (int [] vector)
    {
    int aux;
	for(int k = 1; k < vector.length; k++)
	{
	    for(int i=0; i < vector.length - k; i++)
	    {
		if(vector[i] < vector[i+1])
		{
		aux = vector[i];
		vector[i] = vector[i+1];
		vector[i+1] = aux;
		}
	    }
	}
    }
    
    void impresion()
    {
    ordenar(vector);
	for(int i=0; i < vector.length; i++)
	{
	c.print(vector[i] + " ");
	}
    }

    
    public static void main (String arg[])
    {
    c = new Console();
    Desempenio94 d = new Desempenio94();
    d.cargaVector();
    c.clear();
    d.impresion();
    }
  
    
}
