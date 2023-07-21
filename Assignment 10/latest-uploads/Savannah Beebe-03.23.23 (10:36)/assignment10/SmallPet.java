package assignment10;

class SmallPet extends Pet
{
   private int weight;
   private String eatsWhat;
  
   public SmallPet(int w, String e, String ty, int ag, String na)
   {
       super(ty, ag, na);
       weight = w;
       eatsWhat=e;
   }


   public SmallPet()
   {
       super("hamster", 2, "Hubert");
       weight= 3;
       eatsWhat= "pellets";
   }


   public int getWeight()
   {
       return weight;
   }


   public String eats()
   {
       return eatsWhat;
   }
  
   public String toString()
   {
       String output= super.toString();
       output+=(" weighing " + weight + " pounds that eats " + eatsWhat);
       return output;
   }


   public boolean equals(SmallPet pe)
   {
       boolean b= super.equals(pe);
       if(!b)
       {
           return false;
       }
       else
       {
           if(!(weight==pe.getWeight()))
           {
               return false;
           }
           if(!(eatsWhat.equals(pe.eats())))
           {
               return false;
           }
           return true;
       }
   }
}