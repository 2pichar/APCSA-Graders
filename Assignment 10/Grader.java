import java.lang.reflect.*;
import java.util.ArrayList;
import assignment10.*;

class Util {
    public static <T> T[] toArray(final ArrayList<T> arr){
        if (arr == null || arr.isEmpty()){
            return null;
        }
        final T t = arr.get(0);
        @SuppressWarnings("unchecked")
        final T[] res = (T[]) Array.newInstance(t.getClass(), arr.size());
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
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
    public static <T extends Member> T[] filter_out(T[] methods, Class cls){
        ArrayList<T> tmp = new ArrayList<T>();
        for(int i = 0; i < methods.length; i++){
            if (!methods[i].getDeclaringClass().equals(cls)){
                tmp.add(methods[i]);
            }
        }
        return Util.toArray(tmp);
    }
    public static <T extends Member> T[] filter_in(T[] methods, Class cls){
        ArrayList<T> tmp = new ArrayList<T>();
        for(int i = 0; i < methods.length; i++){
            if(methods[i].getDeclaringClass().equals(cls)){
                tmp.add(methods[i]);
            }
        }
        return Util.toArray(tmp);
    }
    public static <T extends Member> boolean arr_contains_by_name(T[] methods, String name){
        if (methods == null || methods.length == 0){
            return false;
        }
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
        Class<?> c1 = Class.forName("assignment10." + args[1]);
        Class<?> c2;
        c2 = null;
        if(args.length > 2){
            c2 = Class.forName("assignment10." + args[2]);
        }

        if(cmd.equals("inherit")){
            System.out.print(c1.getSuperclass().equals(c2));
        } else if(cmd.equals("methods")){
            Method[] mthds = c1.getDeclaredMethods();
            String[] names = new String[mthds.length];
            for(int i = 0; i < mthds.length; i++){
                names[i] = mthds[i].getName();
            }
            printJSONArr(names);
        } else if (cmd.equals("constructors")){
            System.out.print(hasConstructors(c1));
        } else if(cmd.equals("grade")){
            // Grade the Inheritance, Constructors, Overriding, & Unique Methods sections
            Class parent = c1;
            Class child = c2;
            // Inheritance
            boolean inherits = child.getSuperclass().equals(parent);

            // Constructors
            boolean hasConstructors = hasConstructors(parent) && hasConstructors(child);

            // Overriding
            boolean overrides = overridesMethods(child, parent);

            // Unique Methods
            boolean hasUniqueMethods = hasUniqueMethods(child);

            // Unique Variables
            boolean hasUniqueVariables = hasUniqueVariables(parent) && hasUniqueVariables(child);

            System.out.println(String.format("{\"inherits\":%s,\"constructors\":%s,\"overrides\":%s,\"uniqueMethods\":%s,\"uniqueVars\":%s}", inherits, hasConstructors, overrides, hasUniqueMethods, hasUniqueVariables));
        }
    }

    public static <T> void printJSONArr(T[] arr){
        System.out.print("[");
        for(int i = 0; i < arr.length - 1; i++){
            System.out.print(String.format("\"%s\",", arr[i].toString()));
        }
        System.out.print(String.format("\"%s\"]", arr[arr.length - 1].toString()));
    }
    public static boolean hasUniqueVariables(Class cls){
        Field[] fields = cls.getDeclaredFields();
        Field[] inherited = Util.filter_out(cls.getFields(), cls);
        int numUnique = 0;
        for(Field fld : fields){
            if(Util.arr_contains_by_name(inherited, fld.getName())){ // inherited field
                continue;
            }
            numUnique++;
        }
        return numUnique >= 2;
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
    public static boolean hasUniqueMethods(Class cls){
        Method[] methods = cls.getDeclaredMethods();
        Method[] inherited = Util.filter_out(cls.getMethods(), cls);
        int numUnique = 0;
        for(Method mthd : methods){
            if(Util.arr_contains_by_name(inherited, mthd.getName())){ // inherited method
                continue;
            }
            numUnique++;
        }
        return numUnique >= 1;
    }
    public static boolean overridesMethods(Class sub, Class sup){
        Method[] inheritedMethods = Util.filter_out(sup.getMethods(), obj_cls);
        Method[] declared = sub.getDeclaredMethods();

        int numOverriden = 0;

        for(Method inherited : inheritedMethods){
            if (Util.arr_contains_by_name(declared, inherited.getName())){
                numOverriden++;
            }
        }

        return numOverriden >= 1;
    }
}