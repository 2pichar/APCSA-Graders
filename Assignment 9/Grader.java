import java.lang.reflect.*;
import java.util.ArrayList;
import assignment9.*;

class Util {
    public static <T> void arr_print(T[] arr, boolean curly){
        String lBrac = "";
        String rBrac = "";
        if(curly){
            lBrac = "{";
            rBrac = "}";
        } else {
            lBrac = "[";
            rBrac = "]";
        }
        System.out.print(lBrac);
        for(int i = 0; i < arr.length - 1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + rBrac);
    }
    public static Method[] filter_out(Method[] methods, Class cls){
        ArrayList<Method> tmp = new ArrayList<Method>();
        for(int i = 0; i < methods.length; i++){
            if (!methods[i].getDeclaringClass().equals(cls)){
                tmp.add(methods[i]);
            }
        }
        Method[] out = new Method[tmp.size()];
        return tmp.toArray(out);
    }
    public static Method[] filter_in(Method[] methods, Class cls){
        ArrayList<Method> tmp = new ArrayList<Method>();
        for(int i = 0; i < methods.length; i++){
            if(methods[i].getDeclaringClass().equals(cls)){
                tmp.add(methods[i]);
            }
        }
        Method[] out = new Method[tmp.size()];
        return tmp.toArray(out);
    }
    public static <T extends Member> boolean arr_contains_by_name(T[] methods, String name){
        for(T m : methods){
            if(m.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}

public class Grader {
    private static int numInteresting = 2;
    private static int numOverridenInteresting = 1;
    private static int numParentFields = 2;
    private static int numChildFields = 1;
    
    private static Class<Object> obj_cls = Object.class;

    public static void main(String[] args) throws ClassNotFoundException{
        if(args[0].startsWith("people=")){
            int numPeople = Integer.parseInt(args[0].substring(7));
            if(numPeople == 2){
                numInteresting = 3;
                numParentFields = 3;
                numChildFields = 2;
                numOverridenInteresting = 2;
            }
        }

        Class top = Class.forName("assignment9." + args[1]);
        Class mid = Class.forName("assignment9." + args[2]);
        Class bot = Class.forName("assignment9." + args[3]);

        System.out.println("Do the three classes have both default and parameter constructors?");
        System.out.println(top.getName() + ": " + hasConstructors(top));
        System.out.println(mid.getName() + ": " + hasConstructors(mid));
        System.out.println(bot.getName() + ": " + hasConstructors(bot));

        System.out.println();
        System.out.println("Does each class have the correct number of fields?");
        System.out.println(top.getName() + ": " + (top.getDeclaredFields().length >= numParentFields));
        System.out.println(mid.getName() + ": " + (mid.getDeclaredFields().length >= numChildFields));
        System.out.println(bot.getName() + ": " + (bot.getDeclaredFields().length >= numChildFields));

        System.out.println();
        System.out.println("Does each class have the correct number of accessors and mutators?");
        System.out.println(top.getName() + ": " + (hasAccessorMutators(top)));
        System.out.println(mid.getName() + ": " + (hasAccessorMutators(mid)));
        System.out.println(bot.getName() + ": " + (hasAccessorMutators(bot)));

        System.out.println();
        System.out.println("Does each class have the correct number of 'interesting' methods?");
        System.out.println(top.getName() + ": " + (getInterestingMethods(top).length >= numInteresting));
        System.out.println(mid.getName() + ": " + (getInterestingMethods(mid).length >= numInteresting));
        System.out.println(bot.getName() + ": " + (getInterestingMethods(bot).length >= numInteresting));

        System.out.println();
        System.out.println("Do the two child classes override the correct number of 'interesting' methods?");
        System.out.println(mid.getName() + ": " + overridesMethods(mid, top));
        System.out.println(bot.getName() + ": " + overridesMethods(bot, mid));

        System.out.println();
        System.out.println("Do the three classes have required object methods (equals, toString)?");
        System.out.println(top.getName() + ": " + hasObjMethods(top));
        System.out.println(mid.getName() + ": " + hasObjMethods(mid));
        System.out.println(bot.getName() + ": " + hasObjMethods(bot));
        
        System.out.println();
        System.out.println("Are the three classes inherited from each other?");
        System.out.println(bot.getName() + " -> " + mid.getName() + ": " + bot.getSuperclass().equals(mid));
        System.out.println(mid.getName() + " -> " + top.getName() + ": " + mid.getSuperclass().equals(top));
    }
    public static boolean hasObjMethods(Class cls){
        Method[] arr = cls.getDeclaredMethods();
        boolean hasEquals = false;
        boolean hasToString = false;
        for(Method m : arr){
            if(m.getName().equals("toString")){
                hasToString = true;
            } else if(m.getName().equals("equals")){
                hasEquals = true;
            }
        }
        return hasEquals && hasToString;
    }
    public static boolean hasConstructors(Class cls){
        Constructor[] arr = cls.getConstructors();
        boolean hasDefault = false;
        boolean hasParam = false;
        for(Constructor c : arr){
            if(c.getParameterCount() == 0){
                hasDefault = true;
            } else {
                hasParam = true;
            }
        }
        return hasDefault && hasParam;
    }
    public static Method[] getInterestingMethods(Class cls){
        Method[] methods = cls.getDeclaredMethods();
        Method[] inherited = Util.filter_out(Util.filter_out(cls.getMethods(), cls), obj_cls);
        int numInteresting = 0;
        ArrayList<Method> interesting = new ArrayList<Method>();
        for(Method mthd : methods){
            if(Util.arr_contains_by_name(inherited, mthd.getName())){ // inherited method
                continue;
            } else if(mthd.getName().startsWith("get") || mthd.getName().startsWith("set")){ // accessor/mutator
                 continue;
            } else if(mthd.getName().equals("equals") || mthd.getName().equals("toString")){
                continue;
            }
            numInteresting++;
            interesting.add(mthd);
        }
        return interesting.toArray(new Method[numInteresting]);
    }
    public static boolean overridesMethods(Class sub, Class sup){
        Method[] interestingInherited = getInterestingMethods(sup);
        Method[] declared = sub.getDeclaredMethods();

        int numOverriden = 0;

        for(Method inherited : interestingInherited){
            if (Util.arr_contains_by_name(declared, inherited.getName())){
                numOverriden++;
            }
        }

        return numOverriden >= numOverridenInteresting;
    }
    public static boolean hasAccessorMutators(Class cls){
        Field[] fields = cls.getDeclaredFields();
        Method[] methods = cls.getDeclaredMethods();
        int numAccessorMutators = 0;
        methodsIter: for(int i = 0; i < methods.length; i++){
            String name = methods[i].getName();
            if (name.startsWith("set") || name.startsWith("get")){
                numAccessorMutators++;
                continue methodsIter;
            }
            for (int j = 0; j < fields.length; j++){
                if(name.contains(fields[j].getName())){
                    numAccessorMutators++;
                    continue methodsIter;
                }
            }
        }
        return numAccessorMutators >= fields.length * 2;
    }
}