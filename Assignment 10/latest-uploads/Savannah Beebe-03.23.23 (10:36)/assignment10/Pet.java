package assignment10;

class Pet
{
   private String type;
   private int age;
   private String name;
  
   public Pet(String t, int a, String n)
   {
       type= t;
       age= a;
       name= n;
   }


   public Pet()
   {
       type= "dog";
       age= 2;
       name= "spot";
   }
  
   public String getType()
   {
       return type;
   }


   public int getAge()
   {
       return age;
   }


   public String getName()
   {
       return name;
   }


   public void setType(String t)
   {
       type= t;
   }


   public void setAge(int a)
   {
       age= a;
   }


   public void setName(String n)
   {
       name= n;
   }

   public String timeLine(int aging)
   {
        if(aging>0)
        {
            return ((timeLine(aging-1)) + "\n" + aging + "years old");
        }
        else 
        {
            return ("born at 0 years old");
        }
   }


   public String toString()
   {
       return ("A " + age + "-year old " + type + " named " + name);
   }


   public boolean equals(Pet p)
   {
       if (!(name.equals(p.getName())))
       {
           return false;
       }
       if(!(age==p.getAge()))
       {
           return false;
       }
       if(!(name.equals(p.getName())))
       {
           return false;
       }
       return true;
   }
}