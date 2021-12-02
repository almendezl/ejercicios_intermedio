package universidad.poo.mundo;


public class Dado
{
  // Atributos.
     private int izq=3, fro=1, der=4, pos=6, sup=2, inf=5;
	 
  // Constructores
     public Dado()
     { 
     }
	 
  // Métodos get	 
     public int getIzq() { return izq; }
     public int getFro() { return fro; }
     public int getDer() { return der; }
     public int getPos() { return pos; }
     public int getSup() { return sup; }
     public int getInf() { return inf; }
	/* 
  // Métodos set
     public void setIzq(int izq) {  }
     public void setFro(int fro) {  }
     public void setDer(int der) {  }
     public void setPos(int pos) {  }
     public void setSup(int sup) {  }
     public void setInf(int inf) {  }
    */
  // Métodos funcionales 
     public void horizontal()
     { 
    	 int auxH;
    	 auxH=pos;
    	 pos=der;
    	 der=fro;
    	 fro=izq;
    	 izq=auxH;
     }

     public void vertical()
     { 
    	 int auxV;
    	 auxV=pos;
    	 pos=inf;
    	 inf=fro;
    	 fro=sup;
    	 sup=auxV;
     }

     public void transversal()
     { 
    	 int auxT;
    	 auxT=der;
    	 der=sup;
    	 sup=izq;
    	 izq=inf;
    	 inf=auxT;
     }	 
}