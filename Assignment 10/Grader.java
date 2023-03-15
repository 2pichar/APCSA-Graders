import java.lang.reflect.*;
import java.util.ArrayList;
import assignment10.*;

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
    private static Class<Object> obj_cls = Object.class;

    public static void main(String[] args) throws ClassNotFoundException{
        
        String cmd = args[0];
        Class c1 = args[1];
        Class c2, c3;
        if(args.length > 2){
            Class c2 = args[2];
            if(args.length > 3){
                Class c3 = args[3];
            }
        } else {
            c2 = c3 = null;
        }

        if(cmd.equals("inherit")){
            System.out.print(c1.getSuperclass().equals(c2));
        } else if(cmd.equals("methods")){
            Method[] mthds = c1.getDeclaredMethods();
            String[] names = new String[mthds.length];
            for(int i = 0; i < mthds.length; i++){
                names[i] = mthds[i].toString();
            }
            printJSONArr(names);
        } else if (cmd.equals("constructors")){
            System.out.print(hasConstructors(c1));
        }
    }

    public static <T> printJSONArr(T[] arr){
        System.out.print("[");
        for(int i = 0; i < arr.length - 1; i++){
            System.out.print(String.format("\"%s\",", arr[i].toString()));
        }
        System.out.print(String.format("\"%s\"]", arr[arr.length - 1].toString()));
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

        return numOverriden == numOverridenInteresting;
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